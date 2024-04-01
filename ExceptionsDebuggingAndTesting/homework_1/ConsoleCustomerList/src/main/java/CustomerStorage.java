import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CustomerStorage {
    private final Map<String, Customer> storage;
    private static final Logger LOGGER = LogManager.getLogger(CustomerStorage.class);

    public CustomerStorage() {
        storage = new ConcurrentHashMap<>();
    }

    public CustomerStorage(Map<String, Customer> customers) {
        storage = new ConcurrentHashMap<>(customers);
    }

    public void addCustomer(String data) throws InvalidEmailFormat, InvalidPhoneNumberFormat, InvalidDataFormat {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;
        final int COMPONENTS = 4;

        String[] components = data.split("\\s+");
        if (components.length != COMPONENTS) {
            throw new InvalidDataFormat("Данные введены неверно");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        if (!isValidPhoneNumber(components[INDEX_PHONE])) {
            throw new InvalidPhoneNumberFormat("неверный формат номера телефона");
        }
        if (!isValidEmail(components[INDEX_EMAIL])) {
            throw new InvalidEmailFormat("неверный формат email");
        }
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    private boolean isValidPhoneNumber(String phone) {
        return phone.matches("^\\+?[7-8][0-9]{10}");
    }

    private boolean isValidEmail(String email) {
        return email.matches(".+@.+\\..+");
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}