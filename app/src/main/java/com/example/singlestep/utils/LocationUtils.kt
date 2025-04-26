package com.example.singlestep.utils

import kotlin.math.PI
import kotlin.math.asin
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.min
import kotlin.math.sin

fun getBoundingBox(centerPoint: Pair<Double, Double>, distance: Double): List<Double> {
    val minLatLimit: Double
    val maxLatLimit: Double
    val minLonLimit: Double
    val maxLonLimit: Double
    val radLat: Double
    val radLon: Double
    var minLat: Double
    var maxLat: Double
    var minLon: Double
    var maxLon: Double
    val deltaLon: Double

    if (distance < 0) {
        return listOf() // Returning an empty list as an indication of illegal arguments
    }

    // Helper functions (degrees to radians)
    fun Number.degToRad(): Double = this.toDouble() * (Math.PI / 180)
    fun Number.radToDeg(): Double = this.toDouble() * (180 / Math.PI)

    // Coordinate limits
    minLatLimit = (-90).degToRad()
    maxLatLimit = (90).degToRad()
    minLonLimit = (-180).degToRad()
    maxLonLimit = (180).degToRad()