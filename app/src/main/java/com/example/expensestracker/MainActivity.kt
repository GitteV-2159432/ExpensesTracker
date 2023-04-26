package com.example.expensestracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.navigation.fragment.NavHostFragment
import com.example.expensestracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var menuBarToggle: ActionBarDrawerToggle
    private lateinit var pictureActivityResult

    private val navHostFragment: NavHostFragment
        get() = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //voor foto van kasticket
        pictureActivityResult = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bm: Bitmap ->
            msg("bitmap is ${bm.height} high", binding.root)
            // do something with the captured image
        }
    }


}



