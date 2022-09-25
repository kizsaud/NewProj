public class MemberDatabase {
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

    }
    public boolean add(Member member) {
        Member newList[] = new Member[mlist.length + 1];
        for(int i = 0; i < mlist.length; i++) {
            newList[i] = mlist[i];
        }
    }
    public boolean remove(Member member) {
        Member [] newList = new Member[mlist.length-1];
        for(int i = 0; i < mlist.length; i++) {
            if(mlist[i] == member) {
                i++;
            }
            else {
                newList[i] = mlist[i];
            }
        }
        mlist = newList;
    }
    public void print () {
        for(int i = 0; i < mlist.length; i++) {
            System.out.println(mlist[i].toString());
        }
    } //print the array contents as is
    public void printByCounty() {

    } //sort by county and then zipcode
    public void printByExpirationDate() {

    } //sort by the expiration date


    public void printByName() {
        Member temp;
        Member [] nameList = new Member[mlist.length];
        for(int i = 0; i < mlist.length; i++) {
            nameList[i] = mlist[i];
        }
        for(int i = 0; i < nameList.length; i++) {
            for(int j = 1; j < nameList.length; j++) {
                if(nameList[i].getLname().equals(nameList[j].getLname())) {
                    if(nameList[i].getFname().compareTo(nameList[j].getFname()) > 0) {
                        temp = nameList[i];
                        nameList[i] = nameList[j];
                        nameList[j] = temp;
                    }
                }
                else {
                    if(nameList[i].getLname().compareTo(nameList[j].getLname()) > 0) {
                        temp = nameList[i];
                        nameList[i] = nameList[j];
                        nameList[j] = temp;
                    }
                }
            }
        }
        for(int i = 0; i < nameList.length; i++) {
            System.out.println(mlist[i]);
        }
    } //sort by last name and then first name
}
