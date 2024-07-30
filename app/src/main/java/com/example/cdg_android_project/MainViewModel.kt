package com.example.cdg_android_project

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cdg_android_project.Match.Companion.toMatch
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private var _matchesLiveData: MutableLiveData<List<Match>> = MutableLiveData()
    val matchesLiveData: LiveData<List<Match>> = _matchesLiveData

    init {
        viewModelScope.launch {
            MatchesDatabase.getDatabase()?.matchesDao()?.getAllMatches()?.collect {list ->
                _matchesLiveData.value = list.map { it.toMatch() }
            }
        }
    }
}
