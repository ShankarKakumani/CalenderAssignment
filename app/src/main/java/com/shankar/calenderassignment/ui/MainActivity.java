package com.shankar.calenderassignment.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.shankar.calenderassignment.R;
import com.shankar.calenderassignment.adapter.CardsAdapter;
import com.shankar.calenderassignment.databinding.ActivityMainBinding;
import com.shankar.calenderassignment.model.CalenderModel;
import com.shrikanthravi.collapsiblecalendarview.data.Day;
import com.shrikanthravi.collapsiblecalendarview.widget.CollapsibleCalendar;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mBinding;
    MainActivityViewModel mViewModel;
    CardsAdapter cardsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setLifecycleOwner(this);
        mViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mBinding.setViewmocdel(mViewModel);
        loadCalendar();
        observeLiveData();
        recyclerView();
    }

    private void recyclerView() {
        RecyclerView recyclerView = mBinding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        cardsAdapter = new CardsAdapter(mViewModel);
        recyclerView.setAdapter(cardsAdapter);
    }

    private void observeLiveData() {

        mViewModel.lecList.observe(this, new Observer<List<CalenderModel.Lec>>() {
            @Override
            public void onChanged(List<CalenderModel.Lec> lecList) {
                if(lecList!=null)
                {
                    cardsAdapter.notifyDataSetChanged();
                    mViewModel.setIsLoading(false);
                }
            }
        });
    }



    private void loadCalendar() {

        final CollapsibleCalendar collapsibleCalendar = mBinding.calendarView;
        collapsibleCalendar.setCalendarListener(new CollapsibleCalendar.CalendarListener() {
            @Override
            public void onDayChanged() {
                Log.i("TAG_DAY", "onDayChanged");

            }

            @Override
            public void onClickListener() {

            }

            @Override
            public void onDaySelect() {
                mViewModel.setIsLoading(true);
                Day day = collapsibleCalendar.getSelectedDay();
                assert day != null;
                Log.i("TAG_DAY", "Selected Day: " +  day.getDay() + "/" + (day.getMonth()+1) + "/" + day.getYear());
                String date = day.getDay() + "/" +day.getMonth() + "/" +day.getYear();
                mViewModel.getData(date);
            }

            @Override
            public void onItemClick(@NotNull View view) {

            }

            @Override
            public void onDataUpdate() {
                mViewModel.setIsLoading(true);
                Day day = collapsibleCalendar.getSelectedDay();
                assert day != null;
                Log.i("TAG_DAY", "onDataUpdate: " +   day.getDay() + "/" +day.getMonth() + "/" +day.getYear());
                String date = day.getDay() + "/" +day.getMonth() + "/" +day.getYear();
                mViewModel.getData(date);

            }

            @Override
            public void onMonthChange() {

            }

            @Override
            public void onWeekChange(int i) {

            }
        });
    }

}