package be.GitteWout.expensestracker.Expense


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import be.GitteWout.expensestracker.R
import be.GitteWout.expensestracker.databinding.FragmentExpensedetailBinding
import be.GitteWout.expensestracker.model.ExpensePreferencesRepository
import be.GitteWout.expensestracker.model.ImageFileRepository

class ExpenseDetailFragment : Fragment(R.layout.fragment_expensedetail) {

    private lateinit var binding: FragmentExpensedetailBinding
    private lateinit var expenseRepository: ExpensePreferencesRepository
    private lateinit var imageRepository: ImageFileRepository
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExpensedetailBinding.inflate(layoutInflater)

        expenseRepository = ExpensePreferencesRepository(requireActivity())
        imageRepository = ImageFileRepository(requireContext())

        val expenseNaam = arguments?.getString("naam")
        val expense = expenseRepository.getExpense(expenseNaam)

        binding.txtnaamDetail2.text = expense.getNaam()
        binding.txtBedragDetail2.text = "€" + expense.getBedrag().toString()
        binding.txtExpenseDatum.text = expense.getDatum()

        expense.getImagePath().let {
            if (it != null) {
                imageRepository.loadImage(it)?.let {
                    binding.imageRekening.setImageBitmap(it)
                }
            } else {
                binding.txtGeenFoto.text = "Geen kassaticket beschikbaar"
                binding.txtkassaticket.text = ""
            }
        }

        return binding.root
    }
}