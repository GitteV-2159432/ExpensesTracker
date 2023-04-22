package com.example.expensestracker.Groep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expensestracker.R
import com.example.expensestracker.databinding.FragmentDeleteGroepBinding
import com.example.expensestracker.model.Groep
import com.example.expensestracker.model.GroepLijstPreferencesRepository

class DeleteGroepFragment: Fragment(R.layout.fragment_delete_groep) {
    private lateinit var binding:FragmentDeleteGroepBinding
    private lateinit var adapter: DeleteGroepAdapter
    private lateinit var teVerwijderenGroepen: ArrayList<Groep>
    private lateinit var groepLijstRepository: GroepLijstPreferencesRepository

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDeleteGroepBinding.inflate(layoutInflater)
        teVerwijderenGroepen = ArrayList();
        groepLijstRepository = GroepLijstPreferencesRepository(requireActivity())

        val groepLijst = groepLijstRepository.loadGroepen()

        adapter = DeleteGroepAdapter(groepLijst, teVerwijderenGroepen)
        binding.rvwDelete.adapter = adapter
        binding.rvwDelete.layoutManager = LinearLayoutManager(this.context)

        binding.btnDeleteGroep.setOnClickListener{onDeleteRecipeBtn()}

        return binding.root
    }

    private fun onDeleteRecipeBtn() {
        for (groep in teVerwijderenGroepen) {
            groepLijstRepository.deleteGroep(groep)
        }
        findNavController().navigate(R.id.action_deleteGroepFragment_to_groepLijstFragment)
    }
}
