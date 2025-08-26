import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PhoneBook p1 = new PhoneBook();
        System.out.print("Enter the size of your phone book: ");
        try {
            int size = scan.nextInt(), ch;
            p1.setSize(size);
            scan.nextLine();
            String name, phone;
            while (size <= 0) {
                System.out.print("invalid size Try again: ");
                size = scan.nextInt();
                scan.nextLine();
            }
            for (int i = 0; i < size; i++) {
                System.out.print("Enter name " + (i + 1) + ": ");
                name = scan.nextLine();
                System.out.print("Enter phone " + (i + 1) + ": ");
                phone = scan.nextLine();
                p1.addEntry(name, phone);
            }
            System.out.println("Choose the operation you want:");
            System.out.println("1- Display all phone book");
            System.out.println("2- Search for entry/entries by name");
            System.out.println("3- Search for entry/entries by phone");
            System.out.println("4- Find an entry by index");
            System.out.println("5- Update name by index");
            System.out.println("6- Update phone by index");
            System.out.println("7- Copy phone book to another and display entries of the new phone book");
            System.out.println("8- Enter array of 1 & 0 same size as you entered to display specified entries(1 to display 0 otherwise)");
            System.out.println("9- Exit");
            while (true) {
                System.out.print("Choice: ");
                ch = scan.nextInt();
                scan.nextLine();
                switch (ch) {
                    case 1:
                        p1.displayAll();
                        break;
                    case 2:
                        System.out.print("Please enter the name you want to search: ");
                        String search_str = scan.nextLine();
                        if (p1.findByName(search_str) == 0) {
                            System.out.println("Not Found");
                        } else {
                            System.out.println("Found!");
                        }
                        break;
                    case 3:
                        System.out.print("Please enter the phone you want to search: ");
                        String search_phone = scan.nextLine();
                        if (p1.findByPhone(search_phone).equals(" ")) {
                            System.out.println("That phone number is not available");
                        } else {
                            System.out.println(p1.findByPhone(search_phone));
                        }
                        break;
                    case 4:
                        System.out.print("Enter the index: ");
                        int index = scan.nextInt();
                        p1.displayEntryAtIndex(index);
                        break;
                    case 5:
                        System.out.print("Enter the name you want to update: ");
                        String update_name = scan.nextLine();
                        System.out.print("Enter the index you want the name in: ");
                        int update_name_index = scan.nextInt();
                        if (p1.updateNameAt(update_name, update_name_index)) {
                            System.out.println("The name has been updated successfully");
                        } else {
                            System.out.println("Error Unsuccessfully update");
                        }
                        break;
                    case 6:
                        System.out.print("Enter the phone you want to update: ");
                        String update_phone = scan.nextLine();
                        System.out.print("Enter the index you want the phone in: ");
                        int update_phone_index = scan.nextInt();
                        if (p1.updatePhoneAt(update_phone, update_phone_index)) {
                            System.out.println("The phone has been updated successfully");
                        } else {
                            System.out.println("Error Unsuccessfully update");
                        }
                        break;
                    case 7:
                        PhoneBook p2 = new PhoneBook();
                        p1.copyPB(p2);
                        p2.displayAll();
                        break;
                    case 8:
                        int[] arr = new int[size];
                        System.out.println("Enter the array: ");
                        for (int i = 0; i < size; i++) {
                            System.out.print("Element " + (i + 1) + ": ");
                            arr[i] = scan.nextInt();
                        }
                        p1.displayEntryAtIndices(arr);
                        break;
                    case 9:
                        System.out.println("Program Terminated .. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice");
    
                }
            }
                
           } catch (Exception e) {
            System.out.println(e.getMessage());
       }


    }
}

