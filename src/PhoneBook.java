import java.util.ArrayList;

public class PhoneBook {
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> phones = new ArrayList<>();
    int size;

    // constructor with no parameters
    public PhoneBook(){
        size=0;
        System.out.println("Hello Sir, Welcome to Smart PhoneBook");
    }
    // set size tot the size attributes
    public void setSize(int size) {
        if(size>0)
            this.size = size;
    }

    // checks if name has space to add and checks if the phone have 11 digits to add otherwise not add this name& the phone number
    public void addEntry(String name , String phone) {
        if (!name.contains(" ")) {
            System.out.println("invalid");
            return;
        }
        if(!phone.matches("\\d{11}")){
            System.out.println("invalid");
        }
        else{
            names.add(name);
            phones.add(phone);
        }

    }
    // print entry if its index in range and the array isn't empty
    public void displayEntryAtIndex(int index){
        if(index<0 || index>=names.size()){
            System.out.println("invalid index");
            return;
        }
        System.out.println("name & phone at index: " + index + " = [" +names.get(index) +" , "+ phones.get(index)+"]");
    }

    // takes array of integers then checks for each number if 1 print the entry if 0 don't print
    public void displayEntryAtIndices(int []arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                System.out.println("["+names.get(i) + " , " + phones.get(i)+"]");
            }
        }
    }
    // checks if name is in the array return 1
    public int findByName(String str) {
        str = str.toLowerCase().trim();
        for (String i : names) {
            if (i!=null && i.toLowerCase().trim().contains(str)) {
                return 1;
            }
        }
        return 0;
    }
    // checks if phone is in the array return 1
    public String findByPhone(String phone) {
        for (int i = 0; i <phones.size(); i++) {
            if (names.get(i)!=null && phones.get(i).equals(phone)) {
                return names.get(i);
            }

        }
        return " ";
    }
    // update name at specific index
    public boolean updateNameAt(String newName ,int index){
        if (index<0 || index>names.size()){
            return false;
        }else {
            names.set(index,newName);
            return true;
        }

    }
    // update phone at specific index
    public boolean updatePhoneAt(String newPhone ,int index){
        if (index<0 || index>phones.size()){
            return false;
        }else {
            phones.set(index,newPhone);
            return true;
        }

    }
    // copy PhoneBook class
    public void copyPB(PhoneBook pb){
        // watch out from size it must be assigned like the others attributes
        pb.names = this.names;
        pb.phones = this.phones;
        pb.size = this.size;
        System.out.println("The phone book has been copied successfully");

        /*
        --deep copy--
        pb.names = new ArrayList<>(this.names);
        pb.phones=new ArrayList<>(this.phones);
        pb.size=this.size;

         */

    }


    // display all entries
    public void displayAll(){
        for (int i = 0; i < size; i++) {
            System.out.println("[" + names.get(i) + " , " + phones.get(i)+"]");
        }
    }



}
