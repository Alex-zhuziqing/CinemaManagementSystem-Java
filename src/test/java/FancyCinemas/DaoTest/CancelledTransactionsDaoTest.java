package FancyCinemas.DaoTest;

import FancyCinemas.Dao.CancelledTransactionsDao;
import FancyCinemas.Dao.impl.CancelledTransactionsDaoImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CancelledTransactionsDaoTest {
    CancelledTransactionsDao cancelledTransactionsDao = new CancelledTransactionsDaoImpl();

    @Test
    void insertCancelledTransaction() {
        assertTrue(cancelledTransactionsDao.insertCancelledTransaction("alex", "card payment failed"));
    }
}