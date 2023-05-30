package be.GitteWout.expensestracker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.findNavController
import be.GitteWout.expensestracker.Expense.ExpenseLijstFragment
import be.GitteWout.expensestracker.databinding.ActivityMainBinding


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
                R.id.mnu_callHelp -> callHelpcenter()
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

    fun hideKeyboard(view: View){
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken,0)
    }
    fun callHelpcenter(){
        val callIntent: Intent = Uri.parse("tel:0000000000").let { number ->
            Intent(Intent.ACTION_DIAL, number)
        }
        startActivity(callIntent)
    }
}





