package models

import org.squeryl.KeyedEntity
import org.squeryl.PrimitiveTypeMode._

/**
 * Created by Rayan on 08.06.14.
 */
case class Venue(id: Long, x: Long, y: Long, name: String, address: String, description: String)
      extends KeyedEntity[Long]

object Venue {

  import Database._

  def findAll(page: Int) = inTransaction {
    val pageLength = 10
    from(venues)(venues => select(venues)).page(pageLength * page, pageLength).toList
  }

  def findByName(name: String) = inTransaction {
    from(venues)(venues => where(venues.name === name) select venues).single
  }

  def findById(id: Long) = inTransaction {
    from(venues)(venues => where(venues.id === id) select venues).single
  }

  def create(x: Long, y: Long, name: String, address: String, description: String) = inTransaction {
    venues.insert(new Venue(0L, x, y, name, address, description))
  }
}