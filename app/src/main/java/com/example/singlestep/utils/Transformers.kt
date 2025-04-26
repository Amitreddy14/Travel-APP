package com.example.singlestep.utils

import com.amadeus.android.domain.resources.FlightOfferSearch
import com.example.singlestep.model.Flight
import com.example.singlestep.model.Itinerary
import com.example.singlestep.model.Location
import com.example.singlestep.model.RoomTripSummary
import com.example.singlestep.model.Segment
import com.example.singlestep.model.TripSummary
import com.google.android.libraries.places.api.model.Place

fun placeToLocation(place: Place): Location {
    return Location(
        place.name ?: "Unknown", // Fallback to "Unknown" if name is null
        null, place.latLng!!.latitude, place.latLng!!.longitude, place.photoMetadatas?.first()
    )
}

fun amadeusFlightListToFlightList(flightOfferSearchList: List<FlightOfferSearch>): List<Flight> {
    val flights: MutableList<Flight> = mutableListOf()
    flightOfferSearchList.forEach {
        flights.add(
            Flight(
                id = it.id,
                airlineCode = it.validatingAirlineCodes?.get(0),
                rawPrice = it.price?.grandTotal ?: 0.0,
                totalPrice = "${it.price?.currency} ${it.price?.grandTotal?.toInt()}",
                itineraries = amadeusItineraryListToItineraryList(it.itineraries)
            )
        )
    }
    return flights
}

fun amadeusItineraryListToItineraryList(amadeusItineraries: List<FlightOfferSearch.Itinerary>?): List<Itinerary> {
    val itineraries: MutableList<Itinerary> = mutableListOf()
    amadeusItineraries?.forEach { itinerary ->
        itineraries.add(Itinerary(amadeusSegmentListToSegmentList(itinerary.segments)))
    }
    return itineraries
}