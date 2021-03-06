package com.chrisjanusa.randomizer.filter_distance.updaters

import com.chrisjanusa.base.interfaces.BaseUpdater
import com.chrisjanusa.base.models.RandomizerState

class TempDistanceUpdater(private val newDist: Float) : BaseUpdater {
    override fun performUpdate(prevState: RandomizerState): RandomizerState {
        return prevState.copy(tempMaxMiles = newDist)
    }
}