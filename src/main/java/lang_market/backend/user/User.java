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

    public Integer getId_user() {
        return id_user;
    }

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getStreet() {
        return street;
    }

    public String getTown() {
        return town;
    }

    public String getDistrict() {
        return district;
    }

    public String getProvince() {
        return province;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public User(Integer id_user, String username, String pass, String first_name, String last_name, String street, String town, String district, String province, String phonenumber, String email) {
        this.id_user = id_user;
        this.username = username;
        this.pass = pass;
        this.first_name = first_name;
        this.last_name = last_name;
        this.street = street;
        this.town = town;
        this.district = district;
        this.province = province;
        this.phonenumber = phonenumber;
        this.email = email;
    }
}
