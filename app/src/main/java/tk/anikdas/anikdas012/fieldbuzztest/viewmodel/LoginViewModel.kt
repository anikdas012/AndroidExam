package tk.anikdas.anikdas012.fieldbuzztest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import io.reactivex.schedulers.Schedulers
import tk.anikdas.anikdas012.fieldbuzztest.models.User
import tk.anikdas.anikdas012.fieldbuzztest.models.UserAuthenticate
import tk.anikdas.anikdas012.fieldbuzztest.network.RetrofitService

/**
 * Created by "Anik Das" on 20-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

class LoginViewModel: ViewModel() {

    fun attemptLogin(username: String, password: String) : LiveData<String> {
        val userAuthenticate = UserAuthenticate(username, password)
        return LiveDataReactiveStreams.fromPublisher(
            RetrofitService.getLoginApi().login(userAuthenticate)
                .onErrorReturn { error ->
                    return@onErrorReturn User("Error", "Error")
                }
                .map { user ->
                    return@map user.token
                }
                .subscribeOn(Schedulers.io())
        )
    }
}