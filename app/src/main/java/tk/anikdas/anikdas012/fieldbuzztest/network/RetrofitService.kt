package tk.anikdas.anikdas012.fieldbuzztest.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by "Anik Das" on 20-Dec-2020
 * Developer email: "anikdas012@gmail.com"
 */

class RetrofitService {

    companion object {
        private var retrofit: Retrofit? = null

        private fun getRetrofitInstance() : Retrofit {
            if (retrofit == null) {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY

                val okHttpClient = OkHttpClient.Builder()
                    .addInterceptor(logging)

                retrofit = Retrofit.Builder()
                    .baseUrl("https://recruitment.fisdev.com/api/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient.build())
                    .build()
            }
            return retrofit!!
        }
    }
}