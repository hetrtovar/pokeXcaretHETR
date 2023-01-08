package com.example.pokedexxcarethetr.Views

import android.content.Intent
import android.os.Bundle

import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pokedexxcarethetr.R
import com.example.pokedexxcarethetr.controllers.controllerSession

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        setView()




    }


    fun setView(){

        val progress = findViewById<ProgressBar>(R.id.progress_main)

        val edt_username = findViewById<EditText>(R.id.edt_username)
        val edt_pass = findViewById<EditText>(R.id.edt_password)
        var sessionInit = controllerSession(this)
        val btn = findViewById<Button>(R.id.btn_login);
        btn.setOnClickListener(View.OnClickListener {
            if(edt_username.text.toString().isEmpty() || edt_pass.text.toString().isEmpty()){
                val toast = Toast.makeText(applicationContext, "Ingresa todos los campos", Toast.LENGTH_SHORT)
                toast.show()
            }else{


                sessionInit.initSessionFirebase(edt_username.text.toString(), edt_pass.text.toString())

            }
        })

        progress.visibility = View.VISIBLE;
        if(sessionInit.validateSession()){
            //se hace el intent
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

        progress.visibility = View.GONE;


    }


}