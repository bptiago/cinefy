package com.puc.cinefy

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.puc.cinefy.databinding.ActivityRegisterBinding
import com.puc.cinefy.model.Singleton
import com.puc.cinefy.viewModel.MainViewModel
import com.puc.cinefy.viewModel.MainViewModelFactory

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        Singleton.init(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_register)

        println(
            Singleton.users
        )

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