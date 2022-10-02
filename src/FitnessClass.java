public enum FitnessClass{
    PILATES("Jennifer","9:30"),
    Spinning("Denise","14:00"),
    Cardio("Kim","14:00");
    String instructor;
    String Time;
    FitnessClass [] mList;
    FitnessClass(String I, String T) {
        instructor = I;
        Time = T;


    }

    public int CheckIn(Member A){
        Date Today = new Date();
        if(A.find(A)){
            System.out.println("I think");
        }
        //CHECK IF EXPIRED, MEMBER EXISTS, DOB VALID, FITNESS CLASS EXISTS, NO TIME CONFLICT
        //Check if the member exists
        System.out.println("Exists");

       return 0;
        
 
    }

    
}
