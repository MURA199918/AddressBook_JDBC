import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AddressBook_IOService {
    public static String ADDRESS_FILE_NAME = "address-file.txt";

    public void writeData(List<AddressBookData> addressBookDataList) {
        StringBuffer empBuffer = new StringBuffer();
        addressBookDataList.forEach(addressBookData ->{
            String addressDataString = addressBookData.toString().concat("\n");
            empBuffer.append(addressDataString);
        });

        try {
            Files.write(Paths.get(ADDRESS_FILE_NAME), empBuffer.toString().getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void printData() {
        try{
            Files.lines(new File(ADDRESS_FILE_NAME).toPath()).forEach(System.out::println);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public long countEntries() {
        long entries = 0;
        try{
            entries = Files.lines(new File(ADDRESS_FILE_NAME).toPath())
                    .count();
        }catch (IOException e){
            e.printStackTrace();
        }
        return entries;
    }

    public List<AddressBookData> readData(){
        List<AddressBookData> addressBookDataList = new ArrayList<>();
        try{
            Files.lines(new File(ADDRESS_FILE_NAME).toPath())
                    .map(line->line.trim())
                    .forEach(line->System.out.println(line));
        }catch (IOException e){
            e.printStackTrace();
        }
        return addressBookDataList;
    }

}
