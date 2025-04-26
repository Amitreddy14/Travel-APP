package com.example.singlestep.ui.summary

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.singlestep.R
import com.example.singlestep.databinding.FragmentSummaryBinding
import com.example.singlestep.model.TripParameters
import com.example.singlestep.model.TripSummary
import com.example.singlestep.ui.common.adapters.FlightAdapter
import com.example.singlestep.ui.common.adapters.HotelAdapter
import com.example.singlestep.utils.Result
import com.example.singlestep.utils.getRemoveTripOnClickListener
import com.example.singlestep.utils.hideBottomNavigationBar
import com.example.singlestep.utils.loadBitmapFromFile
import com.example.singlestep.utils.saveBitmapToFile
import com.example.singlestep.utils.showBottomNavigationBar
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.FetchPhotoRequest
import com.google.android.libraries.places.api.net.FetchPhotoResponse

class SummaryFragment : Fragment() {

    private val viewModel: SummaryViewModel by viewModels()
    private lateinit var binding: FragmentSummaryBinding
    private lateinit var flightAdapter: FlightAdapter
    private lateinit var hotelAdapter: HotelAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentSummaryBinding.inflate(inflater, container, false)
        arguments?.let { bundle ->
            val args = SummaryFragmentArgs.fromBundle(bundle)
            val tripSummary = args.tripSummary
            val fromMyTrips = args.fromMyTrips
            setupObservers(tripSummary)
            setupViews(tripSummary, fromMyTrips)
        }
        return binding.root
    }

    private fun setupObservers(tripSummary: TripSummary) {
        viewModel.itineraryString.observe(viewLifecycleOwner) { result ->
            when (result) {
                Result.Loading -> onItineraryLoading()
                is Result.Failure -> onItineraryLoadingFailure(result, tripSummary)
                is Result.Success -> onItineraryLoadingSuccess(result.value, tripSummary)
            }
        }
    }