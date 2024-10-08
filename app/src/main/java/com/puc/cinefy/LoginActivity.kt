package com.puc.cinefy

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.puc.cinefy.databinding.ActivityLoginBinding
import com.puc.cinefy.movie.viewModel.MovieViewModel
import com.puc.cinefy.user.model.UserSingleton
import com.puc.cinefy.user.viewModel.UserViewModel

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var viewModel: UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        println(UserSingleton.users)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.btnLogin.setOnClickListener {
            val email = binding.txtEmail.text.toString().trim().lowercase()
            val password = binding.txtPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                binding.txtMsg.text = "Fill in all fields"
            } else {
                val user = viewModel.getUserByEmail(email)

                if (user != null && user.password == password) {
                    binding.txtMsg.text = "Logging in"
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    binding.txtMsg.text = "E-mail and/or password incorrect"
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