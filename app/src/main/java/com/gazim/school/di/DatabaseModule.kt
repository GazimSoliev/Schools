package com.gazim.school.di

import androidx.room.Room
import com.gazim.school.data.database.InstitutionsDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidContext().applicationContext,
            InstitutionsDatabase::class.java,
            InstitutionsDatabase.DATABASE
        ).fallbackToDestructiveMigration().build()
    }
    single {
        get<InstitutionsDatabase>().institutionsDao()
    }
}