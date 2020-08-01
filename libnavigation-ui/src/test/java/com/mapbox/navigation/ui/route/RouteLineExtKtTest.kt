package com.mapbox.navigation.ui.route

import com.mapbox.api.directions.v5.models.DirectionsRoute
import com.mapbox.core.constants.Constants
import com.mapbox.geojson.LineString
import com.mapbox.turf.TurfConstants
import com.mapbox.turf.TurfMeasurement
import org.junit.Assert.assertEquals
import org.junit.Test

class RouteLineExtKtTest {

    val routeToUse = "{\"routeIndex\":\"0\",\"distance\":879.1,\"duration\":228.6,\"geometry\":\"miylgAniguhF{Cra@iBdVa@nFtThE`RpDpFfBr]xEvCd@nU~DUbCoBnd@vn@lC~EVzRj@jOfA~Rr@iAbQiBh^o@|N[fSlUjBbPpAnTfB|FeiA\",\"weight\":396.4,\"weight_name\":\"routability\",\"legs\":[{\"distance\":879.1,\"duration\":228.6,\"summary\":\"Nye Street, Lootens Place\",\"steps\":[{\"distance\":93.1,\"duration\":24.4,\"geometry\":\"miylgAniguhF{Cra@iBdVa@nF\",\"name\":\"Laurel Place\",\"mode\":\"driving\",\"maneuver\":{\"location\":[-122.523816,37.975207],\"bearing_before\":0.0,\"bearing_after\":280.0,\"instruction\":\"Head west on Laurel Place\",\"type\":\"depart\",\"modifier\":\"right\"},\"voiceInstructions\":[{\"distanceAlongGeometry\":93.1,\"announcement\":\"Head west on Laurel Place, then turn left onto Nye Street\",\"ssmlAnnouncement\":\"\\u003cspeak\\u003e\\u003camazon:effect name\\u003d\\\"drc\\\"\\u003e\\u003cprosody rate\\u003d\\\"1.08\\\"\\u003eHead west on Laurel Place, then turn left onto Nye Street\\u003c/prosody\\u003e\\u003c/amazon:effect\\u003e\\u003c/speak\\u003e\"},{\"distanceAlongGeometry\":57.2,\"announcement\":\"Turn left onto Nye Street\",\"ssmlAnnouncement\":\"\\u003cspeak\\u003e\\u003camazon:effect name\\u003d\\\"drc\\\"\\u003e\\u003cprosody rate\\u003d\\\"1.08\\\"\\u003eTurn left onto Nye Street\\u003c/prosody\\u003e\\u003c/amazon:effect\\u003e\\u003c/speak\\u003e\"}],\"bannerInstructions\":[{\"distanceAlongGeometry\":93.1,\"primary\":{\"text\":\"Nye Street\",\"components\":[{\"text\":\"Nye Street\",\"type\":\"text\",\"abbr\":\"Nye St\",\"abbr_priority\":0}],\"type\":\"turn\",\"modifier\":\"left\"}}],\"driving_side\":\"right\",\"weight\":54.9,\"intersections\":[{\"location\":[-122.523816,37.975207],\"bearings\":[280],\"entry\":[true],\"out\":0}]},{\"distance\":193.5,\"duration\":57.7,\"geometry\":\"urylgAxjiuhFtThE`RpDpFfBr]xEvCd@nU~D\",\"name\":\"Nye Street\",\"mode\":\"driving\",\"maneuver\":{\"location\":[-122.524861,37.975355],\"bearing_before\":279.0,\"bearing_after\":192.0,\"instruction\":\"Turn left onto Nye Street\",\"type\":\"turn\",\"modifier\":\"left\"},\"voiceInstructions\":[{\"distanceAlongGeometry\":173.5,\"announcement\":\"In 600 feet, turn right onto 5th Avenue\",\"ssmlAnnouncement\":\"\\u003cspeak\\u003e\\u003camazon:effect name\\u003d\\\"drc\\\"\\u003e\\u003cprosody rate\\u003d\\\"1.08\\\"\\u003eIn 600 feet, turn right onto \\u003csay-as interpret-as\\u003d\\\"address\\\"\\u003e5th\\u003c/say-as\\u003e Avenue\\u003c/prosody\\u003e\\u003c/amazon:effect\\u003e\\u003c/speak\\u003e\"},{\"distanceAlongGeometry\":50.3,\"announcement\":\"Turn right onto 5th Avenue, then turn left onto Lootens Place\",\"ssmlAnnouncement\":\"\\u003cspeak\\u003e\\u003camazon:effect name\\u003d\\\"drc\\\"\\u003e\\u003cprosody rate\\u003d\\\"1.08\\\"\\u003eTurn right onto \\u003csay-as interpret-as\\u003d\\\"address\\\"\\u003e5th\\u003c/say-as\\u003e Avenue, then turn left onto Lootens Place\\u003c/prosody\\u003e\\u003c/amazon:effect\\u003e\\u003c/speak\\u003e\"}],\"bannerInstructions\":[{\"distanceAlongGeometry\":193.5,\"primary\":{\"text\":\"5th Avenue\",\"components\":[{\"text\":\"5th Avenue\",\"type\":\"text\",\"abbr\":\"5th Ave\",\"abbr_priority\":0}],\"type\":\"turn\",\"modifier\":\"right\"}},{\"distanceAlongGeometry\":50.3,\"primary\":{\"text\":\"5th Avenue\",\"components\":[{\"text\":\"5th Avenue\",\"type\":\"text\",\"abbr\":\"5th Ave\",\"abbr_priority\":0}],\"type\":\"turn\",\"modifier\":\"right\"},\"sub\":{\"text\":\"Lootens Place\",\"components\":[{\"text\":\"Lootens Place\",\"type\":\"text\",\"abbr\":\"Lootens Pl\",\"abbr_priority\":0}],\"type\":\"turn\",\"modifier\":\"left\"}}],\"driving_side\":\"right\",\"weight\":70.5,\"intersections\":[{\"location\":[-122.524861,37.975355],\"bearings\":[15,105,195,285],\"entry\":[true,false,true,true],\"in\":1,\"out\":2},{\"location\":[-122.525103,37.974582],\"bearings\":[15,105,195,285],\"entry\":[false,true,true,true],\"in\":0,\"out\":2}]},{\"distance\":58.9,\"duration\":13.1,\"geometry\":\"ohvlgA|gjuhFUbCoBnd@\",\"name\":\"5th Avenue\",\"mode\":\"driving\",\"maneuver\":{\"location\":[-122.525327,37.973656],\"bearing_before\":191.0,\"bearing_after\":281.0,\"instruction\":\"Turn right onto 5th Avenue\",\"type\":\"turn\",\"modifier\":\"right\"},\"voiceInstructions\":[{\"distanceAlongGeometry\":58.9,\"announcement\":\"Turn left onto Lootens Place\",\"ssmlAnnouncement\":\"\\u003cspeak\\u003e\\u003camazon:effect name\\u003d\\\"drc\\\"\\u003e\\u003cprosody rate\\u003d\\\"1.08\\\"\\u003eTurn left onto Lootens Place\\u003c/prosody\\u003e\\u003c/amazon:effect\\u003e\\u003c/speak\\u003e\"}],\"bannerInstructions\":[{\"distanceAlongGeometry\":58.9,\"primary\":{\"text\":\"Lootens Place\",\"components\":[{\"text\":\"Lootens Place\",\"type\":\"text\",\"abbr\":\"Lootens Pl\",\"abbr_priority\":0}],\"type\":\"turn\",\"modifier\":\"left\"}}],\"driving_side\":\"right\",\"weight\":47.3,\"intersections\":[{\"location\":[-122.525327,37.973656],\"bearings\":[15,105,180,285],\"entry\":[false,true,true,true],\"in\":0,\"out\":3}]},{\"distance\":198.1,\"duration\":60.8,\"geometry\":\"ulvlgApqkuhFvn@lC~EVzRj@jOfA~Rr@\",\"name\":\"Lootens Place\",\"mode\":\"driving\",\"maneuver\":{\"location\":[-122.525993,37.973723],\"bearing_before\":275.0,\"bearing_after\":182.0,\"instruction\":\"Turn left onto Lootens Place\",\"type\":\"turn\",\"modifier\":\"left\"},\"voiceInstructions\":[{\"distanceAlongGeometry\":178.1,\"announcement\":\"In 600 feet, turn right onto 3rd Street\",\"ssmlAnnouncement\":\"\\u003cspeak\\u003e\\u003camazon:effect name\\u003d\\\"drc\\\"\\u003e\\u003cprosody rate\\u003d\\\"1.08\\\"\\u003eIn 600 feet, turn right onto \\u003csay-as interpret-as\\u003d\\\"address\\\"\\u003e3rd\\u003c/say-as\\u003e Street\\u003c/prosody\\u003e\\u003c/amazon:effect\\u003e\\u003c/speak\\u003e\"},{\"distanceAlongGeometry\":48.9,\"announcement\":\"Turn right onto 3rd Street, then turn left onto Brooks Street\",\"ssmlAnnouncement\":\"\\u003cspeak\\u003e\\u003camazon:effect name\\u003d\\\"drc\\\"\\u003e\\u003cprosody rate\\u003d\\\"1.08\\\"\\u003eTurn right onto \\u003csay-as interpret-as\\u003d\\\"address\\\"\\u003e3rd\\u003c/say-as\\u003e Street, then turn left onto Brooks Street\\u003c/prosody\\u003e\\u003c/amazon:effect\\u003e\\u003c/speak\\u003e\"}],\"bannerInstructions\":[{\"distanceAlongGeometry\":198.1,\"primary\":{\"text\":\"3rd Street\",\"components\":[{\"text\":\"3rd Street\",\"type\":\"text\",\"abbr\":\"3rd St\",\"abbr_priority\":0}],\"type\":\"turn\",\"modifier\":\"right\"}},{\"distanceAlongGeometry\":48.9,\"primary\":{\"text\":\"3rd Street\",\"components\":[{\"text\":\"3rd Street\",\"type\":\"text\",\"abbr\":\"3rd St\",\"abbr_priority\":0}],\"type\":\"turn\",\"modifier\":\"right\"},\"sub\":{\"text\":\"Brooks Street\",\"components\":[{\"text\":\"Brooks Street\",\"type\":\"text\",\"abbr\":\"Brooks St\",\"abbr_priority\":0}],\"type\":\"turn\",\"modifier\":\"left\"}}],\"driving_side\":\"right\",\"weight\":89.2,\"intersections\":[{\"location\":[-122.525993,37.973723],\"bearings\":[15,90,180,300],\"entry\":[true,false,true,true],\"in\":1,\"out\":2},{\"location\":[-122.526064,37.972959],\"bearings\":[0,105,180,270],\"entry\":[false,true,true,true],\"in\":0,\"out\":2},{\"location\":[-122.526098,37.972529],\"bearings\":[0,105,180],\"entry\":[false,true,true],\"in\":0,\"out\":2}]},{\"distance\":121.0,\"duration\":15.2,\"geometry\":\"u}rlgA~{kuhFiAbQiBh^o@|N[fS\",\"name\":\"3rd Street\",\"mode\":\"driving\",\"maneuver\":{\"location\":[-122.52616,37.971947],\"bearing_before\":182.0,\"bearing_after\":278.0,\"instruction\":\"Turn right onto 3rd Street\",\"type\":\"end of road\",\"modifier\":\"right\"},\"voiceInstructions\":[{\"distanceAlongGeometry\":119.4,\"announcement\":\"Turn left onto Brooks Street, then turn left onto 2nd Street\",\"ssmlAnnouncement\":\"\\u003cspeak\\u003e\\u003camazon:effect name\\u003d\\\"drc\\\"\\u003e\\u003cprosody rate\\u003d\\\"1.08\\\"\\u003eTurn left onto Brooks Street, then turn left onto \\u003csay-as interpret-as\\u003d\\\"address\\\"\\u003e2nd\\u003c/say-as\\u003e Street\\u003c/prosody\\u003e\\u003c/amazon:effect\\u003e\\u003c/speak\\u003e\"}],\"bannerInstructions\":[{\"distanceAlongGeometry\":121.0,\"primary\":{\"text\":\"Brooks Street\",\"components\":[{\"text\":\"Brooks Street\",\"type\":\"text\",\"abbr\":\"Brooks St\",\"abbr_priority\":0}],\"type\":\"turn\",\"modifier\":\"left\"}},{\"distanceAlongGeometry\":119.4,\"primary\":{\"text\":\"Brooks Street\",\"components\":[{\"text\":\"Brooks Street\",\"type\":\"text\",\"abbr\":\"Brooks St\",\"abbr_priority\":0}],\"type\":\"turn\",\"modifier\":\"left\"},\"sub\":{\"text\":\"2nd Street\",\"components\":[{\"text\":\"2nd Street\",\"type\":\"text\",\"abbr\":\"2nd St\",\"abbr_priority\":0}],\"type\":\"turn\",\"modifier\":\"left\"}}],\"driving_side\":\"right\",\"weight\":45.2,\"intersections\":[{\"location\":[-122.52616,37.971947],\"bearings\":[0,105,285],\"entry\":[false,false,true],\"in\":0,\"out\":2}]},{\"distance\":109.4,\"duration\":49.9,\"geometry\":\"ueslgArqnuhFlUjBbPpAnTfB\",\"name\":\"Brooks Street\",\"mode\":\"driving\",\"maneuver\":{\"location\":[-122.52753,37.972075],\"bearing_before\":272.0,\"bearing_after\":185.0,\"instruction\":\"Turn left onto Brooks Street\",\"type\":\"turn\",\"modifier\":\"left\"},\"voiceInstructions\":[{\"distanceAlongGeometry\":32.9,\"announcement\":\"Turn left onto 2nd Street, then you will arrive at your destination\",\"ssmlAnnouncement\":\"\\u003cspeak\\u003e\\u003camazon:effect name\\u003d\\\"drc\\\"\\u003e\\u003cprosody rate\\u003d\\\"1.08\\\"\\u003eTurn left onto \\u003csay-as interpret-as\\u003d\\\"address\\\"\\u003e2nd\\u003c/say-as\\u003e Street, then you will arrive at your destination\\u003c/prosody\\u003e\\u003c/amazon:effect\\u003e\\u003c/speak\\u003e\"}],\"bannerInstructions\":[{\"distanceAlongGeometry\":109.4,\"primary\":{\"text\":\"2nd Street\",\"components\":[{\"text\":\"2nd Street\",\"type\":\"text\",\"abbr\":\"2nd St\",\"abbr_priority\":0}],\"type\":\"turn\",\"modifier\":\"left\"}}],\"driving_side\":\"right\",\"weight\":81.8,\"intersections\":[{\"location\":[-122.52753,37.972075],\"bearings\":[90,180,270],\"entry\":[false,true,true],\"in\":0,\"out\":1}]},{\"distance\":105.0,\"duration\":7.5,\"geometry\":\"shqlgAxznuhF|FeiA\",\"name\":\"2nd Street\",\"mode\":\"driving\",\"maneuver\":{\"location\":[-122.527677,37.971098],\"bearing_before\":185.0,\"bearing_after\":97.0,\"instruction\":\"Turn left onto 2nd Street\",\"type\":\"turn\",\"modifier\":\"left\"},\"voiceInstructions\":[{\"distanceAlongGeometry\":70.0,\"announcement\":\"You have arrived at your destination, on the right\",\"ssmlAnnouncement\":\"\\u003cspeak\\u003e\\u003camazon:effect name\\u003d\\\"drc\\\"\\u003e\\u003cprosody rate\\u003d\\\"1.08\\\"\\u003eYou have arrived at your destination, on the right\\u003c/prosody\\u003e\\u003c/amazon:effect\\u003e\\u003c/speak\\u003e\"}],\"bannerInstructions\":[{\"distanceAlongGeometry\":105.0,\"primary\":{\"text\":\"You will arrive\",\"components\":[{\"text\":\"You will arrive\",\"type\":\"text\"}],\"type\":\"arrive\",\"modifier\":\"right\"}},{\"distanceAlongGeometry\":70.0,\"primary\":{\"text\":\"You have arrived\",\"components\":[{\"text\":\"You have arrived\",\"type\":\"text\"}],\"type\":\"arrive\",\"modifier\":\"right\"}}],\"driving_side\":\"right\",\"weight\":7.5,\"intersections\":[{\"location\":[-122.527677,37.971098],\"bearings\":[0,105,270],\"entry\":[false,true,false],\"in\":0,\"out\":1}]},{\"distance\":0.0,\"duration\":0.0,\"geometry\":\"u`qlgArpluhF\",\"name\":\"2nd Street\",\"mode\":\"driving\",\"maneuver\":{\"location\":[-122.52649,37.970971],\"bearing_before\":98.0,\"bearing_after\":0.0,\"instruction\":\"You have arrived at your destination, on the right\",\"type\":\"arrive\",\"modifier\":\"right\"},\"voiceInstructions\":[],\"bannerInstructions\":[],\"driving_side\":\"right\",\"weight\":0.0,\"intersections\":[{\"location\":[-122.52649,37.970971],\"bearings\":[278],\"entry\":[true],\"in\":0}]}],\"annotation\":{\"distance\":[49.34180914849393,33.05802569090612,10.689795908138624,39.59839199650681,34.80992351675273,14.209672171473654,55.332462814681335,8.615785848371143,40.91659557025385,5.914738766868038,52.97482177741399,85.20461216655733,12.501699782507817,35.42252405667138,29.311743333674485,35.66534898263901,25.758372926868166,44.32194001964289,22.517423451854935,28.451254156899267,40.20997808786729,30.687302775025532,38.532552346674045,105.03289645548367],\"congestion\":[\"low\",\"unknown\",\"unknown\",\"low\",\"unknown\",\"unknown\",\"heavy\",\"low\",\"low\",\"unknown\",\"low\",\"heavy\",\"low\",\"low\",\"low\",\"low\",\"low\",\"low\",\"low\",\"low\",\"unknown\",\"unknown\",\"unknown\",\"low\"]}}],\"routeOptions\":{\"baseUrl\":\"https://api.mapbox.com\",\"user\":\"mapbox\",\"profile\":\"driving-traffic\",\"coordinates\":[[-122.5237734,37.9753973],[-122.5264995,37.9709171]],\"alternatives\":true,\"language\":\"en\",\"continue_straight\":false,\"roundabout_exits\":false,\"geometries\":\"polyline6\",\"overview\":\"full\",\"steps\":true,\"annotations\":\"congestion,distance\",\"voice_instructions\":true,\"banner_instructions\":true,\"voice_units\":\"imperial\",\"access_token\":\"pk.eyJ1Ijoic2V0aC1ib3VyZ2V0IiwiYSI6ImNrYjAwNnk5ODAzYnEycnBvMTgzajdhanUifQ.vfwMqIW8sThk0s58JyvaJg\",\"uuid\":\"ckd9ao6hl13a97ars2byaymo7\"},\"voiceLocale\":\"en-US\"}"

    private fun getDirectionsRoute(): DirectionsRoute {
        return DirectionsRoute.fromJson(routeToUse)
    }

    @Test
    fun alongQuarterBefore() {
        val lineString = LineString.fromPolyline(getDirectionsRoute().geometry()!!, Constants.PRECISION_6)
        val points = lineString.coordinates()
        val distanceList = mutableListOf<Double>()
        for(index in 0 until points.size - 1) {
            val dist = TurfMeasurement.distance(points[index], points[index + 1], TurfConstants.UNIT_METERS)
            distanceList.add(dist)
        }
        val totalKnownDistance = distanceList.take(4).sum()

        val midPoint = TurfMeasurement.midpoint(points[4], points[5])
        val quarterPoint = TurfMeasurement.midpoint(points[4], midPoint)

        val expectedDist = totalKnownDistance + TurfMeasurement.distance(points[4], quarterPoint, TurfConstants.UNIT_METERS)

        val result = findDistanceOfPointAlongLine(lineString, quarterPoint)

        assertEquals(expectedDist, result, 0.00000001)
    }

    @Test
    fun alongQuarterAfter() {
        val lineString = LineString.fromPolyline(getDirectionsRoute().geometry()!!, Constants.PRECISION_6)
        val points = lineString.coordinates()
        val distanceList = mutableListOf<Double>()
        for(index in 0 until points.size - 1) {
            val dist = TurfMeasurement.distance(points[index], points[index + 1], TurfConstants.UNIT_METERS)
            distanceList.add(dist)
        }
        val totalKnownDistance = distanceList.take(4).sum()

        val midPoint = TurfMeasurement.midpoint(points[4], points[5])
        val quarterPoint = TurfMeasurement.midpoint(midPoint, points[5])

        val expectedDist = totalKnownDistance + TurfMeasurement.distance(points[4], quarterPoint, TurfConstants.UNIT_METERS)

        val result = findDistanceOfPointAlongLine(lineString, quarterPoint)

        assertEquals(expectedDist, result, 0.00000001)
    }

    @Test
    fun alongMidPoint() {
        val lineString = LineString.fromPolyline(getDirectionsRoute().geometry()!!, Constants.PRECISION_6)
        val points = lineString.coordinates()
        val distanceList = mutableListOf<Double>()
        for(index in 0 until points.size - 1) {
            val dist = TurfMeasurement.distance(points[index], points[index + 1], TurfConstants.UNIT_METERS)
            distanceList.add(dist)
        }
        val totalKnownDistance = distanceList.take(4).sum()

        val midPoint = TurfMeasurement.midpoint(points[4], points[5])

        val expectedDist = totalKnownDistance + TurfMeasurement.distance(points[4], midPoint, TurfConstants.UNIT_METERS)

        val result = findDistanceOfPointAlongLine(lineString, midPoint)

        assertEquals(expectedDist, result, 0.00000001)
    }

    @Test
    fun alongQuarterBeforeLast() {
        val directionsRoute = getDirectionsRoute()
        val lineString = LineString.fromPolyline(directionsRoute.geometry()!!, Constants.PRECISION_6)
        val points = lineString.coordinates()
        val distanceList = mutableListOf<Double>()
        for(index in 0 until points.size - 1) {
            val dist = TurfMeasurement.distance(points[index], points[index + 1], TurfConstants.UNIT_METERS)
            distanceList.add(dist)
        }
        val totalKnownDistance = distanceList.sum()

        val midPoint = TurfMeasurement.midpoint(points[points.size - 2], points[points.size - 1])
        val quarterPoint = TurfMeasurement.midpoint(midPoint, points[points.size - 1])

        val expectedDist = totalKnownDistance - TurfMeasurement.distance(quarterPoint, points[points.size - 1], TurfConstants.UNIT_METERS)

        val result = findDistanceOfPointAlongLine(lineString, quarterPoint)

        val calculatedTotalDistance = result + TurfMeasurement.distance(quarterPoint, points[points.size - 1], TurfConstants.UNIT_METERS)

        assertEquals(expectedDist, result, 0.00000001)
        assertEquals(totalKnownDistance, calculatedTotalDistance, 0.00000001)
        assertEquals(directionsRoute.distance()!!, calculatedTotalDistance, 0.1)
    }
}