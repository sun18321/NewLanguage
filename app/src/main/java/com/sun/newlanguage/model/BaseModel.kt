package com.sun.newlanguage.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

open class BaseModel : ViewModel(){
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

     suspend fun executeNet(tryBlock: suspend CoroutineScope.() -> Unit) {
        tryCatch(tryBlock,{},{},true)
    }


    private suspend fun tryCatch(
        tryBlock: suspend CoroutineScope.() -> Unit,
        catchBlock: suspend CoroutineScope.(Throwable) -> Unit,
        finallyBlock: suspend CoroutineScope.() -> Unit,
        handleCancelException: Boolean = false
    ) {
        coroutineScope{
            try {
                tryBlock()
            } catch (e: Throwable) {
                if (e !is CancellationException || handleCancelException) {
                    catchBlock(e)
                }
            }finally {
                finallyBlock()
            }
        }


    }
}