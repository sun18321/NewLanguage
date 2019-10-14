package com.sun.newlanguage.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BaseModel : ViewModel(){
    private fun launchOnUi(block: suspend CoroutineScope.() -> Unit) {
        viewModelScope.launch {
            block()
        }
    }

    suspend fun <T> launchOnIo(block: suspend CoroutineScope.() -> T) {
        withContext(Dispatchers.IO){
            block
        }
    }
}