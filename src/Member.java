public class Member implements Comparable<Member>{
    private String fname;
    private String lname;
    private Date dob;
    private Date expire;
    private Location location;

    public String getFname()
    {
        return fname;
    }
    public void setFname(String val)
    {
        fname = val;
    }
    public String getLname()
    {
        return lname;
    }
    public void setLname(String val)
    {
        lname = val;
    }
    public Location getLocation(){
        return location;
    }
    public void setLocation(Location l){
        location = l;
    }
    public Date getDob(){
        return dob;
    }
    public void setDob(Date d){
        dob = d;
    }
    public Date getExpire() {
        return expire;
    }
    public void setExpire(Date d) {
        expire = d;
    }
    @Override
    public String toString() {
        Date temp = new Date();
        if(this.getExpire().compareTo(temp) == 0 || this.getExpire().compareTo(temp) == -1){
            return fname + " " + lname + ", DOB: " + dob.getMonth() + "/" + dob.getDay() + "/" + dob.getYear() + "," + " Membership expired: " + expire.getMonth() + "/" + expire.getDay() + "/" + expire.getYear() + ", Location: " + location;
        }
        return fname + " " + lname + ", DOB: " + dob.getMonth() + "/" + dob.getDay() + "/" + dob.getYear() + "," + " Membership expires: " + expire.getMonth() + "/" + expire.getDay() + "/" + expire.getYear() + ", Location: " + location;
    }
    @Override
    public boolean equals(Object obj)
    {
        Member member = (Member)obj;
        String firstName = fname.toLowerCase();
        String lastName = lname.toLowerCase();
        String secondFirstName = member.getFname().toLowerCase();
        String secondLastName = member.getLname().toLowerCase();
        if (firstName.equals(secondFirstName) && lastName.equals(secondLastName) && dob.compareTo(member.dob) == 0) {
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public int compareTo(Member member)
    {
        if(!(this.fname.equals(member.getFname()))){
            return -1;
        }
        else{
            if(!(this.lname.equals(member.getLname()))){
                return -1;
            }
            else{
                if(this.dob.compareTo(member.getDob()) != 0){
                    return -1;
                }
                else{
                    return 1;
                }
            }
        }
    }
}