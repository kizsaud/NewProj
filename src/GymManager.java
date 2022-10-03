package ProjectOne;
import java.util.Scanner;

public class GymManager {
    MemberDatabase db = new MemberDatabase();
    private final int finalIntClassSize=3;
    FitnessClass[] fitnessClasses = new FitnessClass[finalIntClassSize];
    int classes = 3;
    //FitnessClass[] fitnessClasses = new FitnessClass[classes];

    public void run() {
        fitnessClasses[0] = new FitnessClass("Pilates", "Jennifer", Time.Pilates, db, fitnessClasses);
        fitnessClasses[1] = new FitnessClass("Spinning", "Denise", Time.Spinning, db, fitnessClasses);
        fitnessClasses[2] = new FitnessClass("Cardio", "Kim", Time.Cardio, db, fitnessClasses);
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

    public void executeCommands(String command, String[] commands) {
        if ("A".equals(command)) {
            if (addMemberToDatabase(commands)) {
                System.out.println("member added to database");
            }
            else{
                System.out.println("Member already in database");
            }
        }
        else if("C".equals(command)){
            String fName = commands[2];
            String lName = commands[3];
            String className = commands[1];
            Date dob = new Date(commands[4]);
            Member findMember = new Member(fName,lName,dob);

            if (db.contains(findMember) != -1) {
                findMember = db.getMember(db.contains(findMember));
                for (int i = 0; i < fitnessClasses.length; i++) {
                    if ((fitnessClasses[i].getFitnessName()).equalsIgnoreCase(className)) {
                        fitnessClasses[i].checkIn(findMember, className, fitnessClasses, db);
                        return;
                    }
                }
                System.out.println(className + " class does not exist");
            } else {
                System.out.println(fName + " " + lName + " " + dob.toString() + " is not in the database.");
            }
        }

        else if ("R".equals(command)) {
            Date date = new Date(commands[3]);
            Member m = new Member();
            m.setFname(commands[1]);
            m.setLname(commands[2]);
            m.setDob(date);
            if(db.remove(m) == true){
                System.out.println(commands[1] + " " +commands[2] + " removed.");
            }
            else{
                System.out.println(commands[1] + " " + commands[2] + " doesn't exist.");
            }

        }
        else if ("P".equals(command)) {
            System.out.println("-list of members-");
            db.print();
            System.out.println("-end of list-");
            System.out.println();
        }
        else if ("PC".equals(command)) {
            System.out.println("-list of members sorted by county and zipcode-");
            db.printByCounty();
            System.out.println("-end of list-");
            System.out.println();
        }
        else if ("PN".equals(command)) {
            System.out.println("-list of members sorted by last name, and first name-");
            db.printByName();
            System.out.println("-end of list-");
            System.out.println();
        }
        else if ("PD".equals(command)) {
            System.out.println("-list of members sorted by membership expiration date-");
            db.printByExpirationDate();
            System.out.println("-end of list-");
            System.out.println();
        }
        else if ("Q".equals(command)) {
            System.out.println("Gym Manager terminated.");
            System.exit(0);
        }
        else if("C".equals(command)){

        }
    }

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
            Member m = new Member();
            m.setDob(dob);
            m.setExpire(exp);
            m.setFname(commands[1]);
            m.setLname(commands[2]);

            //Split location back to match enum location
            String finalLocation1 = location.substring(1).toLowerCase();
            String finalLocation2 = location.substring(0,1).toUpperCase();

            //Put it back together here
            location = finalLocation2 + finalLocation1;
            m.setLocation(Location.valueOf(location));
            return db.add(m);
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
