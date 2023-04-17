package com.example.expensestracker

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expensestracker.databinding.FragmentGroeplijstBinding
import com.example.expensestracker.model.Groep
import com.example.expensestracker.model.GroepLijstRepository
import com.example.expensestracker.model.room.GroepLijstRoomRepository


class GroepLijstFragment: Fragment(R.layout.fragment_groeplijst) {

    private val groeplijst = arrayListOf<Groep>()
    private lateinit var groepLijstRepository: GroepLijstRepository

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
        groepLijstRepository = GroepLijstRoomRepository(main.applicationContext)

        laadGroepen()

        adapter = GroepLijstAdapter(groeplijst)
        binding.rvGroepLijst.adapter = adapter
        binding.rvGroepLijst.layoutManager = LinearLayoutManager(this.context)


        binding.btnAddGroep.setOnClickListener{
            groepLijstRepository.save(groeplijst)
            findNavController().navigate(R.id.action_groepLijstFragment_to_addGroepFragment)
        }

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        groepLijstRepository.save(groeplijst)
    }

    private fun laadGroepen(){
        groeplijst.clear()
        groeplijst.addAll(groepLijstRepository.load())
    }

    fun selectGroep(groep: Groep){
        // findNavController().navigate(R.id.)
    }

    fun clearAllItems() {
        groeplijst.clear()
        adapter.notifyDataSetChanged()
    }
}