package be.GitteWout.expensestracker.model

class ExpenseFilter {
    fun filterExpenses(expenseList: List<Expense>, searchText: CharSequence?): List<Expense>{
        val filteredList: MutableList<Expense> = mutableListOf()
        for(item: Expense in expenseList){
            if(item.getNaam().lowercase().contains(searchText.toString().lowercase())){
                filteredList.add(item)
            }
        }
        return filteredList
    }
}