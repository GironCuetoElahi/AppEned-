package com.example.elahi.aplicacionened.data.remote;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://192.168.2.224:3000/";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
