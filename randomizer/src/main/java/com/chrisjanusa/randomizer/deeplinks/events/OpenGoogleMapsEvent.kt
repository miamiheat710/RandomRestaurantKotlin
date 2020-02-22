package com.chrisjanusa.randomizer.deeplinks.events

import com.chrisjanusa.randomizer.RandomizerFragment
import com.chrisjanusa.randomizer.base.interfaces.BaseEvent
import com.chrisjanusa.randomizer.deeplinks.DeeplinkHelper.encodeUrl
import com.chrisjanusa.randomizer.deeplinks.DeeplinkHelper.openDeeplink
import com.chrisjanusa.yelp.models.Location

class OpenGoogleMapsEvent(private val name: String, private val location: Location) : BaseEvent {
    override fun handleEvent(fragment: RandomizerFragment) {
        val query = encodeUrl("$name, ${location.address1}, ${location.city}, ${location.state}")
        fragment.context?.let { openDeeplink("https://www.google.com/maps/search/?api=1&query=$query",it)}
    }
}