package com.example.myapplication

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import com.example.myapplication.Model.RestAPI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var restAPI = RestAPI()
    var datos3 = mutableListOf<String>()
    var datos4 = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        datos3 = restAPI.datos3
        datos4 = restAPI.datos4
        restAPI.generateDigit()
        restAPI.generateTwoDigit()
        restAPI.generateThreeDigit()
        restAPI.generateFourthDigit()


        Log.i("response", "borrados: " + restAPI.getBorrados4().size)

        restAPI.getBorrados4().forEach{at->

            restAPI.removeElementFourthDigit(at.toInt())
        }


        getAdapterThreeDigit()
        getAdapterFourthDigit()

    }

    fun getAdapterThreeDigit() {

        val adaptador3 = ArrayAdapter(this@MainActivity,
            R.layout.elemento_de_lista,
            datos3)
        miLista3.adapter = adaptador3

        miLista3.onItemClickListener =
            object : AdapterView.OnItemClickListener{
                override fun onItemClick(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

                    restAPI.setBorrados3(miLista3.getItemIdAtPosition(position).toInt())
                    var intent = Intent(this@MainActivity, MainActivity::class.java)
                    startActivity(intent)

                    Log.i("response", "saved ${miLista3.getItemAtPosition(position)} "  )
                    Log.i("response", "saved ${miLista3.getItemIdAtPosition(position)} "  )

                }
            }

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

                    restAPI.setBorrados4(miLista4.getItemIdAtPosition(position).toInt())
//                    restAPI.removeElementFourthDigit(miLista4.getItemIdAtPosition(position).toInt())
                    var intent = Intent(this@MainActivity, MainActivity::class.java)
                    startActivity(intent)

                    Log.i("response", "saved ${miLista4.getItemAtPosition(position)} "  )
                    Log.i("response", "saved ${miLista4.getItemIdAtPosition(position)} "  )

                }

            }

    }
}