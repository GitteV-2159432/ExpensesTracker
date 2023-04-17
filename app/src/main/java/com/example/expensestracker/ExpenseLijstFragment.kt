package com.example.expensestracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expensestracker.databinding.FragmentExpenselijstBinding
import com.example.expensestracker.model.Expense
import com.example.expensestracker.model.Groep
import com.example.expensestracker.model.GroepLijstRepository
import com.example.expensestracker.model.room.GroepLijstRoomRepository


class ExpenseLijstFragment: Fragment(R.layout.fragment_expenselijst) {
    private val groeplijst = arrayListOf<Groep>()
    private val expenselijst = arrayListOf<Expense>()


    private lateinit var binding: FragmentExpenselijstBinding
    private lateinit var main: MainActivity
    private lateinit var adapter: ExpenseLijstAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExpenselijstBinding.inflate(layoutInflater)
        main = activity as MainActivity


        adapter = ExpenseLijstAdapter(expenselijst)
        binding.rvExpenseLijst.adapter = adapter
        binding.rvExpenseLijst.layoutManager = LinearLayoutManager(this.context)


       /* binding.btnAddExpense.setOnClickListener{
            expenseLijstRepository.save(expenselijst)
            findNavController().navigate(R.id.action_groepLijstFragment_to_addGroepFragment)
        }*/

        return binding.root
    }

   /* override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        groepLijstRepository.save(groeplijst)
    }

    private fun laadExpenses(){
        groeplijst.clear()
        expenselijst.clear()
        expenselijst.addAll(groepLijstRepository.getExpenses())
        groeplijst.addAll(groepLijstRepository.load())
    }

    /*fun selecteerGroep(groep: Groep){
        findNavController().navigate(R.id.action_groepLijstFragment_to_ExpenseLijstFragment, bundleOf(Groep.GROEP_ID to groep.id.toString()))
    }*/

    fun clearAllItems() {
        groeplijst.clear()
        expenselijst.clear()
        adapter.notifyDataSetChanged()
    }*/
}