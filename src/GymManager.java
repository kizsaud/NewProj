import java.util.Scanner;

public class GymManager {
    MemberDatabase db = new MemberDatabase();
    public GymManager() {
        MemberDatabase db = new MemberDatabase();
    }

    public void run(){
        System.out.println("Gym Manager running...");
        Scanner scan = new Scanner(System.in);
        String user = "";
        int ptr = 0;
        while(scan.hasNext() || user.equals("Q")){
            user = scan.nextLine();
            String command = user.substring(0,user.indexOf(" "));
            ptr = user.indexOf(" ", ptr) + 1;
            if(command.equals("A")){
                //decalre new nember
                Member m = new Member();
                // Find Member attributes from string
                String firstName = user.substring(ptr, user.indexOf(" "));
                ptr = user.indexOf(" ", ptr) + 1;
                String lastName = user.substring(ptr, user.indexOf(" "));
                ptr = user.indexOf(" ", ptr) + 1;
                String dobDate = user.substring(ptr, user.indexOf(" "));
                ptr = user.indexOf(" ", ptr) + 1;
                String expDate = user.substring(ptr, user.indexOf(" "));
                ptr = user.indexOf(" ", ptr) + 1;
                String city = user.substring(ptr, user.indexOf(" "));
                ptr = user.indexOf(" ", ptr) + 1;

                //Declare a date and Location for the Member
                Date exp = new Date(expDate);
                Date dob = new Date(dobDate);



                Date today = new Date();
                Date adult = new Date();
                adult.setYear(adult.getYear() - 18);
                //Set attributes into member
                if(dob.compareTo(today) == 0|| dob.compareTo(today) == -1){
                    System.out.println("cannot be today or a future date!");
                }
                else if(dob.isValid() == false){
                    System.out.println("DOB " + dobDate + ": invalid calender date!");
                }
                else if(exp.isValid() == false){
                    System.out.println("Expiration date " + expDate + ": invalid calender date!");
                }
                else{
                    m.setFname(firstName);
                    m.setLname(lastName);
                    m.setDob(dob);
                    m.setExpire(exp);
                }
                //set location of member
                if(city=="Bridgewater"){
                    Location A = Location.Bridgewater;
                    m.setLocation(A);
                }
                else if(city=="Edison"){
                    Location A = Location.Edison;
                    m.setLocation(A);
                }
                else if(city=="Franklin"){
                    Location A = Location.Franklin;
                    m.setLocation(A);
                }
                else if(city=="Somerville"){
                    Location A = Location.Somerville;
                    m.setLocation(A);
                }
                else if(city=="Somerville"){
                    Location A = Location.Somerville;
                    m.setLocation(A);
                }
                else if(city=="Piscataway"){
                    Location A = Location.Piscataway;
                    m.setLocation(A);
                }

                //put member in the member database if they do not exist

                if(db.add(m) == true){
                    System.out.println(firstName + " " + lastName + " added.");
                }
                else{
                    System.out.println(firstName + " " + lastName + " is already in the database.");
                }
            }


            else if(command.equals("R")){
                Member m = new Member();
                String firstName = user.substring(ptr, user.indexOf(" "));
                ptr = user.indexOf(" ", ptr) + 1;
                String lastName = user.substring(ptr, user.indexOf(" "));
                ptr = user.indexOf(" ", ptr) + 1;
                String dobDate = user.substring(ptr, user.indexOf(" "));
                ptr = user.indexOf(" ", ptr) + 1;
                Date dob = new Date(dobDate);
                m.setFname(firstName);
                m.setLname(lastName);
                m.setDob(dob);
                m.setDob(dob);

                if(db.remove(m) == true){
                    System.out.println(firstName + " " + lastName + "removed.");
                }
                else{
                    System.out.println(firstName + " " + lastName + " is not in the database.");
                }

            }
            else if(command.equals("P")){
                db.print();
            }
            else if(command.equals("PC")){
                db.printByCounty();
            }
            else if(command.equals("PN")){
                db.printByName();
            }
            else if(command.equals("PD")){
                db.printByExpirationDate();
            }
        }
    }
}
   
