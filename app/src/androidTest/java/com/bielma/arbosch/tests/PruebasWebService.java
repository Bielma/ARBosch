package com.bielma.arbosch.tests;

import com.bielma.arbosch.WebService.WebService;

import junit.framework.TestCase;

import org.junit.Test;

public class PruebasWebService extends TestCase {
    @Test
    public void validaLogin(){
        WebService webService = new WebService();
        webService.getTokens();
    }
    @Test
    public void validaInsercionProductos(){
        //assertThat
    }
}
