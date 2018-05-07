package com.dnu.loi.smartrm.service;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://qlnh.somee.com";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
