package com.nsadisha.retrofitapp.util

import android.app.AlertDialog
import android.content.Context
import android.util.Log
import android.widget.Toast
import kotlin.system.exitProcess


class Utility {
    companion object{
        fun p(item: Any){
            Log.d("db", item.toString())
        }

        fun showErrorAlert(context: Context, string: String){
            val dialog: AlertDialog.Builder = android.app.AlertDialog.Builder(context)
            dialog.setCancelable(false)
            dialog.setTitle("Error")
            dialog.setMessage(string)
            dialog.setPositiveButton("Close") { _, _ ->
                exitProcess(-1)
            }

            val alert: AlertDialog = dialog.create()
            alert.show()
        }

        fun showToast(context: Context, string: String){
            Toast.makeText(context, string, Toast.LENGTH_SHORT).show()
        }
    }
}