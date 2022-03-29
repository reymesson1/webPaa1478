package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.Model.ResponseRPEstado
import com.example.myapplication.Model.RestAPI
import kotlinx.android.synthetic.main.activity_middle.*
import org.jetbrains.anko.activityUiThread
import org.jetbrains.anko.doAsync
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MiddleActivity : AppCompatActivity() {

    var restAPI = RestAPI()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_middle)

        doAsync {

            activityUiThread {

                getData()

                Thread.sleep(5000)

                btn_next.isEnabled = true

            }
        }


        btn_next.setOnClickListener {

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

    }

    fun getData(){

        var masterService = restAPI.getMasterAPI()

        var call = masterService.getMasterService()

        call.enqueue(object : Callback<ResponseRPEstado> {

            override fun onResponse(call: Call<ResponseRPEstado>, response: Response<ResponseRPEstado>) {
                Log.i("response", response.body().toString())

                RestAPI.premio = response.body()!!.precio.toString()
                RestAPI.debo = response.body()!!.debo.toString()
                RestAPI.cupo = response.body()!!.cupo.toString()

                for(jugado in response.body()!!.jugados) {

                    var arrStr = jugado.toString().split(",")

                    var firstOne = arrStr[0].substring(1, 2).toInt()
                    var firstTwo = arrStr[1].substring(1, 5).split("]")
                    var secondTwo = firstTwo[0].split(".")



                    if (firstOne.toInt() == 4) {
                        restAPI.setBorrados4(secondTwo[0].toInt())
                        Log.i("response", "Four " + secondTwo[0])
                    }else if (firstOne.toInt() == 3) {
                        restAPI.setBorrados3(secondTwo[0].toInt())
                        Log.i("response", "Three " + secondTwo[0])
                    }else if (firstOne.toInt() == 2) {
                        restAPI.setBorrados2(secondTwo[0].toInt())
                        Log.i("response", "Two " + secondTwo[0])
                    }else if (firstOne.toInt() == 1) {
                        restAPI.setBorrados(secondTwo[0].toInt())
                        Log.i("response", "One " + secondTwo[0])
                    }
                }

                RestAPI.repolla = response.body()!!.id_repolla.toString()
                RestAPI.ronda = response.body()!!.ronda.toString()
                RestAPI.acumulado = response.body()!!.acumulado.toString()




            }

            override fun onFailure(call: Call<ResponseRPEstado>, t: Throwable) {
                Log.i("error", t.toString())
            }


        })


    }

}