package com.joaoferreira.techchallenge.allapps.presentation.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.joaoferreira.techchallenge.allapps.data.AppsRepository
import com.joaoferreira.techchallenge.allapps.domain.AppDetails
import com.joaoferreira.techchallenge.common.TAG
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for handle the list of apps
 */
@HiltViewModel
class AppsViewModel @Inject constructor(
    private val repository: AppsRepository
) : ViewModel() {
    private val _listOfApps = MutableStateFlow<List<AppDetails>>(emptyList())
    val listOfApps: StateFlow<List<AppDetails>> = _listOfApps.asStateFlow()

    init {
        observeApps()
    }

    private fun observeApps() {
        viewModelScope.launch {
            repository.getListApps().collect { apps ->
                Log.d(TAG, "List of apps updated: $apps")
                _listOfApps.value = apps
            }
        }
    }
}
