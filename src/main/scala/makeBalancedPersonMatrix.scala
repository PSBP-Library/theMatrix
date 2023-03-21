// makeBalancedPersonMatrix(payments) contains, for all persons, amounts paid too little or too much

val makeBalancedPersonMatrix = (payments: Payments) => makeBalancedPaymentMatrix(payments).transpose
