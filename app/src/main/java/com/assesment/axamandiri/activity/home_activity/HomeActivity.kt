package com.assesment.axamandiri.activity.home_activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.assesment.axamandiri.R
import com.assesment.axamandiri.activity.view_model.DataViewModel
import com.assesment.axamandiri.databinding.HomeLayoutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    lateinit var binding: HomeLayoutBinding
    val vm: DataViewModel by viewModels()
    val adapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.home_layout, null, false)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        vm.loadData()
        binding.recycler.adapter = adapter
        vm.data.observe(this) {data->
            adapter.data.submitList(data)
        }
        binding.search.addTextChangedListener{
            val data = vm.filter(it.toString())
            adapter.data.submitList(data)
        }

    }
}