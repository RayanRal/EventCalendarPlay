package models

/**
 * Created by Rayan on 08.06.14.
 */
object EventType extends Enumeration {

  type EventType = Value

  val Concert = Value(1, "Concert")
  val Exhibition = Value(2, "Exhibition")
  val Play = Value(3, "Play")

}
