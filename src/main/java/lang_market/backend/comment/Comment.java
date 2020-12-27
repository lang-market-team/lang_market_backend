package lang_market.backend.comment;

public class Comment {
    Integer id_comment;
    Integer id_product;
    Integer id_buyer;
    String first_name;
    String last_name;
    String content_comment;
    Long time_create;
    Double rating_comment;

    public Integer getId_comment() {
        return id_comment;
    }

    public void setId_comment(Integer id_comment) {
        this.id_comment = id_comment;
    }

    public Integer getId_product() {
        return id_product;
    }

    public void setId_product(Integer id_product) {
        this.id_product = id_product;
    }

    public Integer getId_buyer() {
        return id_buyer;
    }

    public void setId_buyer(Integer id_buyer) {
        this.id_buyer = id_buyer;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getContent_comment() {
        return content_comment;
    }

    public void setContent_comment(String content_comment) {
        this.content_comment = content_comment;
    }

    public Long getTime_create() {
        return time_create;
    }

    public void setTime_create(Long time_create) {
        this.time_create = time_create;
    }

    public Double getRating_comment() {
        return rating_comment;
    }

    public void setRating_comment(Double rating_comment) {
        this.rating_comment = rating_comment;
    }

    public Comment() {

    }
}
