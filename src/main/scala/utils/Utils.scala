package utils

trait Monoid[M]:
  val zero: M
  val plus: (M, M) => M

  val sum: List[M] => M = _.foldLeft(zero)(plus)

given intMonoid: Monoid[Int] with
  val zero: Int = 0
  val plus: (Int, Int) => Int = (i, j) => i + j 

val intSum: List[Int] => Int = intMonoid.sum

given bigDecimalMonoid: Monoid[BigDecimal] with
  val zero: BigDecimal = 0.0
  val plus: (BigDecimal, BigDecimal) => BigDecimal = (c, d) => c + d   

val bigDecimalSum: List[BigDecimal] => BigDecimal = bigDecimalMonoid.sum

given stringMonoid: Monoid[String] with
  val zero: String = ""
  val plus: (String, String) => String = (s, t) => s"$s$t"
  
val stringSum: List[String] => String = stringMonoid.sum

// OK
