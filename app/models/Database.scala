package models


import org.squeryl.{Table, Schema}
import org.squeryl.PrimitiveTypeMode._
/**
 * Created by Rayan on 19.10.14.
 */
object Database extends Schema {

  val events: Table[Event] = table[Event]("events")
  val venues: Table[Venue] = table[Venue]("venues")

  on(events) { e =>
    declare {
      e.id is autoIncremented
    }
  }

  on(venues) { v =>
    declare {
      v.id is autoIncremented
    }
  }


}
