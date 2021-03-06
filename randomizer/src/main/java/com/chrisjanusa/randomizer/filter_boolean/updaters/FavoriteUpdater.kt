package com.chrisjanusa.randomizer.filter_boolean.updaters

import com.chrisjanusa.base.interfaces.BaseUpdater
import com.chrisjanusa.base.models.RandomizerState
import java.util.HashSet

class FavoriteUpdater(private val favoriteSelected: Boolean) : BaseUpdater {
    override fun performUpdate(prevState: RandomizerState): RandomizerState {
        return prevState.copy(favoriteOnlySelected = favoriteSelected, restaurantCacheValid = false, restaurantsSeenRecently = HashSet())
    }
}