package kg.salongo.android.models;

public class GoAddServise {
    String token;
    String Price;
    String Description;
    int subCategoryI;
    String Image;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getSubCategoryI() {
        return subCategoryI;
    }

    public void setSubCategoryI(int subCategoryI) {
        this.subCategoryI = subCategoryI;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }
}

