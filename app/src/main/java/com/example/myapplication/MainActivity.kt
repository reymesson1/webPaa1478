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
import kotlinx.android.synthetic.main.layout_item_modal.*
import kotlinx.android.synthetic.main.layout_item_modal.view.*

class MainActivity : AppCompatActivity() {

    var restAPI = RestAPI()
    var datos = mutableListOf<String>()
    var datos2 = mutableListOf<String>()
    var datos3 = mutableListOf<String>()
    var datos4 = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        datos = restAPI.datos
        datos2 = restAPI.datos2
        datos3 = restAPI.datos3
        datos4 = restAPI.datos4

        restAPI.generateDigit()
        restAPI.generateTwoDigit()
        restAPI.generateThreeDigit()
        restAPI.generateFourthDigit()

        premio.setText(RestAPI.premio)
        debo.setText(RestAPI.debo)
        cupo.setText(RestAPI.cupo)

        repolla.setText(RestAPI.repolla)
        ronda.setText(RestAPI.ronda)
        acumulado.setText(RestAPI.acumulado)

        Log.i("response", "borrados: " + restAPI.getBorrados4().size)

        restAPI.getBorrados4().forEach{at-> // borrado de API

            restAPI.removeElementFourthDigit(at.toInt())
        }

        restAPI.getBorrados3().forEach{at-> // borrado de API

            restAPI.removeElementThreeDigit(at.toInt())
        }

        restAPI.getBorrados2().forEach{at-> // borrado de API

            restAPI.removeElementTwoDigit(at.toInt())
        }

        restAPI.getBorrados().forEach{at-> // borrado de API

            restAPI.removeElementOneDigit(at.toInt())
        }

        getAdapterOneDigit()
        getAdapterTwoDigit()
        getAdapterThreeDigit()
        getAdapterFourthDigit()

    }

    fun getAdapterOneDigit() {

        val adaptador = ArrayAdapter(this@MainActivity,
            R.layout.elemento_de_lista,
            datos)
        miLista.adapter = adaptador

        miLista.onItemClickListener =
            object : AdapterView.OnItemClickListener{
                override fun onItemClick(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

//                    Log.i("response", miLista.getItemIdAtPosition(position).toString())
//                    restAPI.setBorrados(miLista.getItemIdAtPosition(position).toInt())
//                    var intent = Intent(this@MainActivity, MainActivity::class.java)
//                    startActivity(intent)

                    var modal = layoutInflater.inflate(R.layout.layout_item_modal, null)

                    var alertDialog = AlertDialog.Builder(this@MainActivity)

                    alertDialog.setView(modal)

                    alertDialog.setTitle("Numero a vender")

                    alertDialog.setPositiveButton("Confirmar venta", DialogInterface.OnClickListener { dialogInterface, i ->

                        restAPI.setBorrados(miLista.getItemIdAtPosition(position).toInt())

                        restAPI.setPostSendComprarUnoAPI(
                            miLista.getItemIdAtPosition(position).toInt(),
                            1,
                            modal.telephoneTXT.text.toString(),
                            modal.nameTXT.text.toString(),
                            "9",
                            "1"
                        )

                        restAPI.setPostSendComprarUnoCoinAPI(
                            miLista4.getItemIdAtPosition(position).toInt(),
                            1,
                            modal.telephoneTXT.text.toString(),
                            modal.nameTXT.text.toString(),
                            "9",
                            "1"
                        )

                        var intent = Intent(this@MainActivity, MainActivity::class.java)
                        startActivity(intent)


                        Log.i("response", "saved ${miLista.getItemAtPosition(position)} "  )
                        Log.i("response", "saved ${miLista.getItemIdAtPosition(position)} "  )

                    })

                    alertDialog.show()



                }
            }

    }

    fun getAdapterTwoDigit() {

        val adaptador2 = ArrayAdapter(this@MainActivity,
            R.layout.elemento_de_lista_2,
            datos2)
        miLista2.adapter = adaptador2

        miLista2.onItemClickListener =
            object : AdapterView.OnItemClickListener{
                override fun onItemClick(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {

//                    restAPI.setBorrados2(miLista2.getItemIdAtPosition(position).toInt())
//
//                    var intent = Intent(this@MainActivity, MainActivity::class.java)
//                    startActivity(intent)

                    var modal = layoutInflater.inflate(R.layout.layout_item_modal, null)

                    var alertDialog = AlertDialog.Builder(this@MainActivity)

                    alertDialog.setView(modal)

                    alertDialog.setTitle("Numero a vender")

                    alertDialog.setPositiveButton("Confirmar venta", DialogInterface.OnClickListener { dialogInterface, i ->

                        restAPI.setBorrados2(miLista2.getItemIdAtPosition(position).toInt())

                        restAPI.setPostSendComprarUnoAPI(
                            miLista2.getItemIdAtPosition(position).toInt(),
                            2,
                            modal.telephoneTXT.text.toString(),
                            modal.nameTXT.text.toString(),
                            "9",
                            "1"
                        )

                        restAPI.setPostSendComprarUnoCoinAPI(
                            miLista4.getItemIdAtPosition(position).toInt(),
                            2,
                            modal.telephoneTXT.text.toString(),
                            modal.nameTXT.text.toString(),
                            "9",
                            "1"
                        )

                        var intent = Intent(this@MainActivity, MainActivity::class.java)
                        startActivity(intent)


                        Log.i("response", "saved ${miLista2.getItemAtPosition(position)} "  )
                        Log.i("response", "saved ${miLista2.getItemIdAtPosition(position)} "  )

                    })

                    alertDialog.show()

                }
            }

    }

    fun getAdapterThreeDigit() {

        val adaptador3 = ArrayAdapter(this@MainActivity,
            R.layout.elemento_de_lista_3,
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

//                    restAPI.setBorrados3(miLista3.getItemIdAtPosition(position).toInt())
//                    var intent = Intent(this@MainActivity, MainActivity::class.java)
//                    startActivity(intent)

                    var intent = Intent(this@MainActivity, MainActivity::class.java)
                    startActivity(intent)

                    var modal = layoutInflater.inflate(R.layout.layout_item_modal, null)

                    var alertDialog = AlertDialog.Builder(this@MainActivity)

                    alertDialog.setView(modal)

                    alertDialog.setTitle("Numero a vender")

                    alertDialog.setPositiveButton("Confirmar venta", DialogInterface.OnClickListener { dialogInterface, i ->

                        restAPI.setBorrados3(miLista3.getItemIdAtPosition(position).toInt())

                        restAPI.setPostSendComprarUnoAPI(
                            miLista3.getItemIdAtPosition(position).toInt(),
                            3,
                            modal.telephoneTXT.text.toString(),
                            modal.nameTXT.text.toString(),
                            "9",
                            "1"
                        )

                        restAPI.setPostSendComprarUnoCoinAPI(
                            miLista4.getItemIdAtPosition(position).toInt(),
                            3,
                            modal.telephoneTXT.text.toString(),
                            modal.nameTXT.text.toString(),
                            "9",
                            "1"
                        )

                        var intent = Intent(this@MainActivity, MainActivity::class.java)
                        startActivity(intent)


                        Log.i("response", "saved ${miLista3.getItemAtPosition(position)} "  )
                        Log.i("response", "saved ${miLista3.getItemIdAtPosition(position)} "  )

                    })

                    alertDialog.show()

                }
            }

    }

    fun getAdapterFourthDigit() {

        val adaptador4 = ArrayAdapter(this@MainActivity,
            R.layout.elemento_de_lista_4,
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

                    var intent = Intent(this@MainActivity, MainActivity::class.java)
                    startActivity(intent)

                    var modal = layoutInflater.inflate(R.layout.layout_item_modal, null)

                    var alertDialog = AlertDialog.Builder(this@MainActivity)

                    alertDialog.setView(modal)

                    alertDialog.setTitle("Numero a vender")

                    alertDialog.setPositiveButton("Confirmar venta", DialogInterface.OnClickListener { dialogInterface, i ->

                        restAPI.setBorrados4(miLista4.getItemIdAtPosition(position).toInt())


                        restAPI.setPostSendComprarUnoAPI(
                            miLista4.getItemIdAtPosition(position).toInt(),
                            4,
                            modal.telephoneTXT.text.toString(),
                            modal.nameTXT.text.toString(),
                            "9",
                            "1"
                        )

                        restAPI.setPostSendComprarUnoCoinAPI(
                            miLista4.getItemIdAtPosition(position).toInt(),
                            4,
                            modal.telephoneTXT.text.toString(),
                            modal.nameTXT.text.toString(),
                            "9",
                            "1"
                        )

                        var intent = Intent(this@MainActivity, MainActivity::class.java)
                        startActivity(intent)


                        Log.i("response", "saved ${miLista4.getItemAtPosition(position)} "  )
                        Log.i("response", "saved ${miLista4.getItemIdAtPosition(position)} "  )

                    })

                    alertDialog.show()

                }

            }

    }
}