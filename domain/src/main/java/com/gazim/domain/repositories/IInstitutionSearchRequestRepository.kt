package com.gazim.domain.repositories

import kotlinx.coroutines.flow.Flow


interface IInstitutionSearchRequestRepository {
    suspend fun getSearchRequest(): Flow<String>
    suspend fun setSearchRequest(query: String)
}