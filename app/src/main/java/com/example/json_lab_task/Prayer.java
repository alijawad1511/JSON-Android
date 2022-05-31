package com.example.json_lab_task;

public class Prayer {
    String fajrTime,dhuhrTime, astTime,maghribTime,ishaTime;

    public Prayer(String fajrTime, String dhuhrTime, String astTime, String maghribTime, String ishaTime) {
        this.fajrTime = fajrTime;
        this.dhuhrTime = dhuhrTime;
        this.astTime = astTime;
        this.maghribTime = maghribTime;
        this.ishaTime = ishaTime;
    }

    public String getFajrTime() {
        return fajrTime;
    }

    public void setFajrTime(String fajrTime) {
        this.fajrTime = fajrTime;
    }

    public String getDhuhrTime() {
        return dhuhrTime;
    }

    public void setDhuhrTime(String dhuhrTime) {
        this.dhuhrTime = dhuhrTime;
    }

    public String getAstTime() {
        return astTime;
    }

    public void setAstTime(String astTime) {
        this.astTime = astTime;
    }

    public String getMaghribTime() {
        return maghribTime;
    }

    public void setMaghribTime(String maghribTime) {
        this.maghribTime = maghribTime;
    }

    public String getIshaTime() {
        return ishaTime;
    }

    public void setIshaTime(String ishaTime) {
        this.ishaTime = ishaTime;
    }
}
