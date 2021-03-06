package com.particeep.test

object WhatsWrong1 {

  trait Interface {
    val city: String
    val support: String = s"Ici c'est $city !"
  }

  case object Supporter extends Interface {

    override val city = "Paris"
  }

  Supporter.city //What does this print ? => this print: Paris
  Supporter.support //What does this print and why ? How to fix it ?
  // => this print: "Ici c'est null";  because support val is already computed
  // so the value of support is not computed at the call time.
  // a solution is to use lazy evaluation in Interface: lazy val support: String = s"Ici c'est $city !"
}
