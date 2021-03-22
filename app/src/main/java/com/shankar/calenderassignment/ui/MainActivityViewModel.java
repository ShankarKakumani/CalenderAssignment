package com.shankar.calenderassignment.ui;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.shankar.calenderassignment.model.CalenderModel;
import com.shankar.calenderassignment.reterofit.RetrofitBuilder;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainActivityViewModel extends AndroidViewModel {

    public MutableLiveData<List<CalenderModel.Lec>> lecList;
    public MutableLiveData<Boolean> isLoading;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        lecList = new MutableLiveData<>(new ArrayList<>());
        isLoading = new MutableLiveData<>(true);
    }

    public void getData(String date)
    {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("year", "");
        headers.put("class", "");
        headers.put("section", "A");
        headers.put("semester", "3");
        headers.put("stream", "str003");
        headers.put("request_date", date);
        headers.put("api_key", "da7b0a5b6396da422ef093ce1c59fc0ee8971406b480f02e2d64cf39f42b896e");
        headers.put("school_id", "SCH10100");

        RetrofitBuilder.getInstance().getMyCalenderApi().loadCalender(headers).enqueue(new Callback<CalenderModel>() {
            @Override
            public void onResponse(@NotNull Call<CalenderModel> call, @NotNull retrofit2.Response<CalenderModel> response) {
                Log.i("TAG_1", "onResponse " +response);

                if (response.body() != null) {

                    Log.i("TAG_1", "onResponse " + response.body().getDay());
                    switch (response.body().getDay())
                    {
                        case "MONDAY":
                            setLecList(response.body().getWeekdays().get(0).getLec());
                            break;

                        case "TUESDAY":
                            setLecList(response.body().getWeekdays().get(1).getLec());
                            break;

                        case "WEDNESDAY":
                            setLecList(response.body().getWeekdays().get(2).getLec());
                            break;

                        case "THURSDAY":
                            setLecList(response.body().getWeekdays().get(3).getLec());
                            break;

                        case "FRIDAY":
                            setLecList(response.body().getWeekdays().get(4).getLec());
                            break;

                        case "SATURDAY":
                            setLecList(response.body().getWeekdays().get(5).getLec());
                            break;

                        case "SUNDAY":
                            setLecList(response.body().getWeekdays().get(6).getLec());
                            break;

                    }


                }

            }

            @Override
            public void onFailure(@NotNull Call<CalenderModel> call, @NotNull Throwable t) {
                Log.i("TAG_1", "onFailure " +t.getMessage());
                setIsLoading(false);

            }
        });
    }

    public MutableLiveData<List<CalenderModel.Lec>> getLecList() {
        return lecList;
    }

    public void setLecList(List<CalenderModel.Lec> lecList) {
        this.lecList.setValue(lecList);
    }

    public MutableLiveData<Boolean> getIsLoading() {
        return isLoading;
    }

    public void setIsLoading(Boolean isLoading) {
        this.isLoading.setValue(isLoading);
    }
}
