package ProjectOne;
public class Member implements Comparable<Member>{
    private String fname;
    private String lname;
    private Date dob;
    private Date expire;
    private Location location;
    public Member(){

    }
    public Member(String fname, String lname, Date dob, Date expire, Location location) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
        this.expire = expire;
        this.location = location;
    }
    public Member(String fname, String lname, Date dob) {
        this.fname = fname;
        this.lname = lname;
        this.dob = dob;
    }
    public Member(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }


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
    public boolean equals(Object obj) {
        if (obj instanceof Member objMember) {
            boolean isFNameSame = this.fname.equalsIgnoreCase(objMember.fname);
            boolean isLNameSame = this.lname.equalsIgnoreCase(objMember.lname);
            boolean isDobSame = this.getDob().getDay() == objMember.getDob().getDay() &&
                    this.getDob().getMonth() == objMember.getDob().getMonth() &&
                    this.getDob().getYear() == objMember.getDob().getYear();
            return isFNameSame && isLNameSame && isDobSame;
        }
        int a = "aaa".compareTo("aa");
        return false;
    }
    @Override
    public int compareTo(Member member)
    {
        if(this.fname.equals(member.getFname()) && this.lname.equals(member.getLname()) && this.dob.compareTo(member.dob) == 0){
            return 0;
        }
        else{
            return -1;
        }

    }
}
