package FancyCinemas.Model;

public class SizePricePair {
    private String size;
    private Integer price;

    public SizePricePair(String size, Integer price) {
        this.size = size;
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return size + "#" + price;
    }
}
