
package com.example.fooddelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth

class RegisterScreen : AppCompatActivity() {

    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    var etEmail: EditText? = null
    var password: EditText? = null
    var name: EditText? = null
    var textButton: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_screen)
        textButton = findViewById(R.id.t6Register)
        etEmail = findViewById(R.id.etRegisterEmailAddress)
        password = findViewById(R.id.etRegisterPassword)
        name = findViewById(R.id.etRegisterPassword)
        val btnRegister: Button = findViewById(R.id.btnRegisterAc)

        btnRegister.setOnClickListener {
            registerUser(it)
        }

        textButton?.setOnClickListener {
            onLogin(it)
        }



    }

    private fun registerUser(view: View){
        val email = etEmail?.text.toString()
        val password = password?.text.toString()

        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }

            }.addOnFailureListener {
                Toast.makeText(applicationContext,it.localizedMessage,Toast.LENGTH_LONG).show()
            }




    }
    private fun onLogin(view:View){
        startActivity(Intent(this,Location::class.java))

    }

}