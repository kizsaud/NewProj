/**
 This is the Fitness Class for all the fitness classes to check in or drop.
 This class is mainly for tracking which members have been added to the current class choosing from Pilates, Spinning and Cardio.
 This class accesses the MemberDatabase class to see if they are registered into any class and if so which class.
 This class also has to functionality of printing schedules of classes.
 @author Abhijeet Singh, Khizar Saud
 */
public class FitnessClass {
    private String fitnessClassName, instructorName;
    private Time classTime;
    final int notFoundResult=-1;
    private final MemberDatabase attending = new MemberDatabase();
    private MemberDatabase memberDb;
    private FitnessClass[] fitnessClasses;

    /**
     FitnessClass Constructor. Decalres an object of type FitnessClass.
     @param fitnessClassName name of the class
     @param instructorName name of instructor
     @param classTime time of class
     @param mbdb Database for keeping track of members
     @param fitnessClasses array for storing multiple fitness classes
     */
    public FitnessClass(String fitnessClassName, String instructorName, Time classTime, MemberDatabase mbdb, FitnessClass []  fitnessClasses){
        this.fitnessClassName=fitnessClassName;
        this.instructorName=instructorName;
        this.classTime = classTime;
        this.memberDb=mbdb;
        this.fitnessClasses=fitnessClasses;


    }
    /**
     This checks to see if the member is registered into the class
     @param member the name of the member that is being checked for registration.
     @return true if member is attending, false otherwise.
     */
    public boolean isRegistered(Member member) {
        return attending.contains(member) != notFoundResult;
    }


    /**
     @return a list of who is attending classes.
     */
    public MemberDatabase getAttendingList(){
        return attending;
    }
    //Return Instructor Name

    /**
     @return return name of the instructor for classes
     */
    public String getInstructor() {
        return instructorName;
    }
    //Set the instuctor

    /**
     This method sets instructors with the instructor name given.
     @param instructorName The name of the instructor to set.
     */
    public void setInstructor(String instructorName) {
        this.instructorName = instructorName;
    }
    /**
     This method gets the name of the fitness class.
     @return the name of the fitness class.
     */
    public String getFitnessName(){
        return fitnessClassName;
    }

    /**
     This method sets the fitness class name.
     @param fitnessClassName the name of the fitnessclass
     */
    public void setFitnessClassName(String fitnessClassName) {
        this.fitnessClassName = fitnessClassName;
    }


    /**
     Get method for class time.
     @return Time class time.
     */
    public Time getClassTime() {
        return classTime;
    }
    /**
     Set method for the the time of the class
     @param classTime the class time..
     */
    public void setTime(Time classTime) {
        this.classTime = classTime;
    }

    /**
     This method is for printing the schedule of the fitness classes
     */
    public void printSchedule() {

        System.out.println(fitnessClassName + " - - - -" + instructorName + " " + classTime.getDateTime());
        if (attending.getSizeOfDB() != 0) {
            System.out.println("\t ** participants **");
        }
        attending.printSchedule();
    }

    /**
     This class is for a member to drop a class that they were enrolled in, given the database the member is a part of.
     @param memberDb The memeber that needs to be dropped from the class
     @param memberDb The database that the member is a part of
     */
    public void dropClass(Member member, MemberDatabase memberDb) {
        if (attending.contains(member) != notFoundResult) {
            attending.remove(member);
            System.out.println(member.getFname()  + " dropped " + fitnessClassName);
        } else {
            System.out.println(member.getFname()+ " is not a participant in " + fitnessClassName);
        }
    }




    /**
     Returns if the member's membership is already expired.
     @param member the member who's expiration is being checked.
     @return true if the membership date is at or exceeds todays date, false otherwise.
     */
    public boolean isExpired(Member member) {
        return member.getExpire().compareTo(new Date()) < 0;
    }

    /**
     Returns if there is a time conflict with another class.
     @param cN cN is the class name.
     @param fitnessClasses array of the fitness classes.
     @param id member for whichever member is being passed for checking if there is a timeConflict.
     @return true if there is a time conflict, flase if there is no conflict with time for the memeber.
     */
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


    /**
     This class is a check to see if the class is existing and handle a class that doesn't exist.
     @param className name of the class passed.
     @return true if the class exists in the database, false otherwise
     */
    private boolean isClassExist(String className) {

        for (int i = 0; i < fitnessClasses.length; i++) {
            if (className.equalsIgnoreCase(fitnessClasses[i].getFitnessName())) {
                return true;
            }
        }
        return false;
    }

    /**
     This class is for checking a member into a class if they haven't checked in already.
     This method takes care of if the member is enrolled already.
     This method also takes care of if the member exists.
     This method also takes care of if the memeber's membership has expired or not.
     If they pass the conditions they will be checked into the class
     @param member the memeber that needs to be checked in
     @param className The name of the class member is checking into.
     @param fitnessClasses the array of fitness classes to check into.
     @param memberDb For checking if the member is in the database.
     */
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
