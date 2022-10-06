/**
 This is the Gym Manager which is where the program run function is.
 There are helper methods for adding a member to database, and reading commands.
 This class takes care of adding members, removing members, printing members, adding and dropping memeber from fitness
 class and displaying the fitness Schedule.
 @author Abhijeet Singh, Khizar Saud
 */

import java.util.Scanner;


public class GymManager {
    MemberDatabase db = new MemberDatabase();
    private final int finalIntClassSize=3;
    FitnessClass[] fitnessClasses = new FitnessClass[finalIntClassSize];
    int classes = 3;
    //FitnessClass[] fitnessClasses = new FitnessClass[classes];


    /**
     This is the main run class.
     This makes and stores all the fitness classes.
     This method also collects all the parts of a command and sends it out to an execute command class.
     */
    public void run() {
        fitnessClasses[0] = new FitnessClass(db,"Jennifer","Pilates", Time.Pilates, fitnessClasses);
        fitnessClasses[1] = new FitnessClass(db,"Denise","Spinning", Time.Spinning, fitnessClasses);
        fitnessClasses[2] = new FitnessClass(db,"Kim","Cardio", Time.Cardio, fitnessClasses);
        System.out.println("Gym Manager running...");
        Scanner scan = new Scanner(System.in);
        String command = "";
        String[] commands;
        String user = "";
        int ptr = 0;
        while (scan.hasNext()) {
            command = scan.nextLine();
            commands = command.split("\\s");
            executeCommands(commands[0], commands);
        }
    }

    /**
     Deletes the person with the given name from the list.
     Does nothing if name doesn't appear in the list.
     @param command This is the command to take care of the first letter command.
     @param commands This is to store the rest of the input if there is any, for inforamtion about member for add/remove
     */
    public void executeCommands(String command, String[] commands) {
        if (command.equals("A")) {
            if (addMemberToDatabase(commands)) {
                System.out.println("member added to database");
            }
            else{
                System.out.println("Member already in database");
            }
        }


        else if (command.equals("R")) {
            Date date = new Date(commands[3]);
            Member member = new Member();
            member.setFname(commands[1]);
            member.setLname(commands[2]);
            member.setDob(date);
            if(db.remove(member) == true){
                System.out.println(commands[1] + " " +commands[2] + " removed.");
            }
            else{
                System.out.println(commands[1] + " " + commands[2] + " doesn't exist.");
            }
        }
        else if (command.equals("P")) {
            System.out.println("-list of members-");
            db.print();
            System.out.println("-end of list-");
            System.out.println();
        }
        else if (command.equals("PC")) {
            System.out.println("-list of members sorted by county and zipcode-");
            db.printByCounty();
            System.out.println("-end of list-");
            System.out.println();
        }
        else if (command.equals("PN")) {
            System.out.println("-list of members sorted by last name, and first name-");
            db.printByName();
            System.out.println("-end of list-");
            System.out.println();
        }
        else if (command.equals("PD")) {
            System.out.println("-list of members sorted by membership expiration date-");
            db.printByExpirationDate();
            System.out.println("-end of list-");
            System.out.println();
        }
        else if (command.equals("Q")) {
            System.out.println("Gym Manager terminated.");
            System.exit(0);
        }
        else if(command.equals("C")){
            String fName = commands[2];
            String lName = commands[3];
            String className = commands[1];
            Date dob = new Date(commands[4]);

            Member member = new Member();
            member.setDob(dob);
            member.setFname(fName);
            member.setLname(lName);

            if (db.contains(member) != -1) {
                member = db.getMember(db.contains(member));
                for (int i = 0; i < fitnessClasses.length; i++) {
                    if ((fitnessClasses[i].getFitnessName()).equalsIgnoreCase(className)) {
                        fitnessClasses[i].checkIn(member, db, className, fitnessClasses);
                        return;
                    }
                }
                System.out.println(className + " class does not exist");
            } else {
                System.out.println(fName + " " + lName + " is not in the database.");
            }
        }
        else if(command.equals("D")){
            String fitnessClassName = commands[1];
            String firstName = commands[2];
            String lastName = commands[3];
            Date dob = new Date(commands[4]);
            Member member = new Member();
            member.setLname(lastName);
            member.setFname(firstName);
            member.setDob(dob);
            for (int i = 0; i < fitnessClasses.length; i++) {
                if (fitnessClasses[i].getFitnessName().equalsIgnoreCase(fitnessClassName)) {
                    fitnessClasses[i].dropClass(new Member(firstName, lastName, dob), db);
                    return;
                }
            }
            System.out.println("class not exist");
        }
        else if(command.equals("S")){
            System.out.println("-Fitness classes-");
            for (int i = 0; i < fitnessClasses.length; i++) {
                fitnessClasses[i].printSchedule();
            }
        }
    }

    /**
     This is a helper method for adding a member to the member database.
     It takes care of valid, date of birth, expiration, and location to properly add a member.
     Also takes care of if there is already a member with the same information in the database.
     @param commands Gives the list of commands for whatever comes after Add command with name, dates, and location.
     @return true if the member was added, and false if the member wasn't added.
     */
    public boolean addMemberToDatabase(String[] commands) {
        String location = commands[5];
        Date exp = new Date(commands[4]);
        Date dob = new Date(commands[3]);
        boolean checkLocation = true;
        location = location.toUpperCase();
        if (location.equals("EDISON")) {
            checkLocation = true;
        }
        else if (location.equals("BRIDGEWATER")) {
            checkLocation = true;
        }
        else if (location.equals("SOMERVILLE")) {
            checkLocation = true;
        }
        else if (location.equals("PISCATAWAY")) {
            checkLocation = true;
        }
        else if (location.equals("FRANKLIN")) {
            checkLocation = true;
        } else {
            checkLocation = false;
        }
        if (dob.isValid() && dob.isAdult() && exp.isValid() && checkLocation == true) {
            Member member = new Member();
            member.setDob(dob);
            member.setExpire(exp);
            member.setFname(commands[1]);
            member.setLname(commands[2]);

            //Split location back to match enum location
            String finalLocation1 = location.substring(1).toLowerCase();
            String finalLocation2 = location.substring(0,1).toUpperCase();

            //Put it back together here
            location = finalLocation2 + finalLocation1;
            member.setLocation(Location.valueOf(location));
            return db.add(member);
        } else {
            if(dob.isAdult() == false){
                System.out.println("DOB " + dob.getMonth() + "/" + dob.getDay() + "/" + dob.getYear() + ": must be 18 or older to join!");
            }
            else if (dob.isValid() == false) {
                System.out.println("DOB " + dob.getMonth() + "/" + dob.getDay() + "/" + dob.getYear() + ": invalid calender date!");
            } else if (exp.isValid() == false) {
                System.out.println("Expiration date " + exp.getMonth() + "/" + exp.getDay() + "/" + exp.getYear()  + ": invalid calender date!");
            } else if (checkLocation == false) {
                return false;
            }
            return false;
        }

    }
}