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
        if(find(member) == -1){
            if(mlist[mlist.length-1] != null){
                grow();
            }
            else{
                for(int i = 0; i < mlist.length; i++){
                    if(mlist[i] == null){
                        mlist[i] = member;
                        return true;
                    }
                }
            }
        }
        else{
            return false;
        }
        return false;
    }
    public boolean remove(Member member) {
        if(find(member) < 0){
            return false;
        }
        Member [] temp = new Member[size];
        boolean found = true;
        int indx = 0;
        for(int i = 0; i < size; i++){
            if(mlist[i] != null && member.equals(mlist[i])){
                found = true;
            }
            else{
                temp[indx] = mlist[i];
                indx++;
            }
        }
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
        //Sort The List
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
