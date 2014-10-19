package models

import org.squeryl.KeyedEntity
import org.squeryl.PrimitiveTypeMode._
import java.sql.Timestamp
import java.util.Date

/**
 * Created by Rayan on 08.06.14.
 */
case class Event(id: Long, startDate: Date, endDate: Date,
                  venue: Long, eventType: EventType.Value, name: String, description: String)
              extends KeyedEntity[Long] {

  def this() = this(0L, new Timestamp(1), new Timestamp(1), 0L, EventType.Concert, "", "")
}

object Event {

  import Database._

  def findAll = inTransaction { from(events)(event => select(event)).toList }

  def findByName(name: String) = inTransaction {
    from(events)(event => where(event.name === name) select event).single
  }

  def findById(id: Long) = inTransaction {
    from(events)(event => where(event.id === id) select event).single
  }

  def findByType(typ: EventType.Value) = inTransaction {
    from(events)(event => where(event.eventType === typ) select event).toList
  }

  def findByVenue(venue: Venue) = inTransaction {
    join(events, venues)((events, venues) =>
      where(venues.id === venue.id) select venues on (events.venue === venues.id)).toList
  }

  def create(name: String, description: String, startDate: Date, endDate: Date, typez: String, venueName: String) = inTransaction {
    val eventType = EventType.withName(typez)
    val venue = Venue.findByName(venueName)
    events.insert(new Event(0L, startDate, endDate, venue.id, eventType, name, description))
  }

}