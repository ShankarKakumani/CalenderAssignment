package com.shankar.calenderassignment.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CalenderModel {

    @SerializedName("clas")
    @Expose
    private Integer clas;
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("section")
    @Expose
    private String section;
    @SerializedName("semester")
    @Expose
    private String semester;
    @SerializedName("stream_id")
    @Expose
    private String streamId;
    @SerializedName("uptimetable")
    @Expose
    private List<Object> uptimetable = null;
    @SerializedName("weekdays")
    @Expose
    private List<Weekday> weekdays = null;
    @SerializedName("year")
    @Expose
    private String year;

    public Integer getClas() {
        return clas;
    }

    public void setClas(Integer clas) {
        this.clas = clas;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getStreamId() {
        return streamId;
    }

    public void setStreamId(String streamId) {
        this.streamId = streamId;
    }

    public List<Object> getUptimetable() {
        return uptimetable;
    }

    public void setUptimetable(List<Object> uptimetable) {
        this.uptimetable = uptimetable;
    }

    public List<Weekday> getWeekdays() {
        return weekdays;
    }

    public void setWeekdays(List<Weekday> weekdays) {
        this.weekdays = weekdays;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public class Weekday {

        @SerializedName("day")
        @Expose
        private String day;
        @SerializedName("lec")
        @Expose
        private List<Lec> lec = null;

        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public List<Lec> getLec() {
            return lec;
        }

        public void setLec(List<Lec> lec) {
            this.lec = lec;
        }

    }

    public class Lec {

        @SerializedName("duration")
        @Expose
        private String duration;
        @SerializedName("period_id")
        @Expose
        private Integer periodId;
        @SerializedName("period_type")
        @Expose
        private String periodType;
        @SerializedName("subject_code")
        @Expose
        private String subjectCode;
        @SerializedName("subject_name")
        @Expose
        private String subjectName;
        @SerializedName("subject_type")
        @Expose
        private String subjectType;
        @SerializedName("teacher_id")
        @Expose
        private String teacherId;
        @SerializedName("timing")
        @Expose
        private String timing;
        @SerializedName("teacher_name")
        @Expose
        private String teacherName;

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public Integer getPeriodId() {
            return periodId;
        }

        public void setPeriodId(Integer periodId) {
            this.periodId = periodId;
        }

        public String getPeriodType() {
            return periodType;
        }

        public void setPeriodType(String periodType) {
            this.periodType = periodType;
        }

        public String getSubjectCode() {
            return subjectCode;
        }

        public void setSubjectCode(String subjectCode) {
            this.subjectCode = subjectCode;
        }

        public String getSubjectName() {
            return subjectName;
        }

        public void setSubjectName(String subjectName) {
            this.subjectName = subjectName;
        }

        public String getSubjectType() {
            return subjectType;
        }

        public void setSubjectType(String subjectType) {
            this.subjectType = subjectType;
        }

        public String getTeacherId() {
            return teacherId;
        }

        public void setTeacherId(String teacherId) {
            this.teacherId = teacherId;
        }

        public String getTiming() {
            return timing;
        }

        public void setTiming(String timing) {
            this.timing = timing;
        }

        public String getTeacherName() {
            return teacherName;
        }

        public void setTeacherName(String teacherName) {
            this.teacherName = teacherName;
        }

    }

}