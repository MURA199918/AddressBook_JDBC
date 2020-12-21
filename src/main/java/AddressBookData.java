public class AddressBookData {
    public int id;
    public String firstname;
    public String lastname;
    public String address;
    public String city;
    public String state;
    public long zip;
    public long phone;
    public String email;

    public AddressBookData(int id, String firstname, String lastname, String address, String city, String state, long zip, long phone, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public String toString() {
        return "AddressBookData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }
}
