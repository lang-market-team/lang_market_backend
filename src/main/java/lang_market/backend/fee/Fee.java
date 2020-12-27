package lang_market.backend.fee;

public class Fee {
    Integer id_fee;
    Integer month_fee;
    Integer fee;
    Boolean paid_fee;
    Integer id_order;
    Integer id_seller;

    public Integer getId_fee() {
        return id_fee;
    }

    public void setId_fee(Integer id_fee) {
        this.id_fee = id_fee;
    }

    public Integer getMonth_fee() {
        return month_fee;
    }

    public void setMonth_fee(Integer month_fee) {
        this.month_fee = month_fee;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public Boolean getPaid_fee() {
        return paid_fee;
    }

    public void setPaid_fee(Boolean paid_fee) {
        this.paid_fee = paid_fee;
    }

    public Integer getId_order() {
        return id_order;
    }

    public void setId_order(Integer id_order) {
        this.id_order = id_order;
    }

    public Integer getId_seller() {
        return id_seller;
    }

    public void setId_seller(Integer id_seller) {
        this.id_seller = id_seller;
    }

    public Fee() {

    }
}
