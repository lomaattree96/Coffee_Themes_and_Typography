package com.example.coffee_themesandtypography

import android.os.Bundle
import androidx.activity.ComponentActivity

import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController

import com.google.android.material.navigation.NavigationView




class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
    }
}


