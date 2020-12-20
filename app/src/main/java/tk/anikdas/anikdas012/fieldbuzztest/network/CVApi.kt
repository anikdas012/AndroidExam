package tk.anikdas.anikdas012.fieldbuzztest.network

import io.reactivex.Flowable
import okhttp3.MultipartBody
import retrofit2.http.*
import tk.anikdas.anikdas012.fieldbuzztest.models.CVResponse

/**
 * Created by "Anik Das" on 20-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

interface CVApi {

    @Multipart
    @PUT("file-object/{FILE_TOKEN_ID}/")
    fun uploadCV(@Header("Authorization") auth: String, @Path("FILE_TOKEN_ID") id: Int,
                 @Part file: MultipartBody.Part): Flowable<CVResponse>
}