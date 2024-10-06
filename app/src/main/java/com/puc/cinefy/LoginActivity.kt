package com.puc.cinefy

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.puc.cinefy.databinding.ActivityLoginBinding
import com.puc.cinefy.user.model.UserSingleton

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        UserSingleton.init(this)
        println(UserSingleton.users)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.btnLogin.setOnClickListener {
            val email = binding.txtEmail.text.toString().trim().lowercase()
            val password = binding.txtPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                binding.txtMsg.text = "Preencher todos os campos"
            } else {
                val user = UserSingleton.getUser(email)

                if (user != null && user.password == password) {
                    binding.txtMsg.text = "Realizando login"
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    binding.txtMsg.text = "E-mail e/ou senha incorreto(s)"
                }
            }
        }

        binding.btnBack.setOnClickListener {
            this.finish()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}