import java.util.Set;
import java.util.TreeMap;

public class PhoneBook {
    private TreeMap<String, String> phoneBookMap;

    public PhoneBook() {
        this.phoneBookMap = new TreeMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        phoneBookMap.put(name, phoneNumber);
    }

    public void deleteContact(String name) {
        phoneBookMap.remove(name);
    }

    public void updatePhoneNumber(String name, String newPhoneNumber) {
        phoneBookMap.put(name, newPhoneNumber);
    }

    public String searchPhoneNumber(String name) {
        return phoneBookMap.get(name);
    }

    public Set<String> getContactNames() {
        return phoneBookMap.keySet();
    }
}
