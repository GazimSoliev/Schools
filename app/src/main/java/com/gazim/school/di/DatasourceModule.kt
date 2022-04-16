package com.gazim.school.di

import com.gazim.school.data.datasource.DataSourceFromAssertImpl
import com.gazim.school.data.datasource.IDataSourceFromAssert
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val datasourceModule = module {

    single<IDataSourceFromAssert> {
        DataSourceFromAssertImpl(androidContext().applicationContext)
    }

}