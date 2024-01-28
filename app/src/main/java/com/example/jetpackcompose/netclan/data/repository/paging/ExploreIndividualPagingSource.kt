package com.example.jetpackcompose.netclan.data.repository.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.jetpackcompose.netclan.data.datasource.remote.NetworkExploreDataSourceImpl
import com.example.jetpackcompose.netclan.data.model.remote.mapper.mapFromListModel
import com.example.jetpackcompose.netclan.domain.model.IndividualExploreModel
import retrofit2.HttpException
import java.io.IOException

class ExploreIndividualPagingSource : PagingSource<Int, IndividualExploreModel>() {
    override fun getRefreshKey(state: PagingState<Int, IndividualExploreModel>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, IndividualExploreModel> {
        return try {
            val currentPage = params.key ?: 1
            val individualData = NetworkExploreDataSourceImpl.getIndividualExploreUsers(
                pageNumber = currentPage
            )
            LoadResult.Page(
                data = individualData.body()!!.data.mapFromListModel(),
                prevKey = if (currentPage == 1) null else currentPage - 1,
                nextKey = if (individualData.body()!!.data.isEmpty()) null else currentPage + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}