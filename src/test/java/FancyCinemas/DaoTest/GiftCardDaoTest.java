package FancyCinemas.DaoTest;

import FancyCinemas.Dao.GiftCardDao;
import FancyCinemas.Dao.impl.GiftCardDaoImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GiftCardDaoTest {
    GiftCardDao giftCardDao = new GiftCardDaoImpl();

    @Test
    void insertGiftCard() {
        assertTrue(giftCardDao.insertGiftCard("GX11111111777777", 1));
    }

    @Test
    void updateStatus() {
        assertTrue(giftCardDao.updateStatus("GX11111111777777", 0));
    }
}