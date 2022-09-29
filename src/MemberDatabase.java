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

    private int find(Member member) {
        int NOT_FOUND = -1;
        for (int i = 0; i < mlist.length; i++) {
            if (mlist[i] == member) {
                return i;
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
        Member newList[] = new Member[mlist.length + 1];
        for(int i = 0; i < mlist.length; i++) {
            newList[i] = mlist[i];
        }
        newList[newList.length-1] = member;
        return true;
    }
    public boolean remove(Member member) {
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
        return false;
    }

    public void print () {
        for(int i = 0; i < mlist.length; i++) {
            System.out.println(mlist[i].toString());
        }
    } //print the array contents as is
    public void printByCounty() {
        for(int i = 0; i < mlist.length; i++){
            mlist[i].getLocation().getCounty();
        }
    } //sort by county and then zipcode
    public void printByExpirationDate() {
        for(int i = 0; i< mlist.length; i++) {
            for(int j = i+1; j < mlist.length; j++) {
                if(mlist[i].getExpire().getYear() > mlist[j].getExpire().getYear()){
                    Member temp = mlist[i];
                    mlist[i] = mlist[j];
                    mlist[j] = temp;
                }
                else if(mlist[i].getExpire().getYear() == mlist[j].getExpire().getYear() &&
                        mlist[i].getExpire().getMonth() > mlist[j].getExpire().getMonth()){
                    Member temp = mlist[i];
                    mlist[i] = mlist[j];
                    mlist[j] = temp;
                }
                else if(mlist[i].getExpire().getYear() == mlist[j].getExpire().getYear() &&
                        mlist[i].getExpire().getMonth() == mlist[j].getExpire().getMonth() &&
                        mlist[i].getExpire().getDay() > mlist[j].getExpire().getDay()){
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
            for(int j = 1; j < mlist.length; j++) {
                if(mlist[i].getLname().equals(mlist[j].getLname())) {
                    if(mlist[i].getFname().compareTo(mlist[j].getFname()) > 0) {
                        Member temp = mlist[i];
                        mlist[i] = mlist[j];
                        mlist[j] = temp;
                    }
                }
                else {
                    if(mlist[i].getLname().compareTo(mlist[j].getLname()) > 0) {
                        Member temp = mlist[i];
                        mlist[i] = mlist[j];
                        mlist[j] = temp;
                    }
                }
            }
        }
        for(int i = 0; i < mlist.length; i++) {
            System.out.println(mlist[i].toString());
        }
    }
}
