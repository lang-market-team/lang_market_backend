package lang_market.backend.user;

public class User {
    Integer id_user;
    String username;
    String pass;
    String first_name;
    String last_name;
    String street;
    String town;
    String district;
    String province;
    String phonenumber;
    String email;
    Integer type_account;
    Boolean status_user;
    String shop_name;
    String shop_describe;

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getType_account() {
        return type_account;
    }

    public void setType_account(Integer type_account) {
        this.type_account = type_account;
    }

    public Boolean getStatus_user() {
        return status_user;
    }

    public void setStatus_user(Boolean status_user) {
        this.status_user = status_user;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getShop_describe() {
        return shop_describe;
    }

    public void setShop_describe(String shop_describe) {
        this.shop_describe = shop_describe;
    }

    public User() {
    }
}
