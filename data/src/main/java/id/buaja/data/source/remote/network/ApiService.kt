package id.buaja.data.source.remote.network

import id.buaja.data.source.remote.response.HadithResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{name}")
    suspend fun getHadith(
        @Path("name") name: String
    ): List<HadithResponse>
}