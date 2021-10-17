package FancyCinemas.Dao;

import FancyCinemas.Model.Customer;

public interface CustomerDao {
    public Boolean insertNewCustomer(Customer customer);
    public String getPassword(String username);
    public String getCardHolderName(String username);
    public Boolean setCardHolderName(String username, String cardHolderName);
    public String getCreditCardNumber(String username);
    public Boolean setCreditCardNumber(String username, String creditCardNumber);
}
