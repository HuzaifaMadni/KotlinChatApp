package com.example.myapplication

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import org.jetbrains.anko.design.bottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView().setOnNavigationItemSelectedListener {

            when(it.itemId){

                R.id.navigation_people -> {
                    //TODO: Add some code
                    true
                }

                R.id.navigation_my_account -> {
                    //TODO: Add some code
                    true
                }

                else -> false
            }
        }
    }
}
