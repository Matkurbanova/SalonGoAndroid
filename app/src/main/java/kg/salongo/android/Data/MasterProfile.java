package kg.salongo.android.Data;

public class MasterProfile {
    private String Image;
    private String description;
    public MasterProfile(String Image, String description){
        this.Image=Image;
        this.description=description;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getImage() {
        return Image;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
