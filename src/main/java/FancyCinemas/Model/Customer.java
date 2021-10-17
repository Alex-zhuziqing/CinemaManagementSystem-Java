package FancyCinemas.Model;

import FancyCinemas.Dao.CustomerDao;

public class Customer {
    private String username;
    private String password;
    private String cardholderName;
    private String creditCardNumber;

    public Customer() {
    }

    public Customer(String username, String password, String cardholderName, String creditCardNumber) {
        this.username = username;
        this.password = password;
        this.cardholderName = cardholderName;
        this.creditCardNumber = creditCardNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCardholderName() {
        return cardholderName;
    }

    public void setCardholderName(String cardholderName) {
        this.cardholderName = cardholderName;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    @Override
    public String toString() {
        return username + '/' + password + '/' + cardholderName + '/' + creditCardNumber;
    }
}
