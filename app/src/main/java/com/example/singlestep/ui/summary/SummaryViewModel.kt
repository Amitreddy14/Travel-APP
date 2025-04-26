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

class SummaryViewModel(
    application: Application,
    savedStateHandle: SavedStateHandle,
) : AndroidViewModel(application) {

    private var coroutineExceptionHandler: CoroutineExceptionHandler

    private val assistant = Assistant()
    private var dao = AppDatabase.getDatabase(application.applicationContext).tripSummaryDao()

    private val tripSummary =
        savedStateHandle.getLiveData<TripSummary>("tripSummary").value!!

    private val _itineraryString: MutableLiveData<Result<String>> = MutableLiveData()
    val itineraryString: LiveData<Result<String>>
        get() = _itineraryString

    init {
        coroutineExceptionHandler = CoroutineExceptionHandler { _, exception ->
            _itineraryString.value = Result.Failure(exception)
        }
    }