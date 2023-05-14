package com.express.android.davidweatherapprebuild.utils

sealed class Resource<T> (

    val data: T? = null,
    val message: String? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    //class Error<T>(message: String) : Resource<T>(message = message)
    class Error<T>(val errMsg: String) : Resource<T>()
    class Loading<T> : Resource<T>()
    object NoAction : Resource<Nothing>()
}

sealed class State<T> {

    data class Success<T>(val data: T) : State<T>()
    data class Error(val errMsg: String) : State<Nothing>()
    object Loading : State<Nothing>()
    object NoAction : State<Nothing>()
}