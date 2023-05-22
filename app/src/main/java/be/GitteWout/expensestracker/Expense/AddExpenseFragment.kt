package be.GitteWout.expensestracker.Expense

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import be.GitteWout.expensestracker.MainActivity
import com.example.expensestracker.R
import com.example.expensestracker.databinding.FragmentAddexpenseBinding
import be.GitteWout.expensestracker.model.Expense
import be.GitteWout.expensestracker.model.ExpensePreferencesRepository
import be.GitteWout.expensestracker.model.ImageFileRepository


class AddExpenseFragment : Fragment(R.layout.fragment_addexpense) {

    private lateinit var binding: FragmentAddexpenseBinding
    private lateinit var main: MainActivity
    private lateinit var expenseRepository: ExpensePreferencesRepository
    private lateinit var pictureActivityResult: ActivityResultLauncher<Void?>

    private var expenseImagePath: String? = null
    private var image: Bitmap? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddexpenseBinding.inflate(layoutInflater)
        main = activity as MainActivity
        expenseRepository = ExpensePreferencesRepository(requireActivity())


        binding.btnAddExpense.setOnClickListener {
            addExpense()
        }

        binding.btnAddPicture.setOnClickListener {
            takePicture()
        }

        pictureActivityResult =
            registerForActivityResult(ActivityResultContracts.TakePicturePreview()) {
                it?.let { image = it }
            }

        return binding.root
    }

    private fun addExpense() {
        val naam = binding.txtExpenseNaam.text.toString()
        val bedragString = binding.txtExpenseBedrag.text.toString()
        if (naam.isNotBlank() && bedragString.isNotBlank()) {
            val bedrag = bedragString.toDouble()
            image?.let {
                expenseImagePath = "Image_${naam}"
                val imageRepository = ImageFileRepository(requireContext())
                imageRepository.saveImage(it, expenseImagePath!!)
            }

            val expense = Expense(naam, bedrag, expenseImagePath)
            expenseRepository.saveExpense(expense)
            findNavController().navigate(R.id.action_addExpenseFragment_to_expenseLijstFragment)
        } else if (naam.isNotBlank() && bedragString.isBlank()) {
            Toast.makeText(requireContext(), "Geen bedrag ingevuld", Toast.LENGTH_LONG)
                .show()
        } else if (naam.isBlank() && bedragString.isNotBlank()) {
            Toast.makeText(requireContext(), "Geen naam ingevuld", Toast.LENGTH_LONG)
                .show()
        } else if (naam.isBlank() && bedragString.isBlank()) {
            Toast.makeText(requireContext(), "Geen naam en geen bedrag ingevuld", Toast.LENGTH_LONG)
                .show()
        }
    }


    private fun takePicture() {
        pictureActivityResult.launch(null)
    }
}