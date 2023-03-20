## `theMatrix` is a simple, text based, "share a bill app"

- Not every payment has to be done with all persons involved.
- Every participant of a payment can decide to 
  - not contribute to it with a zero amount,
  - contribute to it with a positive amount,
  - contribute to it with a negative amount.


Running `theMatrix` results in

https://github.com/PSBP-Library/theMatrix/blob/main/Output.png .

To use `theMatrix` yourself use your own csv file

similar to 

https://github.com/PSBP-Library/theMatrix/blob/main/payments.csv .

When adding payments to the csv it is useful to put blanks between the names
so that you put the right amount at the right place of a new payment

```
John    ,Mary    ,Joe     ,Kelly   ,Donald  ,Mick
0090.500,0000.000,0010.500,-001.000,xxxxxxxx,xxxxxxxx
xxxxxxxx,xxxxxxxx,0030.300,0000.000,0069.700,0000.000
0100.000,0000.000,0050.000,0000.000,0150.000,0000.000
0000.000,0000.000,0050.000,0150.000,0000.000,0050.000
```

When running `theMatrix` is advised to remove the blanks again
so that the results are correctly formatted.

