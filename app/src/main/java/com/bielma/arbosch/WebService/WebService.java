package com.bielma.arbosch.WebService;

import android.util.Log;
import com.bielma.arbosch.Modelos.Credenciales;
import com.bielma.arbosch.Modelos.Producto;
import com.bielma.arbosch.Modelos.Tokens;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WebService {
    static final String API_BASE_URL = "https://esb.boschenlinea.com/api/";
    static final String USER = "ZV^M4Y*Wb#%j9tpgZ%Rlvy2TjiyZ";
    static final String PASS = "%kpjbI4c3@jTu!U3QB$dKWKa5w9$1zd%R7lg@CvKTLaV%vV1Vi";
    static final String id = "thetonybl@gmail.com";  //Usuario para acceder a boschenlinea
    static final String pass = "pronatural";            //contraseña para acceder a boschenlinea
    static final String Authorization = "Basic" +
            "WlZeTTRZKldiIyVqOXRwZ1olUmx2eTJUaml5Wjola3BqYkk0YzNAalR1IVUzUUIkZEtXS2E1dzkkMXp" +
            "kJVI3bGdAQ3ZLVExhViV2VjFWaQ==";
    static final String ContentType = "application/json";



    public void getTokens()
    {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new AuthInterceptor(USER, PASS))
                .build();
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        final ApiService login = retrofit.create(ApiService.class);
        Call<Tokens> call = login.getTokens(Authorization, ContentType, new Credenciales(id, pass));
        call.enqueue(new Callback<Tokens>() {
            @Override
            public void onResponse(Call<Tokens> call, Response<Tokens> response)
            {
                if(response.isSuccessful()){
                    //ApiService get = retro.create(ApiService.class);
                    Call<Producto> call2 = login.getProductos("F0132050AA",Authorization, response.body().getWCTrustedToken(), response.body().getWCToken(),ContentType);
                    call2.enqueue(new Callback<Producto>() {
                        @Override
                        public void onResponse(Call<Producto> call, Response<Producto> response) {
                            Log.d("Retro", "Respuesta: ");
                            Log.d("Retro",response.toString());
                            Log.d("Retro",response.body().toString());
                           if(response.isSuccessful()){
                               Log.d("Retro", "Respuesta: 20");
                               //Log.d("Retro",response.body().getUniqueID());
                               Log.d("Retro",response.body().toString());
                               Log.d("Retro",response.toString());
                           }
                        }
                        @Override
                        public void onFailure(Call<Producto> call, Throwable t) {
                            Log.d("Retro", "Error we:");
                            Log.d("Retro", t.getLocalizedMessage());
                            //Log.d("Retro", call.toString());


                        }
                    });
                }
            }
            @Override
            public void onFailure(Call<Tokens> call, Throwable t) {
                Log.d("Retro", t.getLocalizedMessage());
            }
        });

    }

       public void getPosts() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService getService = retrofit.create(ApiService.class);

    }
}
