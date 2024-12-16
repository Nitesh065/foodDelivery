package com.example.fooddelivery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import org.w3c.dom.Text

class LoginScreen : AppCompatActivity() {
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    private var email: EditText? = null
    private var password: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)
        val textButton: TextView = findViewById(R.id.t6Login)
        val btnLogin: Button = findViewById(R.id.btnLoginAc)
        email = findViewById(R.id.etLoginEmailAddress)
        password = findViewById(R.id.etLoginPassword)

        textButton.setOnClickListener {
            onRegister(it)
        }

        btnLogin.setOnClickListener {
            loginUser(it)
        }



    }
    private fun loginUser(view: View){
        val userEmail = email?.text.toString()
        val userPassword = password?.text.toString()

        auth.signInWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener{task ->
                if(task.isSuccessful){
                    val intent = Intent(this,Location::class.java)
                    startActivity(intent)
                    finish()
                }

        }.addOnFailureListener{
            Toast.makeText(applicationContext,it.localizedMessage,Toast.LENGTH_LONG).show()
        }
    }

    private fun onRegister(view: View){
        startActivity(Intent(this,RegisterScreen::class.java))
    }
}