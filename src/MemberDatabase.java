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
    }
    private int find(Member member) {
        int NOT_FOUND = -1;
        for (int i = 0; i < mlist.length; i++) {
            if (mlist[i].compareTo(member) == 0) {
                return 1;
            }
        }
        return NOT_FOUND;
    }

    private void grow() {
        Member[] newList = new Member[mlist.length+1];
        for(int i = 0; i < newList.length; i++){
            newList[i] = mlist[i];
        }
        mlist=newList;
    }
    public boolean add(Member member) {
        grow();
        mlist[mlist.length] = member;
        return true;
    }
    public boolean remove(Member member) {
        if (find(member) == -1){
            return false;
        }
        else{
            for(int x = 0; x < mlist.length; x++){
                if(mlist[x] == member) {
                    Member[] newList = new Member[mlist.length - 1];
                    for (int i = 0; i < mlist.length; i++) {
                        if (mlist[i] == member) {
                            i++;
                        } else {
                            newList[i] = mlist[i];
                        }
                    }
                    mlist = newList;
                    return true;
                }
            }
        }
        return false;
    }

    public void print () {
        for(int i = 0; i < mlist.length; i++) {
            System.out.println(mlist[i].toString());
        }
    } //print the array contents as is
    public void printByCounty() {
        for(int i = 0; i < mlist.length; i++){
            mlist[i].getLocation().getCounty(mlist[i].getLocation());
        }
    } //sort by county and then zipcode
    public void printByExpirationDate() {
        for(int i = 0; i< mlist.length; i++) {
            for(int j = i+1; j < mlist.length; j++) {
                if(mlist[i].getExpire().compareTo(mlist[j].getExpire()) == 0) {
                    Member temp = mlist[i];
                    mlist[i] = mlist[j];
                    mlist[j] = temp;
                }
            }
        }
        for(int i = 0; i < mlist.length; i++){
            System.out.println(mlist[i].toString());
        }
    }
    public void printByName() {
        for(int i = 0; i < mlist.length; i++) {
            for(int j = i+1; j < mlist.length; j++) {
                if(mlist[i].compareTo(mlist[j]) > 0) {
                    Member temp = mlist[i];
                    mlist[i] = mlist[j];
                    mlist[j] = temp;
                }
            }
        }
        for(int i = 0; i < mlist.length; i++) {
            System.out.println(mlist[i].toString());
        }
    }
}
