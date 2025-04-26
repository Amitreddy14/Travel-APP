package com.example.singlestep.ui.summary

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.example.singlestep.data.Assistant
import com.example.singlestep.data.room.AppDatabase
import com.example.singlestep.model.RoomTripSummary
import com.example.singlestep.model.TripSummary
import com.example.singlestep.utils.Result
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch