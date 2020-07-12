package com.josealfonsomora.mvvmsample.repositories

import io.reactivex.Observable
import java.util.concurrent.TimeUnit

class MapLocationRepositoy {
    fun getLiveLocation(): Observable<Coordinate> = Observable.fromArray(
        Coordinate(42.0269, -8.6423),
        Coordinate(42.0295, -8.6420),
        Coordinate(42.0320, -8.6422),
        Coordinate(42.0341, -8.6440),
        Coordinate(42.0361, -8.6466),
        Coordinate(42.0378, -8.6484),
        Coordinate(42.0404, -8.6479),
        Coordinate(42.0425, -8.6473),
        Coordinate(42.0444, -8.6456),
        Coordinate(42.0476, -8.6463),
        Coordinate(42.0492, -8.6432),
        Coordinate(42.0492, -8.6432),
        Coordinate(42.0476, -8.6463),
        Coordinate(42.0444, -8.6456),
        Coordinate(42.0425, -8.6473),
        Coordinate(42.0404, -8.6479),
        Coordinate(42.0378, -8.6484),
        Coordinate(42.0361, -8.6466),
        Coordinate(42.0341, -8.6440),
        Coordinate(42.0320, -8.6422),
        Coordinate(42.0295, -8.6420),
        Coordinate(42.0269, -8.6423)
    ).concatMap {
        Observable.just(it).delay(2, TimeUnit.SECONDS)
    }
}


data class Coordinate(val latitude: Double, val longitude: Double)
