package com.nsadisha.retrofitapp.di.module

import android.app.Application
import com.nsadisha.retrofitapp.connection.InternetStatus
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import java.net.HttpURLConnection
import java.net.URL
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class InternetStatusModule {
//    @Provides
//    @Singleton
//    fun provideConnection(): HttpURLConnection {
//        val connection = URL("https://www.google.com").openConnection() as HttpURLConnection
//        connection.setRequestProperty("User-Agent", "ConnectionTest")
//        connection.setRequestProperty("Connection", "close")
//        connection.connectTimeout = 1000 // configurable
//        return connection
//    }

    @Provides
    @Singleton
    fun provideInternetStatus(application: Application): InternetStatus {
        return InternetStatus(application)
    }
}