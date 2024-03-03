import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class PhoneBookController {

    @FXML
    private ListView<String> contactListView;

    @FXML
    private TextField nameInput;

    @FXML
    private TextField phoneNumberInput;

    private PhoneBook phoneBook = new PhoneBook();
    private ObservableList<String> contactNames = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        contactListView.setItems(contactNames);
    }

    @FXML
    private void addContact() {
        String name = nameInput.getText();
        String phoneNumber = phoneNumberInput.getText();
        phoneBook.addContact(name, phoneNumber);
        updateContactList();
    }

    @FXML
    private void deleteContact() {
        String selectedName = contactListView.getSelectionModel().getSelectedItem();
        if (selectedName != null) {
            phoneBook.deleteContact(selectedName);
        }
        updateContactList();
    }

    @FXML
    private void updatePhoneNumber() {
        String selectedName = contactListView.getSelectionModel().getSelectedItem();
        if (selectedName != null) {
            String newPhoneNumber = phoneNumberInput.getText();
            phoneBook.updatePhoneNumber(selectedName, newPhoneNumber);
        }
        updateContactList();
    }

    @FXML
    private void searchPhoneNumber() {
        String nameToSearch = nameInput.getText();
        String phoneNumber = phoneBook.searchPhoneNumber(nameToSearch);
        if (phoneNumber != null) {
            phoneNumberInput.setText(phoneNumber);
        } else {
            phoneNumberInput.clear();
            showAlert("Contact not found!", Alert.AlertType.WARNING);
        }
    }

    private void updateContactList() {
        contactNames.setAll(phoneBook.getContactNames());
    }

    private void showAlert(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setContentText(message);
        alert.show();
    }
}
