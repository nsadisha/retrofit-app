package com.nsadisha.retrofitapp.connection

import android.content.Context
import android.os.Handler
import android.os.HandlerThread
import com.nsadisha.retrofitapp.util.Utility.Companion.p
import com.nsadisha.retrofitapp.util.Utility.Companion.showToast
import okio.IOException
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class InternetStatus constructor(private val context: Context){
    fun isInternetAvailable(): Boolean {
        try {
            val connection = URL("https://www.google.com").openConnection() as HttpURLConnection
            connection.setRequestProperty("User-Agent", "ConnectionTest")
            connection.setRequestProperty("Connection", "close")
            connection.connectTimeout = 1000 // configurable
            connection.connect()
            return (connection.responseCode == 200)
        } catch (e: IOException){

            showToast(context, "No internet connection!")
        } catch (e: Exception){
            p(e)
            showToast(context, "Something went wrong!")
        }
        return false
    }
}