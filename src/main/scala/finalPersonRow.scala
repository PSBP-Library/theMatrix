// finalPersonRow contains total amounts paid too little or too much per person

val finalPersonRow = (payments: Payments) => 
  personMatrix(payments).map(totalAmount)