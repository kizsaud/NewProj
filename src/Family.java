
public class Family extends Member {
    protected int numOfGuestPass;

    public Family() {
        numOfGuestPass = 1;
    }

    public Family(String firstName, String lastName, Date dob, Date expirationDate, Location location) {
        super(firstName, lastName, dob, expirationDate, location);
        this.numOfGuestPass = 1;
    }

    public int getNumOfGuestPass() {
        return numOfGuestPass;
    }

    public void setNumOfGuestPass(int num) {
        this.numOfGuestPass += num;
    }

    @Override
    public double membershipFee() {
        return 59.99;
    }
}