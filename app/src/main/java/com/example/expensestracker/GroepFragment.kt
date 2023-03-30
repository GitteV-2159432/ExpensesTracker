package com.example.expensestracker

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expensestracker.databinding.FragmentGroepBinding
import com.example.expensestracker.model.Groep


class GroepFragment: Fragment(R.layout.fragment_groep) {
    private lateinit var binding: FragmentGroepBinding
    private lateinit var main: MainActivity
    private lateinit var adapter: GroepAdapter
    private val activiteitenlijst = testlijst()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGroepBinding.inflate(layoutInflater)
        main = activity as MainActivity

        adapter = GroepAdapter(activiteitenlijst)
        binding.rvwActiviteit.adapter = adapter
        binding.rvwActiviteit.layoutManager = LinearLayoutManager(this.context)

        binding.btnAddActivity.setOnClickListener{
            val newGroepNaam = binding.txtAddActiviteit.text.toString()
            activiteitenlijst.add(Groep(newGroepNaam, 0))
            adapter.notifyItemInserted(activiteitenlijst.size-1)
        }
        return binding.root
    }



    private fun testlijst() = arrayListOf(
        Groep("Januari", 500),
        Groep("Februari", 200)
    )
}