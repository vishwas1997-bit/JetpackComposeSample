package com.example.jetpackcompose.netclan.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.jetpackcompose.netclan.data.repository.paging.ExploreIndividualPagingSource
import com.example.jetpackcompose.netclan.domain.model.IndividualExploreModel
import com.example.jetpackcompose.netclan.domain.repository.NetworkExploreRepository
import kotlinx.coroutines.flow.Flow

object NetworkExploreRepositoryImpl: NetworkExploreRepository {

    override fun getIndividualExploreUsers(): Flow<PagingData<IndividualExploreModel>> {
        return Pager(
            config = PagingConfig(pageSize = 12, prefetchDistance = 2),
            pagingSourceFactory = {
                ExploreIndividualPagingSource()
            }
        ).flow
    }
}