package com.amalip.cocktailtestapp.application.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import com.amalip.cocktailtestapp.R
import com.amalip.cocktailtestapp.application.adapter.CocktailsAdapter
import com.amalip.cocktailtestapp.application.viewModels.MainViewModel
import com.amalip.cocktailtestapp.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val vm: MainViewModel by viewModel()
    private var binding: ActivityMainBinding? = null
    private val adapter: CocktailsAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
        setAdapter()
        setRC()
        setCocktailListObserver()
        setSearchViewListener()
        setFilterObserver()
    }

    private fun setBinding() {
        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding?.vm = vm
        binding?.lifecycleOwner = this
    }

    private fun setAdapter() {
        binding?.rcv?.adapter = adapter
    }

    private fun setRC() {
        binding?.rcv?.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
    }

    private fun setSearchViewListener() {
        binding?.srch?.setOnQueryTextListener(vm.queryTextListener)
    }

    private fun setCocktailListObserver() {
        vm.cocktails.observe(this, {
            adapter.submitList(it)
            Handler().postDelayed({
                adapter.notifyDataSetChanged()
            }, 50)
        })
    }

    private fun setFilterObserver() {
        vm.filter.observe(this, {
            vm.getCocktailsByFilter()
        })
    }

    private fun setFailureObserver() {
        vm.failure.observe(this, {
            if (it != null)
                Toast.makeText(this, it.msg, Toast.LENGTH_SHORT).show()
        })
    }
}