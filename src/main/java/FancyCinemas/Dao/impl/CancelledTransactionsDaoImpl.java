package FancyCinemas.Dao.impl;

import FancyCinemas.Dao.CancelledTransactionsDao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CancelledTransactionsDaoImpl extends BaseDao implements CancelledTransactionsDao {
    private final String fileName = "src/main/resources/cancelled_transactions.txt";

    public Boolean insertCancelledTransaction(String username, String reasons) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String now = dateTimeFormatter.format(LocalDateTime.now());
        String record = now + "/" + username + "/" + reasons;
        return insertNewRow(fileName, record);
    }
}
