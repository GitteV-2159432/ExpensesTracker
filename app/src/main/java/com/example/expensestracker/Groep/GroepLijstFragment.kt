package com.example.expensestracker.Groep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expensestracker.MainActivity
import com.example.expensestracker.R
import com.example.expensestracker.databinding.FragmentGroeplijstBinding
import com.example.expensestracker.model.Expense
import com.example.expensestracker.model.Groep
import com.example.expensestracker.model.GroepLijstPreferencesRepository
import com.example.expensestracker.model.GroepLijstRepository


class GroepLijstFragment: Fragment(R.layout.fragment_groeplijst) {

    private val groeplijst = arrayListOf<Groep>()
    private lateinit var groepLijstRepository: GroepLijstRepository
    private val expenselijst = arrayListOf<Expense>()
    private lateinit var binding: FragmentGroeplijstBinding
    private lateinit var main: MainActivity
    private lateinit var adapter: GroepLijstAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGroeplijstBinding.inflate(layoutInflater)
        main = activity as MainActivity
        groepLijstRepository = GroepLijstPreferencesRepository(requireActivity())

        laadGroepen()

        adapter = GroepLijstAdapter(groeplijst)
        binding.rvGroepLijst.adapter = adapter
        binding.rvGroepLijst.layoutManager = LinearLayoutManager(this.context)


        binding.btnAddGroep.setOnClickListener{
            findNavController().navigate(R.id.action_groepLijstFragment_to_addGroepFragment)
        }
        binding.btnVerwijderGroepen.setOnClickListener{
            findNavController().navigate(R.id.action_groepLijstFragment_to_deleteGroepFragment)
        }

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        groepLijstRepository.saveGroepen(groeplijst)
    }

    private fun laadGroepen(){
        groeplijst.clear()
        groeplijst.addAll(groepLijstRepository.loadGroepen())
    }

   fun selecteerGroep(groep: Groep){
        findNavController().navigate(R.id.action_groepLijstFragment_to_ExpenseLijstFragment, bundleOf(Groep.GROEP_ID to groep.id.toString(),))
   }

    fun clearAllItems() {
        groeplijst.clear()
        adapter.notifyDataSetChanged()
    }
}