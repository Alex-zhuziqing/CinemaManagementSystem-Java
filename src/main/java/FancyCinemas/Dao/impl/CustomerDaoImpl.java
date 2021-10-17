package FancyCinemas.Dao.impl;

import FancyCinemas.Dao.CustomerDao;
import FancyCinemas.Model.Customer;

public class CustomerDaoImpl extends BaseDao implements CustomerDao {
    private final String fileName = "src/main/resources/customers.txt";

    @Override
    public Boolean insertNewCustomer(Customer customer) {
        return insertNewRow(fileName, customer.toString());
    }

    @Override
    public String getPassword(String username) {
        return getElementField(fileName, 0, username, 1);
    }

    @Override
    public String getCardHolderName(String username) {
        return getElementField(fileName, 0, username, 2);
    }

    @Override
    public Boolean setCardHolderName(String username, String cardHolderName) {
        return updateElement(fileName, username, 2, s->cardHolderName);
    }

    @Override
    public String getCreditCardNumber(String username) {
        return getElementField(fileName, 0, username, 3);
    }

    @Override
    public Boolean setCreditCardNumber(String username, String creditCardNumber) {
        return updateElement(fileName, username, 3, s->creditCardNumber);
    }
}
