package com.gazim.school.data.datasource

import android.content.Context
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class DataSourceFromAssertImpl(context: Context) : IDataSourceFromAssert {

    private val assets = context.assets

    override fun getInstitutions(): List<InstitutionAssetsEntity> {
        val inputStream = assets.open("institutions.json").bufferedReader().readText()
        return Json.decodeFromString(inputStream)
    }

}