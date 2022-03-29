package com.example.myapplication.Model

import android.util.Log
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestAPI {

    var datos = mutableListOf<String>()
    var datos2 = mutableListOf<String>()
    var datos3 = mutableListOf<String>()
    var datos4 = mutableListOf<String>()

    companion object {

        var token = ""
        var userId = ""
        var borrados = mutableListOf<String>()
        var borrados2 = mutableListOf<String>()
        var borrados3 = mutableListOf<String>()
        var borrados4 = mutableListOf<String>()

    }

    private val client = OkHttpClient.Builder().apply{
        addInterceptor(HttpInterceptor())
    }.build()


    var retrofit = Retrofit.Builder()
        .baseUrl("http://derrama.net")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun getMasterAPI() : MasterService{

        var masterService = retrofit.create(MasterService::class.java)

        return masterService
    }

    fun setPostSendComprarUnoAPI(
        numero : Int,
        cifras : Int,
        telefono: String,
        cliente: String,
        id_repolla: String,
        ronda: String
    ){

        var setPostSendComprarUno = retrofit.create(PostSendComprarUno::class.java)

        var call = setPostSendComprarUno.setSendComprarUno(

            numero,
            cifras,
            telefono,
            cliente,
            id_repolla,
            ronda
        )

        call.enqueue(object : Callback<ResponseComprarUno>{
            override fun onResponse(
                call: Call<ResponseComprarUno>,
                response: Response<ResponseComprarUno>
            ) {
                Log.i("response", response.body().toString())
            }

            override fun onFailure(call: Call<ResponseComprarUno>, t: Throwable) {
                Log.i("error", t.toString())
            }

        })


    }


    fun setPostLogin(email:String, password:String){

        var newUser = User()
        newUser.email = email
        newUser.password = password

        var json = Gson().toJson(newUser)

        var postService = retrofit.create(PostMasterService::class.java)

//        Calling with foo.example("Bob Smith", "Jane Doe") yields a request body of name=Bob+Smith&name=Jane+Doe.

        var call = postService.setMasterService(email,password)

        call.enqueue(object : Callback<Token> {
            override fun onResponse(call: Call<Token>, response: Response<Token>) {
                Log.i("response", response.body()!!.tienda.toString())

                RestAPI.token = response.body()!!.access_token.toString()

            }

            override fun onFailure(call: Call<Token>, t: Throwable) {
                Log.i("error", t.message.toString())
            }

        })

    }


    fun setBorrados(num : Int){

        RestAPI.borrados.add(num.toString())
    }

    fun getBorrados(): MutableList<String> {

        return RestAPI.borrados
    }

    fun setBorrados2(num : Int){

        RestAPI.borrados2.add(num.toString())
    }

    fun getBorrados2(): MutableList<String> {

        return RestAPI.borrados2
    }
    fun setBorrados3(num : Int){

        RestAPI.borrados3.add(num.toString())
    }

    fun getBorrados3(): MutableList<String> {

        return RestAPI.borrados3
    }
    fun setBorrados4(num : Int){

        RestAPI.borrados4.add(num.toString())
    }

    fun getBorrados4(): MutableList<String> {

        return RestAPI.borrados4
    }

    fun removeElementOneDigit(num : Int){

        if(num>0&&num<=9) {
            datos.set(num-1,"") //9

            var manyStr = num; datos2.set(manyStr.toInt()-1,"") // muchos
            var manyStr1 = "1"+num; datos2.set(manyStr1.toInt()-1,"") // muchos
            var manyStr2 = "2"+num; datos2.set(manyStr2.toInt()-1,"") // muchos
            var manyStr3 = "3"+num; datos2.set(manyStr3.toInt()-1,"") // muchos
            var manyStr4 = "4"+num; datos2.set(manyStr4.toInt()-1,"") // muchos
            var manyStr5 = "5"+num; datos2.set(manyStr5.toInt()-1,"") // muchos
            var manyStr6 = "6"+num; datos2.set(manyStr6.toInt()-1,"") // muchos
            var manyStr7 = "7"+num; datos2.set(manyStr7.toInt()-1,"") // muchos
            var manyStr8 = "8"+num; datos2.set(manyStr8.toInt()-1,"") // muchos
            var manyStr9 = "9"+num; datos2.set(manyStr9.toInt()-1,"") // muchos

            for(i in 0..1){

                for(j in 0..9){

                    for(k in 0..9) {

//                        Log.i("response", "datos3.set(${j}${k}${num - 1} ,${""})  ")
                        var numStr = "${j}${k}${num-1}".toInt()
                        datos3.set(numStr,"")
                    }
                }

            }

            for(i in 0..9){

                for(j in 0..9){

                    for(k in 0..9) {

//                        Log.i("response", "datos4.set(${j}${i}${k}${num - 1} ,${""})  ")
                        var numStr = "${j}${i}${k}${num-1}".toInt()
                        datos4.set(numStr,"")
                    }
                }

            }
//                var manyStr41 = "110"+num; datos4.set(manyStr41.toInt()-1,"") // muchos
//                var manyStr41 = "120"+num; datos4.set(manyStr41.toInt()-1,"") // muchos
            var manyStr42 = "200"+num; datos4.set(manyStr42.toInt()-1,"") // muchos
            var manyStr43 = "300"+num; datos4.set(manyStr43.toInt()-1,"") // muchos
            var manyStr44 = "400"+num; datos4.set(manyStr44.toInt()-1,"") // muchos
            var manyStr45 = "500"+num; datos4.set(manyStr45.toInt()-1,"") // muchos
            var manyStr46 = "600"+num; datos4.set(manyStr46.toInt()-1,"") // muchos
            var manyStr47 = "700"+num; datos4.set(manyStr47.toInt()-1,"") // muchos
            var manyStr48 = "800"+num; datos4.set(manyStr48.toInt()-1,"") // muchos
            var manyStr49 = "900"+num; datos4.set(manyStr49.toInt()-1,"") // muchos

        }


    }

    fun removeElementTwoDigit(num : Int){

        if(num>=0&&num<=9) {
            datos.set(num,"")
            datos2.set(num,"")
            for(i in 0..9){
                 var numStr = "${i}${num}".toInt()
                    datos3.set(numStr,"")
            }
            for(i in 0..9){
                    var numStr = "${0}${i}${num}".toInt()
                    datos4.set(numStr,"")

            }
        }else if(num>9&&num<=99) {
            datos.set(num.toString().substring(1).toInt(),"")
            datos2.set(num,"")
            for(i in 0..9){
                 var numStr = "${i}${num}".toInt()
                    datos3.set(numStr,"")
            }
            for(i in 0..9){
                    var numStr = "${0}${i}${num}".toInt()
                    datos4.set(numStr,"")

            }
        }
    }

    fun removeElementThreeDigit(num : Int){

        if(num>=0&&num<=9) { //003

            datos.set(num,"")
            datos2.set(num,"")
            datos3.set(num,"")
            for(i in 0..9){
                Log.i("response", "${i}${0}${num}")
                var numStr = "${i}${0}${num}".toInt()
                datos4.set(numStr,"")

            }
        }else if(num>9&&num<=99) {
            datos.set(num.toString().substring(1).toInt(),"")
            datos2.set(num,"")
            datos3.set(num,"")
            for(i in 0..9){
                Log.i("response", "${i}${0}${num}")
                var numStr = "${i}${0}${num}".toInt()
                datos4.set(numStr,"")

            }
        }else if(num>99&&num<=999) {
            datos.set(num.toString().substring(1).toInt(),"")
            datos2.set(num,"")
            datos3.set(num,"")
            for(i in 0..9){
                Log.i("response", "${i}${0}${num}")
                var numStr = "${i}${0}${num}".toInt()
                datos4.set(numStr,"")

            }
        }
    }

    fun removeElementThreeDigitOLD(num : Int){

        if(num>0&&num<=9) {
//            Log.i("response", (miLista4.getItemIdAtPosition(position) + 1).toString())
//            datos4.set(num,"") //0009 // muchos
            datos3.set(num,"") //009
            datos2.set(num,"") //09
            datos.set(num-1,"") //9

        }else if(num>9&&num<=99) {
            Log.i("response",num.toString())
            Log.i("response",num.toString().substring(1))
//            datos4.set(num,"") // muchos
            datos3.set(num,"")
            datos2.set(num,"")
            datos.set(num.toString().substring(1).toInt()-1,"")


        }else if(num>99&&num<=999) { //aqui esta llegand 125 -> 25 -> 5 solo tres digitos
            Log.i("response",num.toString())
            Log.i("response",num.toString().substring(1))
            Log.i("response",num.toString().substring(2))
            Log.i("response",num.toString().substring(3))

            var manyStr = num; datos4.set(manyStr.toInt()-1,"") // muchos
            var manyStr1 = "1"+num; datos4.set(manyStr1.toInt()-1,"") // muchos
            var manyStr2 = "2"+num; datos4.set(manyStr2.toInt()-1,"") // muchos
            var manyStr3 = "3"+num; datos4.set(manyStr3.toInt()-1,"") // muchos
            var manyStr4 = "4"+num; datos4.set(manyStr4.toInt()-1,"") // muchos
            var manyStr5 = "5"+num; datos4.set(manyStr5.toInt()-1,"") // muchos
            var manyStr6 = "6"+num; datos4.set(manyStr6.toInt()-1,"") // muchos
            var manyStr7 = "7"+num; datos4.set(manyStr7.toInt()-1,"") // muchos
            var manyStr8 = "8"+num; datos4.set(manyStr8.toInt()-1,"") // muchos
            var manyStr9 = "9"+num; datos4.set(manyStr9.toInt()-1,"") // muchos
            

            datos3.set(num-1,"")
            datos2.set(num.toString().substring(1).toInt()-1,"")
            datos.set(num.toString().substring(2).toInt()-1,"")
            Log.i("response", "aqui "+ num.toString().substring(2))
        }


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

        for (i in 0..9999) {
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

        for (i in 0..9) {
            datos+=i.toString()
        }
    }

    fun generateTwoDigit(){

        for (i in 0..99) {
            if(i<10){
                datos2+="0"+i.toString()
            }else{
                datos2+=i.toString()

            }
        }
    }

    fun generateThreeDigit(){

        for (i in 0..999) {
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