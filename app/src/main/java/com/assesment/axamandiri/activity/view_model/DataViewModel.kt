package com.assesment.axamandiri.activity.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.assesment.axamandiri.api_service.use_case.DataUseCase
import com.assesment.axamandiri.common.entity.DataResponse
import com.assesment.axamandiri.common.entity.DataResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(
    application: Application,
    val useCase: DataUseCase
) : AndroidViewModel(application) {

    val data = MutableLiveData<ArrayList<DataResponseItem>>()
    val search = MutableLiveData<String>()

    fun loadData() {
        viewModelScope.launch {
            useCase.invoke().collect {
                data.postValue(it)
            }
        }
    }

    fun filter(q: String): List<DataResponseItem> {
        return data.value?.let {
            it.orEmpty().filter { data ->
                data.title.contains(q, true)
            }
        } ?: run {
            arrayListOf()
        }
    }

//    fun filter(data: ArrayList<DataResponseItem>, search: String): List<DataResponseItem> {
//        return data.orEmpty().filter {
//            it.title.contains(search, true)
//        }
//
//    }


}