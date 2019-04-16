package com.bielma.arbosch.WebService;

import java.io.IOException;

import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthInterceptor implements Interceptor {

    private String credenciales;

    public AuthInterceptor(String user, String pass){
        this.credenciales = Credentials.basic(user, pass);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request authenticatedRequest = request.newBuilder().header("Authorization", credenciales).build();
        return chain.proceed(authenticatedRequest);
    }
}
