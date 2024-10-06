package com.puc.cinefy

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.puc.cinefy.databinding.ActivityRegisterBinding
import com.puc.cinefy.user.model.UserSingleton
import com.puc.cinefy.user.model.User

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        UserSingleton.init(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        binding.btnRegister.setOnClickListener {
            val name = binding.txtName.text.toString().trim()
            val email = binding.txtEmail.text.toString().trim().lowercase()
            val password = binding.txtPassword.text.toString().trim()

            if (password.isEmpty() || name.isEmpty() || email.isEmpty()) {
                binding.txtMsg.text = "Fill in all fields"
            } else {
                binding.txtMsg.text = "User created"
                val user = User(null, name, email, password)
                UserSingleton.addUser(user)
                this.finish()
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