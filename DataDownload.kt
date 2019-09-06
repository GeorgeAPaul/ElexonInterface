package com.example.elexoninterface

import android.app.Service
import android.content.Intent
import android.os.IBinder
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import android.os.StrictMode
import java.util.*


class DataDownload : Service() {

    fun enableStrictMode() {
        val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()

        StrictMode.setThreadPolicy(policy)
    }
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }


    override fun onStartCommand(intent: Intent, flags: Int, startID: Int):Int
    {
        enableStrictMode()

        val url = URL("https://api.bmreports.com/BMRS/FUELINSTHHCUR/v1?APIKey=r96zlbkuuexnp2i&&ServiceType=csv")
        val read = BufferedReader(InputStreamReader(url.openStream()))

        var line: String = ""
        var value: Array<String>
        var lineNo = 0



        while (line != null && lineNo < 17) {

            line = read.readLine()

            if (lineNo > 1) {

//                println(lineNo)

                value = line.split(",").toTypedArray()
                println(Arrays.toString(value))

//                println(value[1])
//                println(value[2])
            }
            lineNo++
        }

        return START_STICKY
    }
}
