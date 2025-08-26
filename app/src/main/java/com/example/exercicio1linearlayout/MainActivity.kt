package com.example.exercicio1linearlayout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.exercicio1linearlayout.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    // usando uma Binding para poder chamar os elementos da XML, sem usar a "findViewById()"
    // deve-se modificar a Gradle para utilizar essa biblioteca
    // utilizar LATEINIT para não definir como NULL
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // definindo a binding, com o retorno do XML em forma de objeto
        // "inflate" transforma o texto do XML em um Objeto
        binding = ActivityMainBinding.inflate(layoutInflater)

        // Define qual View será mostrada na tela, no caso, a "root"
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // exemplo de chamada de um elemento do XML com biding
        // binding.edittextEmail.text.toString()

        // definindo uma função para o click do botão "login"
        // deve-se implementar a interface a classe main para funcionar
        binding.buttonLogin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if(v.id == R.id.button_login){
            val email = binding.edittextEmail.text.toString()
            val password = binding.edittextPassword.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty()){
                // navegação de uma activity para outra
                // intent(intenção) activity a ser navegada
                val intent: Intent = Intent(this, SegurosActivity::class.java) // "::class.java" é uma referencia da activity
                startActivity(intent)
            }else{
                // a mainActivity responde como o contexto
                // pode ser "this" ou "applicationContext"
                Toast.makeText(this,"Informe os dados!", Toast.LENGTH_SHORT).show()

                // String definida em "res" -> "values" -> "Strings" -> "data_validation"
                //val str = R.string.data_validation
                // Toast.makeText(this,str, Toast.LENGTH_SHORT).show() // <-- mais indicado

            }

        }else if(v.id==R.id.button_register){

        }
    }
}