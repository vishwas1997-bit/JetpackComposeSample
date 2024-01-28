package com.example.jetpackcompose.netclan.component

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.example.jetpackcompose.netclan.NetclanViewModel
import com.example.jetpackcompose.netclan.domain.model.IndividualExploreModel
import com.example.jetpackcompose.ui.font.robotoFamily

@Composable
fun ExploreIndividual(viewModel: NetclanViewModel) {
    val exploreItem: LazyPagingItems<IndividualExploreModel> =
        viewModel.individualExplore.collectAsLazyPagingItems()
    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
        Column {
            NetclanAppBar()
            LazyColumn(contentPadding = PaddingValues(vertical = 2.dp)) {
//                item { Spacer(modifier = Modifier.padding(4.dp)) }

                items(exploreItem.itemCount) { index ->
                    ExploreIndividualItem(data = exploreItem[index]!!)
                }

                exploreItem.apply {
                    when {
                        loadState.refresh is LoadState.Loading -> {
                            item { PageLoader(modifier = Modifier.fillParentMaxSize()) }
                        }

                        loadState.append is LoadState.Loading -> {
                            item { LoadingNextPageItem(modifier = Modifier) }
                        }

                        loadState.append is LoadState.Error -> {

                        }
                    }
                }

//                item { Spacer(modifier = Modifier.padding(4.dp)) }
            }
        }
    }
}

@Composable
fun ExploreIndividualItem(data: IndividualExploreModel) {
    val context = LocalContext.current.applicationContext
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        val (cardView, surfacePic) = createRefs()

        val gdStart = createGuidelineFromStart(0.04f)
        val gdStartCardView = createGuidelineFromStart(0.08f)
        val colorInvite: Color = if (data.invitationStatus == "+ Invite") {
            Color(0xFF133D59)
        } else {
            Color.Gray
        }
        Card(
            modifier = Modifier.constrainAs(cardView) {
                top.linkTo(parent.top)
                end.linkTo(parent.end)
                start.linkTo(gdStartCardView)
                width = Dimension.fillToConstraints
            },
            backgroundColor = Color.White,
            elevation = 2.dp,
            shape = RoundedCornerShape(
                24.dp
            )
        ) {
            ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
                val gdForName = createGuidelineFromStart(0.21f)

                val (invite, userName, location, distance, progressbar, purpose, bio, wishList) = createRefs()

                Text(
                    text = data.invitationStatus,
                    modifier = Modifier
                        .constrainAs(invite) {
                            top.linkTo(parent.top, 12.dp)
                            end.linkTo(parent.end, 16.dp)
                        }
                        .clickable {
                            data.invitationStatus = "Pending"
                        },
                    color = colorInvite,
                    fontFamily = robotoFamily, fontWeight = FontWeight.Medium
                )

                Text(
                    text = data.name,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Left,
                    color = Color(0xFF133D59),
                    maxLines = 1,
                    modifier = Modifier.constrainAs(userName) {
                        start.linkTo(gdForName)
                        top.linkTo(invite.bottom)
                    }, fontFamily = robotoFamily, fontWeight = FontWeight.Medium
                )

                Text(
                    text = data.place,
                    fontSize = 14.sp,
                    modifier = Modifier.constrainAs(location) {
                        start.linkTo(gdForName)
                        top.linkTo(userName.bottom)
                    },
                    color = Color(0XFF42647A),
                    fontFamily = robotoFamily,
                    fontWeight = FontWeight.Medium
                )

                Text(
                    text = data.distance,
                    color = Color(0xFF133D59),
                    modifier = Modifier.constrainAs(distance) {
                        top.linkTo(location.bottom, 2.dp)
                        start.linkTo(location.start)
                    }, fontFamily = robotoFamily, fontWeight = FontWeight.Medium
                )

                Surface(shape = RoundedCornerShape(16.dp), modifier = Modifier
                    .width(120.dp)
                    .height(12.dp)
                    .constrainAs(progressbar) {
                        top.linkTo(distance.bottom, 8.dp)
                        start.linkTo(userName.start)
                    }) {
                    LinearProgressIndicator(
                        backgroundColor = Color(0XFFD0D8DE),
                        color = Color(0XFF74858F),
                        progress = data.profileScore
                    )
                }

                Text(
                    text = data.purposes,
                    modifier = Modifier
                        .constrainAs(purpose) {
                            top.linkTo(progressbar.bottom)
                            start.linkTo(parent.start)
                        }
                        .padding(start = 32.dp, top = 16.dp),
                    color = Color(0xFF133D59),
                    fontFamily = robotoFamily, fontWeight = FontWeight.Medium,
                    fontSize = 14.sp
                )

                Text(
                    text = data.wishList,
                    modifier = Modifier
                        .constrainAs(wishList) {
                            top.linkTo(purpose.bottom)
                            start.linkTo(purpose.start)
                        }
                        .padding(start = 32.dp, bottom = 16.dp),
                    maxLines = 2,
                    color = Color(0XFF42647A), fontSize = 14.sp,
                    fontFamily = robotoFamily, fontWeight = FontWeight.Light
                )
            }
        }
        Surface(
            color = Color.White,
            elevation = 2.dp,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.constrainAs(surfacePic) {
                start.linkTo(gdStart)
                top.linkTo(cardView.top, 32.dp)
            }) {
            val painter = rememberAsyncImagePainter(data.image)
            val transition by animateFloatAsState(
                targetValue = if (painter.state is AsyncImagePainter.State.Success) 1f else 0f,
                label = ""
            )
            Image(
                painter = painter,
                contentDescription = "Profile Pic",
                modifier = Modifier
                    .width(70.dp)
                    .height(80.dp)
                    .alpha(transition),
                contentScale = ContentScale.Crop
            )
        }

    }
}

@Composable
fun PageLoader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Loading",
            color = Color(0xFF133D59),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        CircularProgressIndicator(Modifier.padding(top = 10.dp))
    }
}

@Composable
fun LoadingNextPageItem(modifier: Modifier) {
    CircularProgressIndicator(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
            .wrapContentWidth(Alignment.CenterHorizontally)
    )
}

@Composable
@Preview
private fun PreviewCompose() {
}