public class TestBed {

    public static void main(String args[]){
        //Testing the date isValid() Method.
        //First TestCase Checks if they months are between 1-12
        Date A1  = new Date("14/29/2024");
        Date B1  = new Date("0/29/2024");
        Date C1  = new Date("-1/29/2024");
        System.out.println("Testcase for isValid() method:");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("TEST CASE 1:");
        System.out.println(A1.isValid());
        System.out.println(B1.isValid());
        System.out.println(C1.isValid());
        System.out.println("++++++++++++++++++++++++");



        //TestCase 2
        //LeapYear
        System.out.println("Test Case 2:");
        Date A2 = new Date("02/29/2022");
        System.out.println(A2.isValid());
        System.out.println("++++++++++++++++++++++++");

        //TestCase 3
        System.out.println("Test Case 3:");
        Date A3 = new Date("02/30/2024");
        System.out.println(A3.isValid());
        System.out.println("++++++++++++++++++++++++");

        //TestCase 4
        //Febuary can have 29 days if Leap
        System.out.println("Test Case 4:");
        Date A4 = new Date("02/29/2024");
        System.out.println(A4.isValid());
        System.out.println("++++++++++++++++++++++++");

        //TestCase 5
        //Febuary can have 29 days if Leap
        System.out.println("Test Case 5:");
        Date A5 = new Date("-02/29/2024");
        System.out.println(A5.isValid());
        System.out.println("++++++++++++++++++++++++");
        //Test case 6
        Date A6A = new Date("01/32/2022");
        Date A6B = new Date("02/29/2022");
        Date A6C = new Date("03/32/2022");
        Date A6D = new Date("04/32/2022");
        Date A6E = new Date("05/32/2022");
        Date A6F = new Date("06/32/2022");
        Date A6G = new Date("07/32/2022");
        Date A6H = new Date("08/32/2022");
        Date A6I = new Date("09/32/2022");
        Date A6J = new Date("10/32/2022");
        Date A6K = new Date("11/32/2022");
        Date A6l = new Date("12/32/2022");
        System.out.println("TEST CASE 6:");
        System.out.println(A6A.isValid());
        System.out.println(A6B.isValid());
        System.out.println(A6C.isValid());
        System.out.println(A6D.isValid());
        System.out.println(A6E.isValid());
        System.out.println(A6F.isValid());
        System.out.println(A6G.isValid());
        System.out.println(A6H.isValid());
        System.out.println(A6I.isValid());
        System.out.println(A6J.isValid());
        System.out.println(A6K.isValid());
        System.out.println(A6l.isValid());
        System.out.println("++++++++++++++++");
        //Testcase 7
        Date A6A1= new Date("01/32/2024");
        Date A6B1 = new Date("02/30/2024");
        Date A6C1 = new Date("03/32/2024");
        Date A6D1 = new Date("04/32/2024");
        Date A6E1 = new Date("05/32/2024");
        Date A6F1 = new Date("06/32/2024");
        Date A6G1 = new Date("07/32/2024");
        Date A6H1 = new Date("08/32/2024");
        Date A6I1 = new Date("09/32/2024");
        Date A6J1 = new Date("10/32/2024");
        Date A6K1 = new Date("11/32/2024");
        Date A6l1 = new Date("12/32/2024");
        System.out.println("TEST CASE 7:");
        System.out.println(A6A1.isValid());
        System.out.println(A6B1.isValid());
        System.out.println(A6C1.isValid());
        System.out.println(A6D1.isValid());
        System.out.println(A6E1.isValid());
        System.out.println(A6F1.isValid());
        System.out.println(A6G1.isValid());
        System.out.println(A6H1.isValid());
        System.out.println(A6I1.isValid());
        System.out.println(A6J1.isValid());
        System.out.println(A6K1.isValid());
        System.out.println(A6l1.isValid());
        System.out.println("++++++++++++++++");
        Date A6A2 = new Date("10/04/1899");
        System.out.println("TEST CASE 8:");
        System.out.println(A6A2.isValid());

        System.out.println("++++++++++++++++");

        System.out.println("TEST CASE 9:");
        Date A6A3 = new Date("10/04/1995");
        System.out.println(A6A3.isValid());


        System.out.println("End TestCase");
        System.out.println("++++++++++++++++++++++++");














        Date DoB = new Date("10/05/2025");
        Date dob2 = new Date("10/20/1944");

        Date dob = new Date("10/04/1995");
        //Testing compareTo from Member
        //#1 Test CASE!
        Member one = new Member();
        Member TC1 = new Member();
        one.setFname("Khizar");
        TC1.setFname("Khizar");
        one.setLname("Saud");
        TC1.setLname("Saud");
        one.setDob(dob);
        TC1.setDob(dob);
        System.out.println("Test cases for CompareTwo() Method of the member class");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("TEST CASE 1:");
        System.out.println(one.compareTo(TC1));
        System.out.println("++++++++++++++++++++++++");





        //#2 Test Case!
        Member two = new Member();
        Member TC2 = new Member();
        two.setFname("Khizar");
        TC2.setFname("Larry");
        two.setLname("Saud");
        TC2.setLname("Saud");
        two.setDob(dob);
        TC2.setDob(dob);
        System.out.println("TEST CASE 2:");
        System.out.println(two.compareTo(TC2));
        System.out.println("++++++++++++++++++++++++");



        //#3 Test Case
        Member three = new Member();
        Member TC3 = new Member();
        three.setFname("Khizar");
        TC3.setFname("Khizar");
        three.setLname("jackson");
        TC3.setLname("Saud");
        TC3.setDob(dob);
        three.setDob(dob);
        System.out.println("TEST CASE 3:");
        System.out.println(three.compareTo(TC3));
        System.out.println("++++++++++++++++++++++++");
        //#4 TestCase
        Member A = new Member();
        A.setDob(dob);
        A.setFname("Khizar");
        A.setLname("Saud");
        A.setLocation(Location.Bridgewater);
        A.setExpire(DoB);
        Member B = new Member();
        B.setDob(dob2);
        B.setFname("Khizar");
        B.setLname("Jackson");
        B.setLocation(Location.Bridgewater);
        B.setExpire(DoB);
        System.out.println("TEST CASE 4:");

        System.out.println(A.compareTo(B));
        System.out.println("End TestCase");
        System.out.println("++++++++++++++++++++++++");


    }

}
