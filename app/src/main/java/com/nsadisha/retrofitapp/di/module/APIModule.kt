package com.nsadisha.retrofitapp.di.module

import com.nsadisha.retrofitapp.api.DevBytesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class APIModule {
    @Provides
    @Singleton
    fun provideRetrofit() :Retrofit {
        val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideDevByteService(retrofit: Retrofit) :DevBytesService {
        return retrofit.create(DevBytesService::class.java)
    }
}