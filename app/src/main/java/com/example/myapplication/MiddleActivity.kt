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

//        restAPI.setBorrados(9706)
//        restAPI.setBorrados(9999)
//        restAPI.setBorrados(125)
//        restAPI.setBorrados(247)
//        restAPI.setBorrados(177)
//        restAPI.setBorrados(141)
//        restAPI.setBorrados(151)
//        restAPI.setBorrados(217)
//        restAPI.setBorrados(131)
//        restAPI.setBorrados(307)
//        restAPI.setBorrados(2999)
//        restAPI.setBorrados(1151)
//        restAPI.setBorrados(6141)
//        restAPI.setBorrados(4131)
//        restAPI.setBorrados(2125)
//        restAPI.setBorrados(9997)
//        restAPI.setBorrados(361)
//        restAPI.setBorrados(1361)
//        restAPI.setBorrados(136)
//        restAPI.setBorrados(124)
//        restAPI.setBorrados(417)
//        restAPI.setBorrados(9)
//        restAPI.setBorrados(3)


        doAsync {

            activityUiThread {

                getData()

                
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

//                premio.setText(response.body()!!.precio.toString())
//                debo.setText(response.body()!!.debo.toString())
//                cupo.setText(response.body()!!.cupo.toString())

                Log.i("response", response.body()!!.jugados[0].toString())
                Log.i("response", "Jugados array size: "+ response.body()!!.jugados.size.toString())

//                loadingJugados(response.body()!!.jugados)

                for(jugado in response.body()!!.jugados) {

                    var arrStr = jugado.toString().split(",")

                    var firstOne = arrStr[0].substring(1, 2).toInt()
                    var firstTwo = arrStr[1].substring(1, 5).split("]")
                    var secondTwo = firstTwo[0].split(".")



                    if (firstOne.toInt() == 4) {
                        Log.i("response", "Jugados SecondFinal: " + secondTwo[0].toString())

                        restAPI.setBorrados(secondTwo[0].toInt())

                    }
                }
//                repolla.setText(response.body()!!.id_repolla.toString())
//                ronda.setText(response.body()!!.ronda.toString())
//                acumulado.setText(response.body()!!.acumulado.toString())




            }

            override fun onFailure(call: Call<ResponseRPEstado>, t: Throwable) {
                Log.i("error", t.toString())
            }


        })


    }

}