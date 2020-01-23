package kg.salongo.android.models;

public class GoUser {
    /*
     {"id":2,"login":"matber03","password":"bema123","phone":"+996555555555","name":"Bermet","avatarimages":"avatarUser.png"}*/
    int id;
    String login;
    String phone;
    String name;
    String avatarimages;

    public String getAvatarimages() {
        return avatarimages;
    }

    public void setAvatarimages(String avatarimages) {
        this.avatarimages = avatarimages;
    }
}
