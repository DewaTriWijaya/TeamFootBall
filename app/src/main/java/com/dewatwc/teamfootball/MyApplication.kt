package com.dewatwc.teamfootball

import android.app.Application
import com.dewatwc.teamfootball.core.di.databaseModule
import com.dewatwc.teamfootball.core.di.networkModule
import com.dewatwc.teamfootball.core.di.repositoryModule
import com.dewatwc.teamfootball.di.useCaseModule
import com.dewatwc.teamfootball.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )
        }
    }
}