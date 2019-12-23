package com.chrisjanusa.randomizer.events

import androidx.fragment.app.Fragment
import com.chrisjanusa.randomizer.filter_fragments.OverlayFragmentManager

class OpenFilterEvent (private val newFragment: Fragment) : BaseEvent {
    override fun handleEvent(fragment: Fragment) {
        (fragment.activity as OverlayFragmentManager).onFilterSelected(newFragment)
    }
}