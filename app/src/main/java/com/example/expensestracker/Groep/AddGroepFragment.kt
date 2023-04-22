package com.example.expensestracker.Groep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.expensestracker.MainActivity
import com.example.expensestracker.R
import com.example.expensestracker.databinding.FragmentAddgroepBinding
import com.example.expensestracker.model.Expense
import com.example.expensestracker.model.Groep
import com.example.expensestracker.model.GroepLijstPreferencesRepository
import com.example.expensestracker.model.GroepLijstRepository


class AddGroepFragment: Fragment(R.layout.fragment_addgroep) {
    private lateinit var binding: FragmentAddgroepBinding
    private lateinit var main: MainActivity
    private lateinit var groepLijstRepository: GroepLijstRepository
    private val expensesLijst = mutableListOf<Expense>()
    private val groepLijstFragment = GroepLijstFragment()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddgroepBinding.inflate(layoutInflater)
        main = activity as MainActivity
        groepLijstRepository = GroepLijstPreferencesRepository(requireActivity())
        binding.txtAddActiviteit.text= "Naam activiteit:"


        binding.btnAddActivity.setOnClickListener{
            addGroep()
        }
        return binding.root
    }

    private fun addGroep(){
        val groep = Groep(binding.txtActiviteitNaam.text.toString(), 0, listOf())
        groepLijstRepository.saveGroep(groep)
        findNavController().navigate(R.id.action_addGroepFragment_to_groepLijstFragment)
    }
}