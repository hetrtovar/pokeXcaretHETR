package com.example.pokedexxcarethetr.controllers

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import android.widget.Toast
import com.example.pokedexxcarethetr.R
import com.example.pokedexxcarethetr.Views.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class controllerSession(contexto: Context) {

    private lateinit var auth: FirebaseAuth
    private lateinit var contexto: Context
    private lateinit  var spPokedex : SharedPreferences



    init{
        this.contexto = contexto
        this.auth = Firebase.auth
        spPokedex = this.contexto.getSharedPreferences(this.contexto.getString(R.string.sp_name),Context.MODE_PRIVATE)

    }



    fun initSessionFirebase(userName: String, password: String ){
        Log.d("TagLogin" , userName+" "+password)
        auth.signInWithEmailAndPassword(userName, password).addOnCompleteListener() { task ->
            if (task.isSuccessful) {
                // Sign in success, update UI with the signed-in user's information

                val user = auth.currentUser
                Log.d("TagLogin" , "signInWithEmail:success "+auth.currentUser?.uid)
                saveSession(auth.currentUser?.uid.toString())
                var intent = Intent(contexto, HomeActivity::class.java)
                contexto.startActivity(intent)


            } else {
                // If sign in fails, display a message to the user.
                Log.d("TagLogin", "signInWithEmail:failure", task.exception)
                Toast.makeText(contexto, "Authentication failed.",
                    Toast.LENGTH_SHORT).show()

            }
        }







    }

    fun saveSession(uid:String){
        var editor = spPokedex.edit()
        editor.putString("username",uid)
        editor.commit()
    }

    fun deleteSession(){
        auth.signOut()
        var editor = spPokedex.edit()
        editor.clear()
        editor.remove("username")
        editor.commit()

    }

    fun validateSession(): Boolean {

        var username = spPokedex.getString("username","");
        Log.d("TagValidar",username+"")
        return !username.toString().isEmpty()
    }





}