package com.gazim.school.data.repositories

import com.gazim.school.domain.repositories.IInstitutionSearchRequestRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class InstitutionSearchRequestRepositoryImpl : IInstitutionSearchRequestRepository {

    private val searchRequest = MutableStateFlow("")

    override suspend fun getSearchRequest(): StateFlow<String> = searchRequest
    override suspend fun setSearchRequest(query: String) {
        searchRequest.value = query
    }

}