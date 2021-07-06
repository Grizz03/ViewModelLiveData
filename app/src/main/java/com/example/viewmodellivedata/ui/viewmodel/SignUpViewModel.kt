package com.example.viewmodellivedata.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {

    var name = ""
        set(value) {
            field = value
            setButtonVisibility(!checkIfNameAndLastNameAreEmpty())
        }

    var lastName = ""
        set(value) {
            field = value
            setButtonVisibility(!checkIfNameAndLastNameAreEmpty())
        }

    var email = ""
        set(value) {
            field = value
            setButtonVisibility(!checkIfEmailFieldIsEmpty())
        }

    private var _nextButtonVisible = MutableLiveData(false)
    val nextButtonVisible: LiveData<Boolean> = _nextButtonVisible


    fun setButtonVisibility(isVisible: Boolean) {
        _nextButtonVisible.value = isVisible
    }


    private fun checkIfEmailFieldIsEmpty(): Boolean {
        return email.isNullOrEmpty()
    }

    private fun checkIfNameAndLastNameAreEmpty(): Boolean {
        return name.isNullOrEmpty() || lastName.isNullOrEmpty()
    }
}