package com.example.pr1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pr1.services.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val userViewModel = androidx.lifecycle.ViewModelProvider(this)[UserViewModel::class.java]

        userViewModel.fetchUsers()

        userViewModel.addNewProduct()
    }
}
