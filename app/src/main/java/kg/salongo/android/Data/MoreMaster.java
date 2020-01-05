package kg.salongo.android.Data;

public class MoreMaster {
    private String Image;
    private String Number;
    private String description;

    public MoreMaster(String Image, String Number, String description) {
        this.Image = Image;
        this.Number = Number;
        this.description = description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

