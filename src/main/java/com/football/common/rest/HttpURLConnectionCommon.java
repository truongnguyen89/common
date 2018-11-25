package com.football.common.rest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 05-Nov-18
 * Time: 4:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class HttpURLConnectionCommon {
    public static HttpURLConnection clientHttpURLConnection(String url, int timeoutConnection, int timeout) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setConnectTimeout(timeoutConnection);
        con.setReadTimeout(timeout);
        con.setRequestProperty("Accept", "application/json");
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        return con;
    }
}
