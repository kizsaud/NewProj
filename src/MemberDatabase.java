public class MemberDatabase {
    enum Locations{
            Bridgewater("08807","Somerset County"),
            Edison("08837","Middlesex County"),
            Franklin("08873","Somerset County"),
            Piscataway("08854","Middlesex County"),
            Somerville("08876","Somerset County");

            String zipcode;
            String County;
            Locations(String Z, String C){
                zipcode=Z;
                County=C;


            }
            public String getCounty(Locations a){
                return a.County;

            }
        }


    private Member [] mlist;
    private int size;

    public MemberDatabase(){
        this.size = size;
        this.mlist = new Member[4];
    }
    private int find(Member member) {
        int NOT_FOUND = -1;
        for (int i = 0; i < mlist.length; i++) {
            if (mlist[i] != null && mlist[i].equals(member)) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    private void grow() {
        Member[] newList = new Member[mlist.length+4];
        for(int i = 0; i < mlist.length; i++){
            newList[i] = mlist[i];
        }
        mlist=newList;
    }
    public boolean add(Member member) {
        if(find(member) != -1){
            return false;
        }
        if(size == mlist.length-1){
            grow();
        }
        mlist[size] = member;
        size++;
        return true;
    }
    public boolean remove(Member member) {
        if(find(member) == -1){
            return false;
        }
        Member[]temp = new Member[size];
        boolean found = false;
        int memberIDX = 0;
        for(int i = 0; i < size; i++){
            if(mlist[i] != null && member.equals(mlist[i])){
                found = true;
            }
            else{
                temp[memberIDX] = mlist[i];
                memberIDX++;
            }
        }
        size--;
        mlist = temp;
        return found;
    }

    public void print () {
        for(int i = 0; i < mlist.length; i++) {
            if(mlist[i] != null){
                System.out.println(mlist[i].toString());
            }
        }
    } //print the array contents as is
    public void printByCounty() {
        int increment = 1;
        while (increment < size) {
            increment = 2 * increment + 1;
        }
        while (increment >= 1) {
            for (int i = increment; i < size; i++) {
                for (int j = i; j >= increment; j -= increment) {
                    if (mlist[j].getLocation().getBoth().compareTo(mlist[j - increment].getLocation().getBoth()) < 0) {
                        Member temp = mlist[j];
                        mlist[j] = mlist[j - increment];
                        mlist[j - increment] = temp;
                    } else {
                        break;
                    }
                }
            }
            increment /= 2;
        }
        print();
    } //sort by county and then zipcode
    public void printByExpirationDate() {
        for (int i = 1; i < this.size; i++) {
            Member m = mlist[i];
            int j = i - 1;
            while (j >= 0 && mlist[j].getExpire().compareTo(m.getExpire()) == 1) {
                mlist[j + 1] = mlist[j];
                j--;
            }
            mlist[j + 1] = m;
        }
        print();
    }
    public void printByName() {
        for(int i = 0; i < size; i++){
            Member m = mlist[i];
            int j = i - 1;
            while(j >= 0 && (mlist[j] != null && mlist[i] != null) && (mlist[j].getLname().compareTo(m.getLname())) > 0){
                mlist[j + 1] = mlist[j];
                j = j - 1;
            }
            mlist[j + 1] = m;
        }
        print();
    }
}
