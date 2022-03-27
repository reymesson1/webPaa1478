package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.myapplication.Model.RestAPI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var restAPI = RestAPI()
    var datos4 = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        datos4 = restAPI.datos4
        restAPI.generateDigit()
        restAPI.generateTwoDigit()
        restAPI.generateThreeDigit()
        restAPI.generateFourthDigit()


        Log.i("response", "borrados: " + restAPI.getBorrados().size)

        restAPI.getBorrados().forEach{at->

            restAPI.removeElementFourthDigit(at.toInt())
        }


        getAdapterFourthDigit()

    }

    fun getAdapterFourthDigit() {

        val adaptador4 = ArrayAdapter(this@MainActivity,
            R.layout.elemento_de_lista,
            datos4)
        miLista4.adapter = adaptador4

        miLista4.onItemClickListener =
            object : AdapterView.OnItemClickListener{
                override fun onItemClick(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    restAPI.setBorrados(miLista4.getItemIdAtPosition(position).toInt())
//                    restAPI.removeElementFourthDigit(miLista4.getItemIdAtPosition(position).toInt())
                    var intent = Intent(this@MainActivity, MainActivity::class.java)
                    startActivity(intent)

                    Log.i("response", "saved ${miLista4.getItemAtPosition(position)} "  )
                    Log.i("response", "saved ${miLista4.getItemIdAtPosition(position)} "  )

                }

            }

    }
}