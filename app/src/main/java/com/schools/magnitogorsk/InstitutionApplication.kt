@file:Suppress("unused")

package com.schools.magnitogorsk

import android.app.Application
import com.schools.magnitogorsk.di.*
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class InstitutionApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(
                when {
                    BuildConfig.DEBUG -> Level.ERROR
                    else -> Level.NONE
                }
            )
            androidContext(this@InstitutionApplication)
            modules(
                listOf(
                    repositoryModule,
                    useCasesModule,
                    viewModelModule,
                    databaseModule
                )
            )
        }
    }

}