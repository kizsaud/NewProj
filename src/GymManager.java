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
                Location location = new Location();

                //Set attributes into member
                m.setFname(firstName);
                m.setLname(lastName);
                m.setDob(dob);
                m.setExpire(exp);
                m.setLocation(location);

                //put member in the member database
                db.add(m);
            }
            else if(command.equals("R")){
                Member m = new Member();

                m = db.find(m);
                db.remove(m);
            }
        }
    }
}
