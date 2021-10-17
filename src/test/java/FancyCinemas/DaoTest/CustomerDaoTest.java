package FancyCinemas.DaoTest;

import FancyCinemas.Dao.CustomerDao;
import FancyCinemas.Dao.impl.CustomerDaoImpl;
import FancyCinemas.Model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDaoTest {
    CustomerDao customerDao = new CustomerDaoImpl();

    @Test
    void insertNewCustomer() {
        Customer customer = new Customer("billy", "bbb123", null, null);
        assertTrue(customerDao.insertNewCustomer(customer));
    }

    @Test
    void getPassword() {
        assertNotNull(customerDao.getPassword("joe"));
    }

    @Test
    void getCardHolderName() {
        assertNotNull(customerDao.getCardHolderName("joe"));
    }

    @Test
    void setCardHolderName() {
        assertTrue(customerDao.setCardHolderName("joe", "Charles"));
    }

    @Test
    void getCreditCardNumber() {
        assertNotNull(customerDao.getCreditCardNumber("joe"));
    }

    @Test
    void setCreditCardNumber() {
        assertTrue(customerDao.setCreditCardNumber("joe", "40691"));
    }
}