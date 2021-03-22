package com.shankar.calenderassignment.utils;

import android.widget.TextView;

import androidx.databinding.BindingAdapter;

public class DataBindingAdapterUtil {

    @BindingAdapter("subjectCode")
    public static void setSubjectCode(TextView textView, String subjectCode)
    {
        textView.setText("Subject code: "+subjectCode);
    }

    @BindingAdapter("subject")
    public static void setSubject(TextView textView, String subject)
    {
        textView.setText("Subject: "+subject);

    }

    @BindingAdapter("faculty")
    public static void setFaculty(TextView textView, String faculty)
    {
        textView.setText("Faculty: "+faculty);

    }

    @BindingAdapter("periodType")
    public static void setPeriodType(TextView textView, String periodType)
    {
        textView.setText("Period Type: "+periodType);

    }

    @BindingAdapter("subjectType")
    public static void setSubjectType(TextView textView, String subjectType)
    {
        textView.setText("Subject Type: "+subjectType);

    }


}
