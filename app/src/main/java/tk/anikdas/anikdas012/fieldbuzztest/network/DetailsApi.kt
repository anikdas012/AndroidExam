package tk.anikdas.anikdas012.fieldbuzztest.network

import io.reactivex.Flowable
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST
import tk.anikdas.anikdas012.fieldbuzztest.models.User
import tk.anikdas.anikdas012.fieldbuzztest.models.UserAuthenticate
import tk.anikdas.anikdas012.fieldbuzztest.models.UserDetails
import tk.anikdas.anikdas012.fieldbuzztest.models.UserDetailsResponse

/**
 * Created by "Anik Das" on 20-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

interface DetailsApi {

    @POST("v0/recruiting-entities/")
    fun uploadDetails(@Header("Authorization") auth: String, @Body userDetails: UserDetails): Flowable<UserDetailsResponse>
}