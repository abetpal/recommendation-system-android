package ApiRelated

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {

    @GET("/quotes")
    fun getQuotes() : Response<QuotesList>

    @FormUrlEncoded
    @POST("/api/authaccount/registration")
    fun createUser(
        @Field("name") name:String,
//        @Field("last") last:String,
        @Field("email") email:String,
//        @Field("ph") ph:String,
        @Field("password") password:String
    ): Call<ResponseBody>

    @FormUrlEncoded
    @POST("/api/authaccount/login")
    fun login(
        @Field("email") email:String,
        @Field("password") password:Int
    ): Call<ResponseBody>
}