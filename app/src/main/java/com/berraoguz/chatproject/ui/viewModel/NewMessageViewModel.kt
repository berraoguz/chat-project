package com.berraoguz.chatproject.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berraoguz.chatproject.constants.Constants
import com.berraoguz.chatproject.data.model.User
import com.berraoguz.chatproject.data.repo.FirebaseRepoImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewMessageViewModel @Inject constructor(
    val repo: FirebaseRepoImp
) : ViewModel() {

    // live data
    private var _usersMutableLiveData: MutableLiveData<ArrayList<User>?> =
        MutableLiveData<ArrayList<User>?>()
    val userLiveData: LiveData<ArrayList<User>?> get() = _usersMutableLiveData

    val searchUsersLiveData: LiveData<ArrayList<User?>> = repo.searchUsersLiveData

    // methods
    fun getAllUser() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val users = repo.getAllUser()
                _usersMutableLiveData.postValue(users as ArrayList<User>)
            } catch (e: Exception) {
                Log.d(Constants.TAG, "getAllUsers: ${e.message}")
            }
        }
    }

    fun searchOnUsers(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                repo.searchOnUsers(name)
            } catch (e: Exception) {
                Log.d(Constants.TAG, "searchOnUsers: ${e.message}")
            }
        }
    }

}