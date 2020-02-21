package kg.salongo.android.models;

public class User {
    private int id;
    private String login;
    private String name;
    private String password;
    private String phone;
    private String address;
    private String description;
    private String instaLogin;
    private String image;
    private int status;
    private int type;
    private String workExperienceYear;
    private String token;

    public User() {
    }

    // Simple user
//    public User(String login, String name,
//                String password, String phone, String image, String token) {
//        this.login = login;
//        this.name = name;
//        this.password = password;
//        this.phone = phone;
//        this.image = image;
//        this.token = token;
//    }

    public User(String login, String name,
                String password, String phone,
                String address, String image,
                String description, String instaLogin,
                int status, int type, String token) {
        this.login = login;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.image = image;
        this.description = description;
        this.instaLogin = instaLogin;
        this.status = status;
        this.type = type;
        this.token = token;
    }

    public User(String login, String name, String password, String phone, String workExperienceYear,
                String ImageMaster, String Description, String instaLogin, int type) {
        this.login = login;
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.workExperienceYear = workExperienceYear;
        this.image = ImageMaster;
        this.description = Description;
        this.instaLogin = instaLogin;
        this.type = type;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWorkExperienceYear() {
        return workExperienceYear;
    }

    public void setWorkExperienceYear(String workExperienceYear) {
        this.workExperienceYear = workExperienceYear;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInstaLogin() {
        return instaLogin;
    }

    public void setInstaLogin(String instaLogin) {
        this.instaLogin = instaLogin;
    }
}
