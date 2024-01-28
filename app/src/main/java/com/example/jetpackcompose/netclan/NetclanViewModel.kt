package com.example.jetpackcompose.netclan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.jetpackcompose.netclan.domain.model.IndividualExploreModel
import com.example.jetpackcompose.netclan.domain.usecase.ExploreIndividualUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

class NetclanViewModel : ViewModel() {

    private val exploreIndividualUsecase = ExploreIndividualUseCase()

    private val _individualExplore: MutableStateFlow<PagingData<IndividualExploreModel>> =
        MutableStateFlow(value = PagingData.empty())
    val individualExplore: MutableStateFlow<PagingData<IndividualExploreModel>> get() = _individualExplore

    init {
        viewModelScope.launch {
            getIndividualExplore()
        }
    }

    private suspend fun getIndividualExplore() {
        exploreIndividualUsecase.execute(Unit).distinctUntilChanged().cachedIn(viewModelScope)
            .collect {
                _individualExplore.value = it
            }
    }
}