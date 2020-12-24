package lang_market.backend.product;

public class Product {
    Integer id_product;
    Integer price;
    String product_name;
    String product_describe;
    Integer product_type;
    Double rating;
    Integer remain_amount;
    String product_image;
    Integer id_seller;

    public Integer getId_product() {
        return id_product;
    }

    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_describe() {
        return product_describe;
    }

    public void setProduct_describe(String product_describe) {
        this.product_describe = product_describe;
    }

    public Integer getProduct_type() {
        return product_type;
    }

    public void setProduct_type(Integer product_type) {
        this.product_type = product_type;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Integer getRemain_amount() {
        return remain_amount;
    }

    public void setRemain_amount(Integer remain_amount) {
        this.remain_amount = remain_amount;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public Integer getId_seller() {
        return id_seller;
    }

    public void setId_seller(Integer id_seller) {
        this.id_seller = id_seller;
    }

    public Product() {
    }
}
