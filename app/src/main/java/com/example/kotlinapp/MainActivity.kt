package com.example.kotlinapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //Agregar la referencias de los ID del usuario, contraseña y boton
        val usuario = findViewById<EditText>(R.id.etUsuario)
        val password = findViewById<EditText>(R.id.etPassword)
        val ingresar = findViewById<Button>(R.id.btnIngresar)

        //validar al hacer clic en el boton para ingresar con usuario y contraseña
        ingresar.setOnClickListener {
            val user = usuario.text.toString()
            val pass = password.text.toString()

            if(user == "Admin1234" && pass == "1234") {
                val ventana = Intent(this, GaleriaActivity::class.java)
                startActivity(ventana)
            }else{
                Toast.makeText(this, "Datos incorrectos", Toast.LENGTH_SHORT).show()
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}