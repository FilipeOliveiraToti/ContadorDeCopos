package com.foliveira.contadordecopos

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    val contadorView: TextView by lazy { findViewById(R.id.contador) }
    val btnMaisUm: Button by lazy { findViewById(R.id.button_mais_um) }
    val btnMenosUm: Button by lazy { findViewById(R.id.button_menos_um)}

    var contador: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupViews()
    }

    private fun setupViews() {
        btnMaisUm.setOnClickListener{
            contador++
            contadorView.text = contador.toString()
        }

        btnMenosUm.setOnClickListener{
            if (contador > 0){
                contador--
            }
            contadorView.text = contador.toString()
        }
    }
}