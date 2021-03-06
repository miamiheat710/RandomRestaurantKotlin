package com.chrisjanusa.randomizer.location_search.updaters

import com.chrisjanusa.base.interfaces.BaseUpdater
import com.chrisjanusa.base.models.RandomizerState

class LastManualLocationUpdater(private val locationStr: String) : BaseUpdater {
    override fun performUpdate(prevState: RandomizerState): RandomizerState {
        return prevState.copy(lastManualLocationText = locationStr)
    }
}