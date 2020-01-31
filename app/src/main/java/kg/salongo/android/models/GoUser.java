package kg.salongo.android.models;

public class GoUser {
    /*
     {"id":2,"login":"matber03","password":"bema123","phone":"+996555555555","name":"Bermet","avatarimages":"avatarUser.png"}*/
    int id;
    String login;
    String phone;
    String name;
    String avatarimages;
    String token;

    public String getAvatarimages() {
        return avatarimages;
    }

    public void setAvatarimages(String avatarimages) {
        this.avatarimages = avatarimages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
