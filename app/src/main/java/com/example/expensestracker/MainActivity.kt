package com.example.expensestracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.expensestracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var activiteitFragment = GroepFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setupActivityFragment()

        setContentView(binding.root)
    }

    private fun setupActivityFragment(){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frmActiviteitContainer, activiteitFragment)
            commit()
        }
    }
}