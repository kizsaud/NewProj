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
            if(checkYear>1900 && checkYear<=2023){
                year=checkYear;
            }
            
            if (checkMonth>0 && checkMonth<=12){
                month=checkMonth;

            }

            if (checkDay>0 && checkDay<=32){
                day=checkDay;

            }
            if (checkYear % 4 == 0) {
            
        // if the year is century
        if (checkYear % 100 == 0) {

            // if year is divided by 400
            // then it is a leap year
            if (checkYear % 400 == 0)
            leap = true;
            else
            leap = false;
        }
        
        // if the year is not century
        else
            leap = true;
        }
        
        else
        leap = false;
    
        

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
            Winner= 0;
        }
        
        if(FirstYear<SecondYear){
            Winner= 1;
        }
        if(FirstYear==SecondYear){
            FirstMonth=this.month;
            SecondMont=date.month;
            
            if(FirstMonth>SecondMont){
                Winner= 0;
            }
            if(FirstMonth<FirstMonth){
                Winner= 1;
            }
            if(FirstMonth==SecondMont){
                int FirstDay=this.day;
                int SecondDay=date.day;
            

                if(FirstDay>SecondDay){
                    Winner= 0;
                }
                if(SecondDay>FirstDay){
                    Winner= 1;
                }
                if(SecondDay==FirstDay){
                    Winner= -1;
                }
            }
        }
        return Winner;
        }




        public boolean isValid(){
            
            if ((day>0 && day<=32 )&&(year>0 && year<=2023) &&(month>0 && month<13)){
                return true;
            }
            else{
                return false;
            }

        }

    }

