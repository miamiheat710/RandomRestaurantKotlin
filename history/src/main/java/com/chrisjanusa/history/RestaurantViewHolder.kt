package com.chrisjanusa.history

import android.view.LayoutInflater
import android.view.ViewGroup
import com.chrisjanusa.base.models.RandomizerViewModel
import com.chrisjanusa.baselist.BaseRestaurantViewHolder
import com.chrisjanusa.history.HistoryListUIManager.renderFavBlock
import com.chrisjanusa.yelp.models.Restaurant

class RestaurantViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    BaseRestaurantViewHolder(inflater, parent) {

    override fun bind(
        restaurant: Restaurant,
        randomizerViewModel: RandomizerViewModel
    ) {
        super.bind(restaurant, randomizerViewModel)
        renderFavBlock(restaurant, itemView, randomizerViewModel, adapterPosition)
    }

}