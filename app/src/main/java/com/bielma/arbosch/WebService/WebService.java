package com.bielma.arbosch.WebService;

import android.os.AsyncTask;

import java.net.URL;

import retrofit2.Retrofit;

public class WebService {
    static final String urlPost = "https://esb.boschenlinea.com/api/login";
    static final String urlGet  =  "https://esb.boschenlinea.com/api/productview/{partNumber}";
    static final String WCTrustedToken = "272032%2C1QkfiPo8oQ1iHA%2BV%2BxSoKTq3hcdjfM25%2BHca4weFev0%3D";
    static final String USER = "ZV^M4Y*Wb#%j9tpgZ%Rlvy2TjiyZ";
    static final String PASS = "%kpjbI4c3@jTu!U3QB$dKWKa5w9$1zd%R7lg@CvKTLaV%vV1Vi";
    static final String id = "thetonybl@gmail.com";  //Usuario para acceder a boschenlinea
    static final String pass = "pronatural";            //contraseña para acceder a boschenlinea
    static final String WCToken = "272032%2C%2FASh5yUfxNasr9B1AHWAz6yEsWpp56kQTib%2BfPBIyk7xMakepfllaad2Z"
            +"xXpneXyiSRVqaThevUUv3SoD8oZ4X4w05iZ5WpeAg33es6noOE0ktxEGklVUKBhZP7B62SeIWIpa8LxQ56qH0gi3ULcw" +
            "W4X1Ye8gfsWadn4FVk%2FEDw53iKTf%2BOa1QiMNwqp%2F%2BQ0Bab7w2wvl9IVhDj96daFlHEOQ7OTEEosIABAsYsJALsYHfU8WkPYP%2F4lK%2B4myLZl";

    public WebService(){

    }

    private void getDatos(){


    }

    private class GetDatos extends AsyncTask<Void,Void,Void>{
        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }

    }



}
