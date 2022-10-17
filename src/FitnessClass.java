import java.util.ArrayList;

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
    private ArrayList<Member> guest = new ArrayList<>();
    private Location location;
    private classTimes classTimes;
    /**
     FitnessClass Constructor. Decalres an object of type FitnessClass.
     @param fitnessClassName name of the class
     @param instructorName name of instructor
     @param classTime time of class
     @param mbdb Database for keeping track of members
     @param fitnessClasses array for storing multiple fitness classes
     */
    public FitnessClass(MemberDatabase mbdb, String instructorName, String fitnessClassName, Time classTime, FitnessClass []  fitnessClasses){
        this.fitnessClassName=fitnessClassName;
        this.instructorName=instructorName;
        this.classTime = classTime;
        this.memberDb=mbdb;
        this.fitnessClasses=fitnessClasses;




    }
    public FitnessClass(MemberDatabase mbdb, String instructorName, String fitnessClassName, Time classTime, Location location){
        this.fitnessClassName=fitnessClassName;
        this.instructorName=instructorName;
        this.classTime = classTime;
        this.memberDb=mbdb;
        this.fitnessClasses=fitnessClasses;
        this.location=location;



    }
    //FitnessClass fitnessClass = new FitnessClass(infos[0], infos[1],
    //                            classTime, classLocation);
    public FitnessClass(String fitnessClassName, String instructorName, classTimes classTime, Location location) {
        this.fitnessClassName = fitnessClassName;
        this.instructorName = instructorName;
        this.classTimes = classTime;
        this.location = location;
    }


    /**
     This checks to see if the member is registered into the class
     @param member the name of the member that is being checked for registration.
     @return true if member is attending, false otherwise.
     */
    public Location getLocation() {
        return location;
    }
    public void setLocation(Location location){
        this.location=location;

    }
    public boolean isSignedUp(Member member) {
        return attending.contains(member) != notFoundResult;
    }
    public void addGuest(Member member){
        guest.add(member);
    }
    //drop guest will be useful in multiple instances , if the passed member is a instance of family set the guest pass to 1 after dropping.
    public void dropGuest(Member member){
        guest.remove(member);
        System.out.println("Member: "+ member.getFname()+ " "+member.getLname() + " has been checked out");

        if(member instanceof Family){
            ((Family) member).setNumOfGuestPass(1);




        }
    }
    public String getInstructorName(){
        return instructorName;
    }

    /**
     @return a list of who is attending classes.
     */
    public MemberDatabase getClassRoster(){
        return attending;
    }
    //Return Instructor Name

    /**
     This method gets the name of the fitness class.
     @return the name of the fitness class.
     */
    public String getFitnessName(){
        return fitnessClassName;
    }

    /**
     Get method for class time.
     @return Time class time.
     */
    public Time getClassTime() {
        return classTime;
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
    public boolean checkExpiration(Member member) {
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
            if (fitnessClasses[i].getClassRoster().contains(id) != notFoundResult) {
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
    public void checkIn(Member member, MemberDatabase memberDb, String className, FitnessClass Fitness) {


        if (member.getDob().isAdult()) {
            if (!isSignedUp(member)) {
                if (!checkExpiration(member)) {
                    if (!isTimeConflict(className, fitnessClasses, member)) {
                        if (member instanceof Family) {
                            System.out.println(member.getFname() + " " + member.getLname() + " checked in " + className);
                            attending.add(member);
                        } else {
                            if (member.getLocation().compareLocations(Fitness.getLocation()) == "Equal") {
                                attending.add(member);
                                System.out.println(member.getFname() + " " + member.getLname() + " checked in " + attending.toString());

                                attending.printSchedule();
                            } else {
                                System.out.println(className + " time conflict -- " + member.getFname() + " " + member.getLname() + " has already checked in " + className);

                            }

                        }
                    } else {
                        System.out.println(member.getFname() + " " + member.getLname() + " has already checked in " + className);

                    }
                } else {
                    System.out.println(member.getFname() + " " + member.getLname() + " " + member.getDob().toString() + " membership has expired.");

                }


            }
        }
    }
    @Override
    public String toString() {
        return fitnessClassName.toUpperCase() + " - " + instructorName.toUpperCase()  +
                ", " + location;
    }


}