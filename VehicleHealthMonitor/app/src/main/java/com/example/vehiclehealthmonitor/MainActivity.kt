package com.example.vehiclehealthmonitor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.vehiclehealthmonitor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: VehicleViewModel by lazy {
        ViewModelProvider(this)[VehicleViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        binding.reportIssueButton.setOnClickListener {
            viewModel.reportIssue(IssueReport("issue reported"))
        }

        binding.requestMaintenanceButton.setOnClickListener {
            viewModel.fetchVehicleStatus()
        }
    }
}



