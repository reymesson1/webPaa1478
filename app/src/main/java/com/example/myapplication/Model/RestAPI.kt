package com.example.myapplication.Model

import android.util.Log

class RestAPI {

    var datos = mutableListOf<String>()
    var datos2 = mutableListOf<String>()
    var datos3 = mutableListOf<String>()
    var datos4 = mutableListOf<String>()

    companion object {

        var token = ""
        var userId = ""
        var borrados4 = mutableListOf<String>()

    }

//    var borrados4 = mutableListOf<String>()

    fun setBorrados(num : Int){


        RestAPI.borrados4.add(num.toString())

    }

    fun getBorrados(): MutableList<String> {

        return RestAPI.borrados4
    }

    fun removeElementFourthDigit(num : Int){

        if(num>0&&num<=9) {
//            Log.i("response", (miLista4.getItemIdAtPosition(position) + 1).toString())
            datos4.set(num,"") //0009
            datos3.set(num,"") //009
            datos2.set(num,"") //09
            datos.set(num-1,"") //9

        }else if(num>9&&num<=99) {
            Log.i("response",num.toString())
            Log.i("response",num.toString().substring(1))
            datos4.set(num,"")
            datos3.set(num,"")
            datos2.set(num,"")
            datos.set(num.toString().substring(1).toInt()-1,"")


        }else if(num>99&&num<=999) { //aqui esta llegand 125 -> 25 -> 5 solo tres digitos
            Log.i("response",num.toString())
            Log.i("response",num.toString().substring(1))
            Log.i("response",num.toString().substring(2))
            Log.i("response",num.toString().substring(3))


            datos4.set(num-1,"")
            datos3.set(num-1,"")
            datos2.set(num.toString().substring(1).toInt()-1,"")
            datos.set(num.toString().substring(2).toInt()-1,"")
            Log.i("response", "aqui "+ num.toString().substring(2))
        }else if(num>999&&num<=9999) {
            Log.i("response",num.toString())
            Log.i("response",num.toString().substring(1))
            Log.i("response",num.toString().substring(2))
            Log.i("response",num.toString().substring(3))


            datos4.set(num-1,"")
            datos3.set(num.toString().substring(1).toInt()-1,"")
            datos2.set(num.toString().substring(2).toInt()-1,"")
            datos.set(num.toString().substring(3).toInt()-1,"")
        }


    }



    fun generateFourthDigit(){

        for (i in 1..9999) {
            if(i<10){
                datos4+="000"+i.toString()
            }else if(i<100){
                datos4+="00"+i.toString()
            }else if(i<1000){
                datos4+="0"+i.toString()
            }else{
                datos4+=i.toString()
            }
        }
    }

    fun generateDigit(){

        for (i in 1..9) {
            datos+=i.toString()
        }
    }

    fun generateTwoDigit(){

        for (i in 1..99) {
            if(i<10){
                datos2+="0"+i.toString()
            }else{
                datos2+=i.toString()

            }
        }
    }

    fun generateThreeDigit(){

        for (i in 1..999) {
            if(i<10){
                datos3+="00"+i.toString()
            }else if(i<100){
                datos3+="0"+i.toString()
            }else{
                datos3+=i.toString()
            }
        }
    }

}