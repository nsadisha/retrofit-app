package com.nsadisha.retrofitapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nsadisha.retrofitapp.di.module.ApplicationScope
import com.nsadisha.retrofitapp.room.model.DatabaseVideo
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineScope
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [DatabaseVideo::class], version = 1)
abstract class VideoDatabase: RoomDatabase() {
    abstract val videoDao: VideoDao

    class Callback @Inject constructor(
        private val database: Provider<VideoDatabase>,
        @ApplicationScope private val applicationScope: CoroutineScope
    ): RoomDatabase.Callback()
}