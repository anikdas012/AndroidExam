package tk.anikdas.anikdas012.fieldbuzztest.network

import io.reactivex.Flowable
import retrofit2.http.Body
import retrofit2.http.POST
import tk.anikdas.anikdas012.fieldbuzztest.models.User
import tk.anikdas.anikdas012.fieldbuzztest.models.UserAuthenticate

/**
 * Created by "Anik Das" on 20-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

interface LoginApi {

    @POST("login/")
    fun login(@Body userAuthenticate: UserAuthenticate): Flowable<User>
}