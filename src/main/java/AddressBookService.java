import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBookService {

    public enum IOService {CONSOLE_IO, FILE_IO, DB_IO, REST_IO}
    private List<AddressBookData> addressBookDataList;


    public AddressBookService(List<AddressBookData> addressBookDataList){
        this.addressBookDataList = addressBookDataList;
    }


    public static void main(String[] args) {
        System.out.println("...............Welcome to AddressBookJDBC and file handling program.................");
        ArrayList<AddressBookData> addressBookData = new ArrayList<>();
        AddressBookService addressBookService = new AddressBookService(addressBookData);
        Scanner consoleInputReader = new Scanner(System.in);
        addressBookService.readAddressBookData(consoleInputReader);
        addressBookService.writeAddressBookData(IOService.CONSOLE_IO);
    }

    public void readAddressBookData(Scanner consoleInputReader) {
        System.out.println("Enter ID: ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter First Name: ");
        String firstName = consoleInputReader.next();
        System.out.println("Enter Last Name: ");
        String lastName = consoleInputReader.next();
        System.out.println("Enter Address: ");
        String address = consoleInputReader.next();
        System.out.println("Enter City");
        String city = consoleInputReader.next();
        System.out.println("Enter State: ");
        String state = consoleInputReader.next();
        System.out.println("Enter Zip: ");
        long zip = consoleInputReader.nextLong();
        System.out.println("Enter Phone Number: ");
        long phone = consoleInputReader.nextLong();
        System.out.println("Enter EmailID: ");
        String email = consoleInputReader.next();
        addressBookDataList.add(new AddressBookData(id, firstName, lastName, address, city, state, zip, phone, email));
    }

    public void writeAddressBookData(AddressBookService.IOService ioService) {
        if(ioService.equals(IOService.CONSOLE_IO))
            System.out.println("Writing AddressBook Details to Console "+addressBookDataList);
        else if(ioService.equals(IOService.FILE_IO))
            new AddressBook_IOService().writeData(addressBookDataList);
    }

    public long readAddressBookData(IOService ioService) {
        if(ioService.equals(IOService.FILE_IO))
            this.addressBookDataList = new AddressBook_IOService().readData();
        return addressBookDataList.size();
    }

    public void printData(IOService ioService) {
        if(ioService.equals(IOService.FILE_IO))
            new AddressBook_IOService().printData();
    }

    public long countEntries(IOService ioService) {
        if(ioService.equals(IOService.FILE_IO))
            return new AddressBook_IOService().countEntries();
        return 0;
    }
}
