public class FitnessClass {
    public enum Time{
    PILATES("Jennifer","9:30"),
    Spinning("Denise","14:00"),
    Cardio("Kim","14:00");
    String instructor;
    String Time;
    Time(String I, String T) {
        instructor = I;
        Time = T;


    }
    }
    Member PILATES[];
    Member SPINNING[];
    Member CARDIO[];
    int size;
    public FitnessClass(){
        this.size=size;
    }

    public String checkIn(String Class, Member member){
        String checkInProgress="Not checked in";
        if(Class=="PILATES"|| Class == "Pilates"){

            PILATES[PILATES.length]=member;
            checkInProgress= "ADDED TO PILATES";
        }


        if(Class=="Spinning"|| Class=="SPINNING"){
            SPINNING[SPINNING.length]=member;
            checkInProgress="Added to spinning";
        }
        if(Class =="CARDIO"){
            CARDIO[CARDIO.length]=member;
            checkInProgress="Added to cardio";

        }
        else{
            checkInProgress="Invalid class";
        }
        return checkInProgress;
    }
    }

    
}
