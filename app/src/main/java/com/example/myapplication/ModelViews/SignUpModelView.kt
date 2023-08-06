package com.example.myapplication.ModelViews
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.APIResponce.SignUpRes
import com.example.myapplication.Global.getError
import com.example.myapplication.Report.SignUpAuthReport
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


class SignUpModelView : ViewModel() {

    private val _singLiveData = MutableLiveData<SignUpRes>()
    val signLiveData: LiveData<SignUpRes> = _singLiveData

    private val _signErrorLiveData = MutableLiveData<String>()
    val signErrorLiveData: LiveData<String> = _signErrorLiveData


    fun signUp(email: String, password: String,name:String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val res = SignUpAuthReport().signup(email, password,name)
                if (res.isSuccessful)
                    _singLiveData.postValue(res.body())
                else
                    _signErrorLiveData.postValue(res.errorBody()?.getError().toString())
            } catch (e: IOException) {
                e.printStackTrace()
                _signErrorLiveData.postValue(e.message.toString())
            } catch (e: HttpException) {
                e.printStackTrace()
                _signErrorLiveData.postValue(e.response()?.errorBody()?.getError().toString())
            } catch (e: Exception) {
                e.printStackTrace()
                _signErrorLiveData.postValue(e.message.toString())
            }
        }
    }

}