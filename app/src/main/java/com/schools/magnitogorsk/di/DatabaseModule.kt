package com.schools.magnitogorsk.di

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.gazim.data.database.InstitutionsDatabase
import com.gazim.data.database.dao.InstitutionsDao
import com.gazim.data.datasource.DataSourceFromAssertImpl
import com.gazim.data.datasource.IDataSourceFromAssert
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import java.util.concurrent.Executors


val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidContext().applicationContext,
            InstitutionsDatabase::class.java,
            InstitutionsDatabase.DATABASE
        ).fallbackToDestructiveMigration().addCallback(
            object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    Executors.newSingleThreadExecutor().execute {
                        get<InstitutionsDao>().insertAll(
                            get<IDataSourceFromAssert>().getInstitutions()
                                .map { it.mapToInstitutionEntity() })
                    }
                }
            }
        ).build()
    }

    single {
        get<InstitutionsDatabase>().institutionsDao()
    }

    single<IDataSourceFromAssert> {
        DataSourceFromAssertImpl(androidContext().applicationContext)
    }

}