package com.company;
import java.util.StringTokenizer;
import java.util.Calendar;
public class Date implements Comparable<Date>{
    private int year=0;
    private int month=0;
    private int day=0;
    private boolean leap;
    //Create object with todays date.

    public Date(String D){
        String[] Values=D.split("/");

        int checkYear=Integer.parseInt(Values[2]);
        int checkMonth = Integer.parseInt(Values[1]);
        int checkDay=Integer.parseInt(Values[0]);
        if (checkYear>1900 && checkYear<2023){
            year=checkYear;
            if (year%4==0){
                if (year%100==0){
                    if (year%400==0){
                        leap=true;
                    }

                }
            }
            else
                leap=false;


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

    public boolean isLeap() {
    return leap;



    }

    public void setLeap(boolean leap) {
        this.leap = leap;
    }

    @Override
    public int compareTo(Date date) {
        return 0;
    }
    public boolean isValid(Date date){
        int TempDay=date.getDay();
        int TempYear=date.getYear();
        int TempMonth=date.getMonth();
        if (TempDay>0 && TempDay<32 && TempYear>0 && TempYear<2023 && TempMonth>0 && TempMonth<13){
            return true;
        }
        else{
            return false;
        }

    }

}

