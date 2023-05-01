package com.example.fortuneproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.fortuneproject.databinding.ActivityMainBinding
import com.example.fortuneproject.di.Navigator
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    @Inject
    lateinit var navigator: Navigator
    private var binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        App.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        navigator.initialize(navController)
        navigator.attachNavController(navController, R.navigation.main_nav_graph)
    }

    companion object {

        fun start(context: Context) {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
//        navController?.let {
//            navigator.detachNavController(it)
//        }
    }
}