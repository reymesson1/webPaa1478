package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.Model.RestAPI
import kotlinx.android.synthetic.main.activity_middle.*

class MiddleActivity : AppCompatActivity() {

    var restAPI = RestAPI()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_middle)

        restAPI.setBorrados(9706)
        restAPI.setBorrados(9999)
        restAPI.setBorrados(125)
        restAPI.setBorrados(247)
        restAPI.setBorrados(177)
        restAPI.setBorrados(141)
        restAPI.setBorrados(151)
        restAPI.setBorrados(217)
        restAPI.setBorrados(131)
        restAPI.setBorrados(307)
        restAPI.setBorrados(2999)
        restAPI.setBorrados(1151)
        restAPI.setBorrados(6141)
        restAPI.setBorrados(4131)
        restAPI.setBorrados(2125)
        restAPI.setBorrados(9997)
        restAPI.setBorrados(361)
        restAPI.setBorrados(1361)
        restAPI.setBorrados(136)
        restAPI.setBorrados(124)
        restAPI.setBorrados(417)
        restAPI.setBorrados(9)
        restAPI.setBorrados(3)

        btn_next.setOnClickListener {

            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }



    }
}