package controllers

import play.api.mvc.{Action, Controller}
import models.{EventType, Venue, Event}
import java.util.Date

/**
 * Created by Rayan on 19.10.14.
 */
object Events extends Controller {

  def details(id: Long) = Action {
    val event = Event.findById(id)
    val venue = Venue.findById(event.venue)
    Ok(views.html.eventDetails(event, venue))
  }

  def detailsByName(name: String) = Action {
    val event = Event.findByName(name)
    val venue = Venue.findById(event.venue)
    Ok(views.html.eventDetails(event, venue))
  }

  def list(page: Int) = Action {
    val listEvents = Event.findAll(page)
    Ok(views.html.eventList(listEvents))
  }

  def getAllOfType(typez: String) = Action {
    val typeEnum = EventType.withName(typez)
    val listEvents = Event.findByType(typeEnum)
    Ok("Found something by type")
  }

  def listByVenue(venueName: String) = Action {
    val venue = Venue.findByName(venueName)
    val listEvents = Event.findByVenue(venue)
    Ok("Events list found: " + listEvents(0).name + " will be held in " + venue.name)
  }

  def create(name: String, description: String, venue: String, typeString: String) = Action {
    val event = Event.create(name, description, new Date(), new Date(), typeString, venue)
    Ok("Created with id " + event.id)
  }

}
