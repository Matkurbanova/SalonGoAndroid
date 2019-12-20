package kg.salongo.android.Data;

import android.widget.Button;

public class PersonalKabinet {
    private String image;
    private String nameSalon;
    private String nameSubCategory;
    private String address;
    private String workTime;
    private String price;
    private String close;
    private String links;

    public PersonalKabinet(
            String nameSalon, String nameSubCategory, String address, String workTime, String close,String price, String image) {
        this.nameSalon=nameSalon;
        this.nameSubCategory=nameSubCategory;
        this.address=address;
        this.workTime=workTime;
        this.price=price;
        this.image=image;
        this.close=close;
        this.links=links;
    }

    public String getClose() {
        return close;
    }
    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNameSalon() {
        return nameSalon;
    }

    public void setNameSalon(String nameSalon) {
        this.nameSalon = nameSalon;
    }

    public String getNameSubCategory() {
        return nameSubCategory;
    }

    public void setNameSubCategory(String nameSubCategory) {
        this.nameSubCategory = nameSubCategory;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
