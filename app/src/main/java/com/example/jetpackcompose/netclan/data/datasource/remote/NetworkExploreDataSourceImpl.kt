package com.example.jetpackcompose.netclan.data.datasource.remote

import com.example.jetpackcompose.core.api.ApiClient
import com.example.jetpackcompose.core.api.ApiInterface
import com.example.jetpackcompose.netclan.data.model.remote.dto.response.IndividualExploreResponseDto
import retrofit2.Response

object NetworkExploreDataSourceImpl : NetworkExploreDataSource {

    private val apiInterface = ApiClient.getClient()!!.create(ApiInterface::class.java)

    override suspend fun getIndividualExploreUsers(pageNumber: Int): Response<IndividualExploreResponseDto> {
        return apiInterface.getExploreIndividualUsers(0,pageNumber, 12)
    }
}