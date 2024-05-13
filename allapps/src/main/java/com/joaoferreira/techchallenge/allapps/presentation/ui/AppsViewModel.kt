package com.joaoferreira.techchallenge.allapps.presentation.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.joaoferreira.techchallenge.allapps.data.AppsRepository
import com.joaoferreira.techchallenge.allapps.domain.AppData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AppsViewModel @Inject constructor(
    private val repository: AppsRepository
) : ViewModel() {
    private val _listOfApps = MutableStateFlow<List<AppData>>(emptyList())
    val listOfApps: StateFlow<List<AppData>> = _listOfApps.asStateFlow()

    init {
        fetchApps()
    }

    private fun fetchApps() {
        viewModelScope.launch {
            repository.getListApps().collect { apps ->
                _listOfApps.value = apps
            }
        }
    }
}