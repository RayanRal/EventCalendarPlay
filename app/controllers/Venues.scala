package controllers

import play.api.mvc.{Action, Controller}
import models.Venue

/**
 * Created by Rayan on 19.10.14.
 */
object Venues extends Controller {

  def list(page: Int) = Action {
    val venues = Venue.findAll(page)
    Ok(views.html.venueList(venues))
  }

  def detailsByName(name: String) = Action {
    val venue = Venue.findByName(name)
    Ok(views.html.venueDetails(venue))
  }

  def details(id: Long) = Action {
    val venue = Venue.findById(id)
    Ok(views.html.venueDetails(venue))
  }

  def create(x: Long, y: Long, name: String, address: String, description: String) = Action {
    val venue = Venue.create(x, y, name, address, description)
    Ok("Venue created: " + venue.id)
  }

}
