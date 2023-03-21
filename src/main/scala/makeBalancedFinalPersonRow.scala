// makeBalancedFinalPersonRow(payments) , for all persons, total amount paid too little or too much

val makeBalancedFinalPersonRow = (payments: Payments) => makeBalancedPersonMatrix(payments).map(totalAmount)
