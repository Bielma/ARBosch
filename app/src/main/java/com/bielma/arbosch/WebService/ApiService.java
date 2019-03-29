package com.bielma.arbosch.WebService;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @POST("login")
    Call<WebService> getTokens(
            @Query("logonId") String username,
            @Query("logonPassword") String password
    );

}
