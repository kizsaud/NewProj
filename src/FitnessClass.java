package ProjectOne;


public class FitnessClass{


    private String fitnessClassName, instructorName;
    private Time classTime;
    final int notFoundResult=-1;
    private final MemberDatabase attending = new MemberDatabase();
    private MemberDatabase memberDb;
    private FitnessClass[] fitnessClasses;
    public FitnessClass(String fitnessClassName, String instructorName, Time classTime, MemberDatabase mbdb, FitnessClass []  fitnessClasses){
        this.fitnessClassName=fitnessClassName;
        this.instructorName=instructorName;
        this.classTime = classTime;
        this.memberDb=mbdb;
        this.fitnessClasses=fitnessClasses;


    }
    public boolean isRegistered(Member member) {
        return attending.contains(member) != notFoundResult;
    }

    public MemberDatabase getAttendingList(){
        return attending;
    }
    //Return Instructor Name
    public String getInstructor() {
        return instructorName;
    }
    //Set the instuctor
    public void setInstructor(String instructorName) {
        this.instructorName = instructorName;
    }
    public String getFitnessName(){
        return fitnessClassName;
    }
    public void setFitnessClassName(String fitnessClassName) {
        this.fitnessClassName = fitnessClassName;
    }


    public Time getClassTime() {
        return classTime;
    }
    public void setTime(Time classTime) {
        this.classTime = classTime;
    }
    public void printSchedule() {

        System.out.println(fitnessClassName + " - - - -" + instructorName + " " + classTime.getDateTime());
        if (attending.getSizeOfDB() != 0) {
            System.out.println("\t ** participants **");
        }
        attending.printSchedule();
    }

    public void dropClass(Member member, MemberDatabase memberDb) {
            if (attending.contains(member) != notFoundResult) {
                attending.remove(member);
                System.out.println(member.getFname()  + " dropped " + fitnessClassName);
            } else {
                System.out.println(member.getFname()+ " is not a participant in " + fitnessClassName);
            }
        }




    public boolean isExpired(Member member) {
        return member.getExpire().compareTo(new Date()) < 0;
    }

    private boolean isTimeConflict(String cN, FitnessClass[] fitnessClasses, Member id) {
        int Length= fitnessClasses.length;
        String[] times = new String[Length];
        String time = " ";
        for (int i = 0; i < Length; i++) {
            if ((fitnessClasses[i].getFitnessName()).equalsIgnoreCase(cN)) {
                time = fitnessClasses[i].getClassTime().getDateTime();
            }
        }
        for (int i = 0; i <Length; i++) {
            if ((fitnessClasses[i].getFitnessName()).equalsIgnoreCase(cN)) {
                continue;
            }
            if (fitnessClasses[i].getAttendingList().contains(id) != notFoundResult) {
                if (time.equalsIgnoreCase(fitnessClasses[i].getClassTime().getDateTime())) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean isClassExist(String className) {

        for (int i = 0; i < fitnessClasses.length; i++) {
            if (className.equalsIgnoreCase(fitnessClasses[i].getFitnessName())) {
                return true;
            }
        }
        return false;
    }

    public void checkIn(Member member, String className, FitnessClass[] fitnessClasses, MemberDatabase memberDb) {
        if(member.getDob().isAdult()){
            if(!isRegistered(member)){
                if(!isExpired(member)){
                    if (!isTimeConflict(className, fitnessClasses, member)) {
                        System.out.println(member.getFname() + " " + member.getLname() + " checked in " + className);
                        attending.add(member);
                    }else{
                        System.out.println(className + " time conflict -- " +member.getFname() + " " + member.getLname() + " has already checked in " + className);

                    }

                }
            }else{
                System.out.println(member.getFname() + " " + member.getLname() + " has already checked in " + className);

            }
        }else {
            System.out.println(member.getFname() + " " + member.getLname() + " " + member.getDob().toString() + " membership has expired.");

        }


    }


}
