public class Member implements Comparable<Member>{
    private String fname;
    private String lname;
    private Date dob;
    private Date expire;
    private Location location;

    @Override
    public String toString()
    {
        return fname + " " + lname + ", DOB: " + dob + "," + " Membership expires" + expire + ", Location: " + location;
    }
    @Override
    public boolean equals(Object obj)
    {

    }
    @Override
    public int compareTo(Member member)
    {

    }
}