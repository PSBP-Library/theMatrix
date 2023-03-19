## The "matrix" is a simple, text based, "share a bill app"

- Not every payment has to be done with all persons involved.
- Every participant of a payment can contribute to it or not.


Running `theMatrix` using `sbt` results (using fictive data) in

!(https://github.com/PSBP-Library/theMatrix/blob/main/Output.png)

```scala
sbt:theMatrix> run
[info] running theMatrix 

        .-------------------------------------------------------------------------------------------------------.
        |       John            Mary            Joe             Kelly           Donald          Mick            |
        .-------------------------------------------------------------------------------------------------------.
        |       90.5            0.0             9.5             0.0             xxxxxx          xxxxxx          |
        |       xxxxxx          xxxxxx          30.3            0.0             69.7            0.0             |
        |       100.0           0.0             50.0            0.0             150.0           0.0             |
        |       0.0             0.0             50.0            150.0           0.0             50.0            |
        .-------------------------------------------------------------------------------------------------------.
        |       65.5            -25.0           -15.5           -25.0           xxxxxx          xxxxxx          |
        |       xxxxxx          xxxxxx          5.3             -25.0           44.7            -25.0           |
        |       50.0            -50.0           0.0             -50.0           100.0           -50.0           |
        |       -41.67          -41.67          8.33            108.33          -41.67          8.33            |
        .-------------------------------------------------------------------------------------------------------.
        |       73.83           -116.67         -1.87           8.33            103.03          -66.67          |
        .-------------------------------------------------------------------------------------------------------.

true
[success] 
```

