package com.irwan.bsit.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.irwan.bsit.R
import com.irwan.bsit.databinding.ActivityMainBinding
import com.irwan.bsit.model.TransactionResponse
import com.irwan.bsit.presentation.adapter.BsitFragmentPagerAdapter
import com.irwan.bsit.presentation.adapter.TransactionAdapter
import com.irwan.bsit.presentation.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewPager(listOf())
        setUpTabLayout()
        observeViewModel()
        mainViewModel.getTransaction()
    }

    private fun setUpViewPager(bundle: List<Bundle>) {
        val viewPager = binding.vpContainer
        viewPager.adapter = BsitFragmentPagerAdapter(this, bundle)
    }

    private fun setUpTabLayout() {
        val tabLayout = binding.tabsFragment
        val viewPager = binding.vpContainer
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position) {
                0 -> tab.text = "Transaction"
                1 -> tab.text = "Contact"
                2 -> tab.text = "Profile"
            }
        }.attach()
    }

    private fun observeViewModel() {
        mainViewModel.transaction.observe(this) {
//            setDataForTransaction(it)
        }
        mainViewModel.errorMessage.observe(this) {
            Toast.makeText(applicationContext, it, Toast.LENGTH_LONG).show()
        }
        mainViewModel.showLoading.observe(this) { isShow ->
            if (isShow) showLoading() else hideLoading()
        }
    }

    private fun setDataForTransaction(data: List<TransactionResponse>) {
        val adapter = TransactionAdapter(data)
//        binding.rvListTransaction.adapter = adapter
    }

    private fun showLoading() {
        binding.cmpLoading.root.visibility = View.VISIBLE
//        binding.rvListTransaction.visibility = View.GONE
    }

    private fun hideLoading() {
        binding.cmpLoading.root.visibility = View.GONE
//        binding.rvListTransaction.visibility = View.VISIBLE
    }

}