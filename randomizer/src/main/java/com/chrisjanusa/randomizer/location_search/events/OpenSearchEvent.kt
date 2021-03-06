package com.chrisjanusa.randomizer.location_search.events

import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.chrisjanusa.randomizer.R
import com.chrisjanusa.base.interfaces.BaseEvent
import com.chrisjanusa.base.interfaces.BaseRestaurantFragment
import com.chrisjanusa.randomizer.location_search.SearchHelper
import kotlinx.android.synthetic.main.search_card.*

class OpenSearchEvent(private val addressSearchText: String) : BaseEvent {
    override fun handleEvent(fragment: BaseRestaurantFragment) {
        fragment.run {
            // Setup the layout
            val layoutParams = ConstraintLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT)
            layoutParams.startToEnd = R.id.back_icon
            layoutParams.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID
            layoutParams.matchConstraintDefaultWidth = ConstraintLayout.LayoutParams.MATCH_CONSTRAINT_SPREAD
            user_input.layoutParams = layoutParams

            // Have the correct views showing
            SearchHelper.addView(back_icon)
            SearchHelper.removeView(search_icon)
            SearchHelper.removeView(gps_button)
            SearchHelper.removeView(divider_line)
            SearchHelper.removeView(current_location)

            // Set the text to the last query and highlight it
            user_input.setText(addressSearchText)
            user_input.selectAll()
        }
    }
}