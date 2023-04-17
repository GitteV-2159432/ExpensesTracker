package com.example.expensestracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.expensestracker.databinding.FragmentAddgroepBinding
import com.example.expensestracker.model.Groep
import com.example.expensestracker.model.GroepLijstRepository
import com.example.expensestracker.model.room.GroepLijstRoomRepository


class AddGroepFragment: Fragment(R.layout.fragment_addgroep) {
    private lateinit var binding: FragmentAddgroepBinding
    private lateinit var main: MainActivity
    private lateinit var groepLijstRepository: GroepLijstRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddgroepBinding.inflate(layoutInflater)
        main = activity as MainActivity
        groepLijstRepository = GroepLijstRoomRepository(main.applicationContext)
        binding.txtAddActiviteit.text= "Naam activiteit:"

        binding.btnAddActivity.setOnClickListener{
            addNewGroepItem()
            findNavController().navigate(R.id.action_addGroepFragment_to_groepLijstFragment)
        }
        return binding.root
    }

    private fun addNewGroepItem(){
        val newGroepNaam = binding.txtActiviteitNaam.text.toString()
        val groep = Groep(newGroepNaam,0)
        groepLijstRepository.save(groep)
    }
}