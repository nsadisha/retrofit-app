package com.nsadisha.retrofitapp.di.module

import android.app.Application
import android.app.SharedElementCallback
import androidx.room.Room
import com.nsadisha.retrofitapp.room.VideoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(application: Application, callback: VideoDatabase.Callback): VideoDatabase{
        return Room.databaseBuilder(application, VideoDatabase::class.java, "video_database")
            .fallbackToDestructiveMigration()
            .addCallback(callback)
            .build()
    }
}