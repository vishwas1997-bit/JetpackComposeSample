package com.example.jetpackcompose.netclan.domain.usecase

import androidx.paging.PagingData
import com.example.jetpackcompose.core.base.BaseUseCase
import com.example.jetpackcompose.netclan.data.repository.NetworkExploreRepositoryImpl
import com.example.jetpackcompose.netclan.domain.model.IndividualExploreModel
import kotlinx.coroutines.flow.Flow

class ExploreIndividualUseCase : BaseUseCase<Unit, Flow<PagingData<IndividualExploreModel>>> {


    override suspend fun execute(input: Unit): Flow<PagingData<IndividualExploreModel>> {
        return NetworkExploreRepositoryImpl.getIndividualExploreUsers()
    }
}