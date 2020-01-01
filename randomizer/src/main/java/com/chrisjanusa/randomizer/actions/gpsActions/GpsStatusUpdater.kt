package com.chrisjanusa.randomizer.actions.gpsActions

import com.chrisjanusa.randomizer.actions.base.BaseUpdater
import com.chrisjanusa.randomizer.models.RandomizerState

class GpsStatusUpdater(private val gpsOn : Boolean) :
    BaseUpdater {

    override fun performUpdate(prevState: RandomizerState): RandomizerState {
        return prevState.copy(gpsOn = gpsOn)
    }
}