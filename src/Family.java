public class Family extends Member{
    private String fname;
    private String lname;
    private Date dob;
    private Date expire;
    private Location location;
    private int guestPass;

    public Family(String fname, String lname, Date dob, Date expire, Location location, int guestPass){
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.expire = expire;
        this.location = location;
        this.guestPass = guestPass;
    }

    public Family(){

    }

    /**
     This is a constructor for the Member class being given just the first and last name and date of birth.
     @param fname the name of the person to make.
     @param lname the last name of the person to make.
     @param dob the date of birth of the person to make.
     */
    public Family(String fname, String lname, Date dob) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
    }

    /**
     This is a constructor for the Member class being given just the first and last name.
     @param fname the name of the person to make.
     @param lname the last name of the person to make.
     */
    public Family(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }


    /**
     * This is a getter method for the first name of the member.
     @return this returns the first name of the member.
     */
    public String getFname()
    {
        return fname;
    }

    /**
     * This is the setter method of the first name variable for the member class
     @param val The first name to set in member.
     */

    public void setFname(String val)
    {
        fname = val;
    }

    /**
     * This is a getter method for the last name of the member.
     @return this returns the last name of the member.
     */
    public String getLname()
    {
        return lname;
    }

    /**
     * This is the setter method of the last name variable for the member class
     @param val The last name to set in member.
     */

    public void setLname(String val)
    {
        lname = val;
    }

    /**
     * This is a getter method for the location of the member.
     @return this returns the location of the member.
     */
    public Location getLocation(){
        return location;
    }

    /**
     * This is the setter method of the location variable for the member class
     @param l The location to set in member.
     */
    public void setLocation(Location l){
        location = l;
    }

    /**
     * This is a getter method for the date of birth of the member.
     @return this returns the date of birth of the member.
     */
    public Date getDob(){
        return dob;
    }

    /**
     * This is the setter method of the date of birth variable for the member class
     @param d The date to set in member.
     */
    public void setDob(Date d){
        dob = d;
    }

    /**
     * This is a getter method for the expiration date of the member.
     @return this returns the expiration date of the member.
     */
    public Date getExpire() {
        return expire;
    }
    /**
     * This is the setter method of the expire variable for the member class
     @param d The date to set in member.
     */
    public void setExpire(Date d) {
        expire = d;
    }

    public int getGuestPass(){
        return guestPass;
    }

    public void setGuestPass(int pass){
        guestPass = pass;
    }

    /**
     This is the toString method which displayed all the information about the memeber in a string and allows
     for using it as a string.
     @return the String which would be the String of the member with all the information displayed.
     */
    @Override
    public String toString() {
        Date temp = new Date();
        if(this.getExpire().compareTo(temp) == 0 || this.getExpire().compareTo(temp) == -1){
            return fname + " " + lname + ", DOB: " + dob.getMonth() + "/" + dob.getDay() + "/" + dob.getYear() + "," + " Membership expired: " + expire.getMonth() + "/" + expire.getDay() + "/" + expire.getYear() + ", Location: " + location + ", " + location.getZipcode(location) + ", " + location.getCounty(location).substring(0, location.getCounty(location).indexOf(" ")).toUpperCase() + ", (Family) Guest-Pass Remaining: " + guestPass;
        }
        return fname + " " + lname + ", DOB: " + dob.getMonth() + "/" + dob.getDay() + "/" + dob.getYear() + "," + " Membership expires: " + expire.getMonth() + "/" + expire.getDay() + "/" + expire.getYear() + ", Location: " + location + ", " + location.getZipcode(location) + ", " + location.getCounty(location).substring(0, location.getCounty(location).indexOf(" ")).toUpperCase() + ", (Family) Guest-Pass Remaining: " + guestPass;
    }
    public String toStringCost() {
        Date temp = new Date();
        if(this.getExpire().compareTo(temp) == 0 || this.getExpire().compareTo(temp) == -1){
            return fname + " " + lname + ", DOB: " + dob.getMonth() + "/" + dob.getDay() + "/" + dob.getYear() + "," + " Membership expired: " + expire.getMonth() + "/" + expire.getDay() + "/" + expire.getYear() + ", Location: " + location + ", " + location.getZipcode(location) + ", " + location.getCounty(location).substring(0, location.getCounty(location).indexOf(" ")).toUpperCase() + ", (Family) Guest-Pass Remaining: " + guestPass + " Membership Fee: $" + membershipFee();
        }
        return fname + " " + lname + ", DOB: " + dob.getMonth() + "/" + dob.getDay() + "/" + dob.getYear() + "," + " Membership expires: " + expire.getMonth() + "/" + expire.getDay() + "/" + expire.getYear() + ", Location: " + location + ", " + location.getZipcode(location) + ", " + location.getCounty(location).substring(0, location.getCounty(location).indexOf(" ")).toUpperCase() + ", (Family) Guest-Pass Remaining: " + guestPass + " Membership Fee: $" + membershipFee();
    }

    /**
     * This is a method which helps with seeing if the member is the same when being compared.
     @param obj The object which is passed for comparing
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Family objFamily) {
            boolean isFNameSame = this.fname.equalsIgnoreCase(objFamily.fname);
            boolean isLNameSame = this.lname.equalsIgnoreCase(objFamily.lname);
            boolean isDobSame = this.getDob().getDay() == objFamily.getDob().getDay() &&
                    this.getDob().getMonth() == objFamily.getDob().getMonth() &&
                    this.getDob().getYear() == objFamily.getDob().getYear();
            return isFNameSame && isLNameSame && isDobSame;
        }
        return false;
    }

    /**
     * This is a method which helps with seeing if the member is the same when being compared.
     @param member The object which is passed for comparing
     */
    public int compareTo(Family member)
    {
        if(this.fname.equals(member.getFname()) && this.lname.equals(member.getLname()) && this.dob.compareTo(member.dob) == 0){
            return 0;
        }
        else{
            return -1;
        }

    }
    public double membershipFee() {
        double initialFee = 29.99;
        double billingPeriod = 3.0;
        double monthlyFee = 59.99;
        return initialFee + (monthlyFee * billingPeriod);
    }
}
