package be.GitteWout.expensestracker.Expense

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import be.GitteWout.expensestracker.R
import be.GitteWout.expensestracker.databinding.FragmentDeleteExpenseBinding
import be.GitteWout.expensestracker.model.Expense
import be.GitteWout.expensestracker.model.ExpensePreferencesRepository


class DeleteExpenseFragment : Fragment(R.layout.fragment_delete_expense) {
    private lateinit var binding: FragmentDeleteExpenseBinding
    private lateinit var adapter: DeleteExpenseAdapter
    private lateinit var teVerwijderenExpenses: ArrayList<Expense>
    private lateinit var expenseLijstRepository: ExpensePreferencesRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDeleteExpenseBinding.inflate(layoutInflater)
        teVerwijderenExpenses = ArrayList()
        expenseLijstRepository = ExpensePreferencesRepository(requireActivity())

        val expenseLijst = expenseLijstRepository.loadExpenses()

        adapter = DeleteExpenseAdapter(expenseLijst, teVerwijderenExpenses)
        binding.rvwDelete.adapter = adapter
        binding.rvwDelete.layoutManager = LinearLayoutManager(this.context)

        binding.btnDeleteExpense.setOnClickListener { onDeleteExpenseBtn() }

        return binding.root
    }

    private fun onDeleteExpenseBtn() {
        for (expense in teVerwijderenExpenses) {
            expenseLijstRepository.deleteExpense(expense)
        }
        findNavController().navigate(R.id.action_deleteExpenseFragment_to_expenseLijstFragment)
    }
}