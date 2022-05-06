package com.gazim.data.repositories

import com.gazim.domain.repositories.IInstitutionSearchRequestRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class InstitutionSearchRequestRepositoryImpl : IInstitutionSearchRequestRepository {

    private val searchRequest = MutableStateFlow("")

    override suspend fun getSearchRequest(): StateFlow<String> = searchRequest

    override suspend fun setSearchRequest(query: String) {
        searchRequest.value = query
    }

}