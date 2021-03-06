package com.chrisjanusa.restaurant_base.deeplinks.events

import com.chrisjanusa.base.interfaces.BaseEvent
import com.chrisjanusa.base.interfaces.BaseRestaurantFragment
import com.chrisjanusa.restaurant_base.deeplinks.DeeplinkHelper.encodeUrl
import com.chrisjanusa.restaurant_base.deeplinks.DeeplinkHelper.openDeeplink
import com.chrisjanusa.yelp.models.Location

class OpenGoogleMapsEvent(private val name: String, private val location: Location) : BaseEvent {
    override fun handleEvent(fragment: BaseRestaurantFragment) {
        val query = encodeUrl("$name, ${location.address1}, ${location.city}, ${location.state}")
        fragment.context?.let { openDeeplink("https://www.google.com/maps/search/?api=1&query=$query",it)}
    }
}