package com.bielma.arbosch.WebService;

import com.bielma.arbosch.Modelos.Credenciales;
import com.bielma.arbosch.Modelos.Producto;
import com.bielma.arbosch.Modelos.Tokens;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

  /*  @Headers({"Authorization:BasicWlZeTTRZKldiIyVqOXRwZ1olUmx2eTJUaml5Wjola3BqYkk0YzNAalR1IVUzUUIkZEtXS2E1dzkkMXpkJVI3bGdAQ3ZLVExhViV2VjFWaQ==",
            "Content-Type: application/json"
    })*/

    @POST("login")
    Call<Tokens> getTokens(
            @Header("Authorization")String Authorization,
            @Header("Content-Type") String ContentType,
            @Body Credenciales body

    );

   @GET("productview/{partNumber}")
    Call<Producto> getProductos(@Path("partNumber") String partNumber,
                                @Header("Authorization")String Authorization,
                                @Header("WCTrustedToken") String WCTrustedToken,
                                @Header("WCToken")String WCToken,
                                @Header("Content-Type") String ContentType);

}
