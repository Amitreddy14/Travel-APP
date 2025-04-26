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