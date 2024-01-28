package com.example.jetpackcompose.netclan.domain.repository

import androidx.paging.PagingData
import com.example.jetpackcompose.netclan.domain.model.IndividualExploreModel
import kotlinx.coroutines.flow.Flow

interface NetworkExploreRepository {
    fun getIndividualExploreUsers(): Flow<PagingData<IndividualExploreModel>>
}