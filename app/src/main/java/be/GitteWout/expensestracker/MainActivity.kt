package be.GitteWout.expensestracker

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import be.GitteWout.expensestracker.Expense.ExpenseLijstFragment
import com.example.expensestracker.R
import com.example.expensestracker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var menuBarToggle: ActionBarDrawerToggle

    private var expenseLijstFragment = ExpenseLijstFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setupMenuDrawer()

        setContentView(binding.root)
    }

    private fun setupMenuDrawer() {
        menuBarToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            R.string.menu_open,
            R.string.menu_close
        )
        binding.drawerLayout.addDrawerListener(menuBarToggle)
        menuBarToggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.mnu_navToDelete -> navigateToDelete()
                R.id.mnu_navToList -> navigateToExpensesList()
                R.id.mnu_navToAddExpense -> navigateToAddExpense()
            }
            true
        }
    }

    private fun navigateToDelete() {
        findNavController(binding.navHostFragment.id).navigate(R.id.action_menu_deleteExpenseFragment)
        binding.drawerLayout.closeDrawer(GravityCompat.START)
    }

    private fun navigateToExpensesList() {
        findNavController(binding.navHostFragment.id).navigate(R.id.action_menu_expenseLijstFragment)
        binding.drawerLayout.closeDrawer(GravityCompat.START)
    }

    private fun navigateToAddExpense() {
        findNavController(binding.navHostFragment.id).navigate(R.id.action_menu_addExpenseFragment)
        binding.drawerLayout.closeDrawer(GravityCompat.START)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (menuBarToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}





