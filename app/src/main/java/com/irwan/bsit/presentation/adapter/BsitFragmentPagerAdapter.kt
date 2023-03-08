package com.irwan.bsit.presentation.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.irwan.bsit.presentation.fragment.ContactFragment
import com.irwan.bsit.presentation.fragment.ProfileFragment
import com.irwan.bsit.presentation.fragment.TransactionFragment

class BsitFragmentPagerAdapter(
    fragment: FragmentActivity,
    private val bundle: List<Bundle>,
) : FragmentStateAdapter(
    fragment,
) {

    private val fragment = listOf(
        ::TransactionFragment,
        ::ContactFragment,
        ::ProfileFragment
    )

    override fun getItemCount() = fragment.size

    override fun createFragment(position: Int): Fragment {
        val fragmentName = fragment.getOrNull(position)
        val fragmentInstance = fragmentName?.invoke() ?: Fragment()

        val bundle = bundle.getOrNull(position)
        fragmentInstance.arguments = bundle

        return fragmentInstance
    }
}