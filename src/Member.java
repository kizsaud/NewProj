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
        return fname + " " + lname + ", DOB: " + dob + "," + " Membership expires" + expire + ", Location: " + location;
    }
    @Override
    public boolean equals(Object obj)
    {
        if(obj == this)
        {
            return true;
        }
        if(obj == null)
        {
            return false;
        }
        else
        {
            return false;
        }
    }
    @Override
    public int compareTo(Member member)
    {
        if(this.fname.compareTo(member.getFname()) > 0){
            return 1;
        }
        if(this.fname.compareTo(member.getFname()) < 0){
            return -1;
        }
        if(this.fname.compareTo(member.getFname()) == 0){
            if(this.lname.compareTo(member.getLname()) > 0){
                return 1;
            }
            if(this.lname.compareTo(member.getLname()) < 0){
                return -1;
            }
            if(this.lname.compareTo(member.getLname()) == 0){
                if(this.dob.compareTo(member.getDob()) > 0){
                    return 1;
                }
                if(this.dob.compareTo(member.getDob()) < 0){
                    return -1;
                }
            }
        }
        return -1;
    }
}