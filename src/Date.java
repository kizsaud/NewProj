package com.company;
import java.util.StringTokenizer;
import java.util.Calendar;
public class Date implements Comparable<Date>{
    private int year=0;
    private int month=0;
    private int day=0;
    //Create object with todays date.

    public Date(String D){
        String[] Values=D.split("/");

        int checkYear=Integer.parseInt(Values[0]);
        int checkMonth = Integer.parseInt(Values[1]);
        int checkDay=Integer.parseInt(Values[2]);
        if (checkYear>1900 && checkYear<2023){
            year=checkYear;

        }
        if (checkMonth>0 && checkMonth<12){
            month=checkMonth;

        }
        if (checkDay>0 && checkDay<32){
            day=checkDay;

        }


   
    }
    public Date(){

        Calendar cal = Calendar.getInstance();
        year = Calendar.getInstance().get(Calendar.YEAR);
        month= Calendar.getInstance().get(Calendar.MONTH);
        day= Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
    
        return day;
    }

    @Override
    public int compareTo(Date date) {
        return 0;
    }
    public boolean isValid(Date date){
        return false;

    }

}

