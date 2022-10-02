import java.util.StringTokenizer;
import java.util.Calendar;
public class Date implements Comparable<Date>{
    private int year=0;
    private int month=0;
    private int day=0;
    //Create object with todays date.

    public Date(String D){
        String[] Values=D.split("/");
        boolean leap=false;
        int checkYear=Integer.parseInt(Values[2]);
        int checkMonth = Integer.parseInt(Values[0]);
        int checkDay=Integer.parseInt(Values[1]);
        year=checkYear;
        month=checkMonth;
        day=checkDay;
        System.out.println(year);
        }



    


    public Date(){

        Calendar cal = Calendar.getInstance();
        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH)+1;
        day = cal.get(Calendar.DAY_OF_MONTH);




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
        //This denotes the year you created, date.year denotes the current date
        int FirstYear= this.year;
        int SecondYear=date.year;
        int Winner=0;
        int SecondDayBigger=1;
        int FirstMonth=0;
        int SecondMont=0;
        int diff = date.year-this.year;
        if (FirstYear>SecondYear){
            Winner= 1;
        }

        if(FirstYear<SecondYear){
            Winner= -1;
        }
        if(FirstYear==SecondYear){
            FirstMonth=this.month;
            SecondMont=date.month;

            if(FirstMonth>SecondMont){
                Winner= 1;
            }
            if(FirstMonth<SecondMont){
                Winner= -1;
            }
            if(FirstMonth==SecondMont){
                int FirstDay=this.day;
                int SecondDay=date.day;


                if(FirstDay>SecondDay){
                    Winner= 1;
                }
                if(FirstDay>SecondDay){
                    Winner= -1;
                }
                if(SecondDay==FirstDay){
                    Winner= 0;
                }
            }
        }
        return Winner;
    }
    public boolean isLeap(){
        if (year % 4 == 0) {

            // if the year is century
            if (year % 100 == 0) {

                // if year is divided by 400
                // then it is a leap year
                if (year % 400 == 0)
                    return true;
                else
                    return false;
            }

            // if the year is not century
            else
                return true;
        }

        else
            return false;
    }

public boolean isLeap(int year){
        
        if (year % 4 == 0) {

            // if the year is century
            if (year % 100 == 0) {

                // if year is divided by 400
                // then it is a leap year
                if (year % 400 == 0)
                    return true;
                else
                    return false;
            }

            // if the year is not century
            else
                return true;
        }

        else
            return false;
    }
    public boolean isAdult(Date DOB){
        boolean isAdult = false;
        Date A = new Date();
        int Minyear = A.getYear()-18;
        int month = A.getMonth();
        int day = A.getDay();
        int day2=DOB.getDay();
        if(DOB.getYear()<=Minyear){
            if(month==DOB.getMonth() || DOB.getMonth()<month){
                if(day2<=day){
                    isAdult=true;
                }


            }
        }


            else {
                isAdult=false;
            }

            return isAdult;
        }
    public boolean isAdult(String Date){
        String[] Values=Date.split("/");
        int checkYear=Integer.parseInt(Values[2]);
        int checkMonth = Integer.parseInt(Values[0]);
        int checkDay=Integer.parseInt(Values[1]);
        boolean isAdult = false;
        Date A = new Date();
        int Minyear = A.getYear()-18;
        int month = A.getMonth();
        int day = A.getDay();
        int day2=checkDay;
        if (checkYear<Minyear){
            

            isAdult=true;
        }
        if(checkYear==Minyear){


            if(month==checkMonth){
                if(checkDay<=day){



                    isAdult=true;
                }
            }
        if(checkMonth<month){

                isAdult=true;
                
            }
            
            }
        

        
        else{
            isAdult=false;
        }

return isAdult;
            }
        
     


    

    public boolean isValid(){

        System.out.println(this.month);

        if ((month == 4 || month == 6 || month == 9 || month == 11) && day <= 30){
            return true;
        }
        // For months with 31 days.
        if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day <= 31){
            return true;
        }
        // For February.
        if(month == 2)
        {    

            
            if(day <= 28){
                return true;
            }
            if(day == 29){
                if(isLeap(year))
                    return true;
                }
            }
            return false;

            
        }
        
    public boolean isValid(int month,int day , int year){

        if ((month == 4 || month == 6 || month == 9 || month == 11) && day <= 30){
            return true;
        }
        // For months with 31 days.
        if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day <= 31){
            return true;
        }
        // For February.
        if(month == 2)
        {
            if(day <= 28){
                return true;
            }
            if(day == 29){
                if(isLeap(year))
                    return true;
                }
            }
            return false;

            
        }

    }
 
 
    

