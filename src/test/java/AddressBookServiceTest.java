import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class AddressBookServiceTest {
    @Test
    public void givenAddressBookEntries_WhenWrittenToFile_ShouldMatchDataEntries() {
        AddressBookData[] addressBookData = {
                new AddressBookData(1,"Jeff","Bezos", "firstcross", "mumbai", "maharashtra", 620019, 9597231, "jeff@abc.com"),
                new AddressBookData(2,"Bill","Gates", "Secondcross", "bangalore", "karnataka", 400076, 998855, "bill@abc.com")

        };
        AddressBookService addressBookService;
        addressBookService = new AddressBookService(Arrays.asList(addressBookData));
        addressBookService.writeAddressBookData(AddressBookService.IOService.FILE_IO);
        addressBookService.printData(AddressBookService.IOService.FILE_IO);
        long entries = addressBookService.countEntries(AddressBookService.IOService.FILE_IO);
        Assert.assertEquals(2,entries);
    }
}
