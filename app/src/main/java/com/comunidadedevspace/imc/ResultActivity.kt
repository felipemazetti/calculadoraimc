package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_IMC = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        window.statusBarColor = ContextCompat.getColor(this, R.color.primary_900)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val result = intent.getFloatExtra(KEY_RESULT_IMC,0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)

        val classificacao: String

        if (result <= 18.5f){
            classificacao = "MAGREZA"
            tvClassificacao.setTextColor(ContextCompat.getColor(/* context = */ this, /* id = */ R.color.magreza))
        }else if (result > 18.5f && result <= 24.9f){
            classificacao = "NORMAL"
            tvClassificacao.setTextColor(ContextCompat.getColor(/* context = */ this, /* id = */ R.color.normal))
        }else if (result > 25f && result <= 29.9f){
           classificacao = "SOBREPESO"
            tvClassificacao.setTextColor(ContextCompat.getColor(/* context = */ this, /* id = */ R.color.sobrepeso))
        }else if (result > 30f && result <= 39.9f ){
           classificacao =  "OBESIDADE"
            tvClassificacao.setTextColor(ContextCompat.getColor(/* context = */ this, /* id = */ R.color.obesidade))
        } else {
           classificacao =  "OBESIDADE GRAVE"
            tvClassificacao.setTextColor(ContextCompat.getColor(/* context = */ this, /* id = */ R.color.obesidade_grave))
        }

        tvClassificacao.text = classificacao


        tvResult.text = result.toString()
    }
}