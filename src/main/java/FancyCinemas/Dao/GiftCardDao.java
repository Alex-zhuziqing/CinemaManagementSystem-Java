package FancyCinemas.Dao;

public interface GiftCardDao {
    public Boolean insertGiftCard(String cardNumber, Integer status);
    public Boolean updateStatus(String cardNumber, Integer status);
}
