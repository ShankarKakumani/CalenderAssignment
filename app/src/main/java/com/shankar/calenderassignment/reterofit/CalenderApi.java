package com.shankar.calenderassignment.reterofit;


import com.shankar.calenderassignment.model.CalenderModel;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;


public interface CalenderApi {

    String BASE_URL = "https://www.presencex.com/REVA/school/";

//    @Headers({
//            "Content-Type: application/json",
//            "year: ",
//            "class: ",
//            "section: A",
//            "semester: 3",
//            "stream: str003",
//            "request_date: 03/12/2020",
//            "api_key: da7b0a5b6396da422ef093ce1c59fc0ee8971406b480f02e2d64cf39f42b896e",
//            "school_id: SCH10100"})
    @GET("gettimetable")
    Call<CalenderModel> loadCalender(@HeaderMap Map<String, String> headers);

}
