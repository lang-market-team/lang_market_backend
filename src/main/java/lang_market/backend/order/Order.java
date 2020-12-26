package lang_market.backend.order;

public class Order {
    Integer id_order;
    Integer total_price;
    Integer status_order;
    Boolean paid_order;
    Long delivery_time;
    String delivery_address;
    Long create_time;
    Integer id_buyer;

    public Integer getId_order() {
        return id_order;
    }

    public void setId_order(Integer id_order) {
        this.id_order = id_order;
    }

    public Integer getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Integer total_price) {
        this.total_price = total_price;
    }

    public Integer getStatus_order() {
        return status_order;
    }

    public void setStatus_order(Integer status_order) {
        this.status_order = status_order;
    }

    public Boolean getPaid_order() {
        return paid_order;
    }

    public void setPaid_order(Boolean paid_order) {
        this.paid_order = paid_order;
    }

    public Long getDelivery_time() {
        return delivery_time;
    }

    public void setDelivery_time(Long delivery_time) {
        this.delivery_time = delivery_time;
    }

    public String getDelivery_address() {
        return delivery_address;
    }

    public void setDelivery_address(String delivery_address) {
        this.delivery_address = delivery_address;
    }

    public Long getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Long create_time) {
        this.create_time = create_time;
    }

    public Integer getId_buyer() {
        return id_buyer;
    }

    public void setId_buyer(Integer id_buyer) {
        this.id_buyer = id_buyer;
    }

    public Order() {

    }
}
