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
        Member m = (Member)obj;
        String ln = lname.toLowerCase();
        String fn = fname.toLowerCase();
        String lnOther = m.getLname().toLowerCase();
        String fnOther = m.getFname().toLowerCase();

        if(fn.equals(fnOther) && ln.equals(lnOther) && dob.compareTo(m.dob) == 0){
            return true;
        }
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
