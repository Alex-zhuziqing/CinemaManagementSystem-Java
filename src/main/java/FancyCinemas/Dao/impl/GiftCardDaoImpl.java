package FancyCinemas.Dao.impl;

import FancyCinemas.Dao.GiftCardDao;

public class GiftCardDaoImpl extends BaseDao implements GiftCardDao {
    private final String fileName = "src/main/resources/gift_cards.txt";

    public Boolean insertGiftCard(String cardNumber, Integer status) {
        String record = cardNumber + "/" + status;
        return insertNewRow(fileName, record);
    }

    public Boolean updateStatus(String cardNumber, Integer status) {
        return updateElement(fileName, cardNumber, 1, s -> status.toString());
    }
}
