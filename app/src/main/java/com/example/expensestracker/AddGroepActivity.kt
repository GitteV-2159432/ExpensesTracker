package com.example.expensestracker

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.expensestracker.databinding.ActivityAddGroepBinding


class AddGroepActivity: AppCompatActivity() {
    var newGroep : String = ""
    private lateinit var binding: ActivityAddGroepBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAddGroepBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.txtAddActiviteit.text = "Vul hier de naam van uw activiteit in:"

        binding.btnAddActivity.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java )
            intent.putExtra("groep", binding.txtActiviteitNaam.text.toString())
            startActivity(intent)
        }
    }

    public fun getGroep(): String {
        return newGroep
    }
}