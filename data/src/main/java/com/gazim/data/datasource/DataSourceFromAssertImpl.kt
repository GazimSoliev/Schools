package com.gazim.data.datasource

import android.content.Context
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json


class DataSourceFromAssertImpl(context: Context) : IDataSourceFromAssert {

    private val assets = context.assets

    override fun getInstitutions(): List<InstitutionAssetsEntity> =
        Json.decodeFromString(
            assets.open("institutions.json").bufferedReader().readText()
        )

}