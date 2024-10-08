package com.puc.cinefy

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.puc.cinefy.databinding.ActivityRegisterBinding
import com.puc.cinefy.user.model.UserSingleton
import com.puc.cinefy.user.model.User
import com.puc.cinefy.user.viewModel.UserViewModel

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.btnRegister.setOnClickListener {
            val name = binding.txtName.text.toString().trim()
            val email = binding.txtEmail.text.toString().trim().lowercase()
            val password = binding.txtPassword.text.toString().trim()

            if (password.isEmpty() || name.isEmpty() || email.isEmpty()) {
                binding.txtMsg.text = "Fill in all fields"
            } else {
                binding.txtMsg.text = "User created"
                val user = User(null, name, email, password)

                viewModel.getUserByEmail(email)?.let {
                    binding.txtMsg.text = "User already exists. Try another e-mail"
                } ?: let {
                    viewModel.addUser(user)
                    this.finish()
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