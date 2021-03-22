package com.shankar.calenderassignment.reterofit;

import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

    private static RetrofitBuilder instance = null;
    private final CalenderApi myCalenderApi;

    private RetrofitBuilder() {

        retrofit2.Retrofit retrofit = new retrofit2.Retrofit.Builder().baseUrl(CalenderApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myCalenderApi = retrofit.create(CalenderApi.class);

    }

    public static synchronized RetrofitBuilder getInstance() {

        if (instance == null) {
            instance = new RetrofitBuilder();
        }

        return instance;
    }

    public CalenderApi getMyCalenderApi() {

        return myCalenderApi;
    }
}

