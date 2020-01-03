package com.chrisjanusa.randomizer.filter_distance.actions

import androidx.lifecycle.LiveData
import com.chrisjanusa.randomizer.base.interfaces.BaseAction
import com.chrisjanusa.randomizer.base.interfaces.BaseEvent
import com.chrisjanusa.randomizer.base.interfaces.BaseUpdater
import com.chrisjanusa.randomizer.base.models.MapUpdate
import com.chrisjanusa.randomizer.base.models.RandomizerState
import com.chrisjanusa.randomizer.filter_distance.DistanceHelper
import com.chrisjanusa.randomizer.filter_distance.updaters.TempDistanceUpdater
import kotlinx.coroutines.channels.Channel

class ResetDistanceAction : BaseAction {
    override suspend fun performAction(
        currentState: LiveData<RandomizerState>,
        updateChannel: Channel<BaseUpdater>,
        eventChannel: Channel<BaseEvent>,
        mapChannel: Channel<MapUpdate>
    ) {
        currentState.value?.run {
            updateChannel.send(
                TempDistanceUpdater(
                    DistanceHelper.defaultDistance
                )
            )
        }
    }
}