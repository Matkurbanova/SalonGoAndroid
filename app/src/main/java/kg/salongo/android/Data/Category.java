package kg.salongo.android.Data;

public class Category {
    private String image;
    private String name;

    public Category(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public Category() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
