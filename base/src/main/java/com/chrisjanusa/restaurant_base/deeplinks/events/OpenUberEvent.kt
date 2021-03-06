package com.chrisjanusa.restaurant_base.deeplinks.events

import com.chrisjanusa.base.BuildConfig.uberClientId
import com.chrisjanusa.base.interfaces.BaseEvent
import com.chrisjanusa.base.interfaces.BaseRestaurantFragment
import com.chrisjanusa.restaurant_base.deeplinks.DeeplinkHelper.encodeUrl
import com.chrisjanusa.restaurant_base.deeplinks.DeeplinkHelper.openDeeplink
import com.chrisjanusa.yelp.models.Coordinates
import com.chrisjanusa.yelp.models.Location

class OpenUberEvent(private val name: String, private val location: Location, private val coordinates: Coordinates) : BaseEvent {
    override fun handleEvent(fragment: BaseRestaurantFragment) {
        val formattedAddress = encodeUrl("${location.address1}, ${location.city}, ${location.state}")
        val nickname = encodeUrl(name)
        fragment.context?.let{context ->
            try {
                val url = "uber://?client_id=$uberClientId&action=setPickup&dropoff[latitude]=${coordinates.latitude}l&dropoff[longitude]=${coordinates.longitude}&dropoff[nickname]=$nickname&dropoff[formatted_address]=$formattedAddress"
                openDeeplink(url, context)
            } catch (throwable : Throwable) {
                val url = "https://m.uber.com/?client_id=$uberClientId&action=setPickup&dropoff[latitude]=${coordinates.latitude}l&dropoff[longitude]=${coordinates.longitude}&dropoff[nickname]=$nickname&dropoff[formatted_address]=$formattedAddress"
                openDeeplink(url, context)
            }
        }
    }
}