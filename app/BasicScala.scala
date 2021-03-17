package com.particeep.test

import scala.annotation.tailrec
import scala.util.matching.Regex
/**
  * This is basic language questions so don't use external library or build in function
  */
object BasicScala {


  /**
    * Encode parameter in url format
    *
    * Example:
    *
    * input  : Map("sort_by" -> "name", "order_by" -> "asc", "user_id" -> "12")
    * output : "?sort_by=name&order_by=asc&user_id=12"
    *
    * input  : Map()
    * output : ""
    */
  def encodeParamsInUrl(params: Map[String, String]): String = {
    def buildUrlRecursive(paramsList: List[(String, String)], spearator: String): String = {
      paramsList match {
        case (key, value) :: remainigParams => spearator + s"$key=$value" + buildUrlRecursive(remainigParams, "&")
        case List() => ""
      }
    }
    buildUrlRecursive(params.toList, "?")
  }

  /**
    * Test if a String is an email
    */
  def isEmail(maybeEmail: String): Boolean = {
    val regex = new Regex("""^[a-zA-Z0-9_+&*-]+(?:\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\.)+[a-zA-Z]{2,7}$""")
    regex.findFirstIn(maybeEmail.trim).nonEmpty
  }


  /**
    * Compute i ^ n
    *
    * Example:
    *
    * input : (i = 2, n = 3) we compute 2^3 = 2x2x2
    * output : 8
    *
    * input : (i = 99, n = 38997)
    * output : 1723793299
    */
  def power(i:Int, n:Int):Int = {
    @tailrec
    def loop(acc: Int, start: Int): Int = {
      if(start == 0) acc
      else loop(acc* i, start-1)
    }
    loop(1, n)
  }


}
