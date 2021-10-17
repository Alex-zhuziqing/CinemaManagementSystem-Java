package FancyCinemas.Dao;

public interface CancelledTransactionsDao {
    public Boolean insertCancelledTransaction(String username, String reasons);
}
