package kg.salongo.android.Data;

import java.util.List;

public class Service {
    private int id;
    private String image;
    private String name;
    private String description;
    private String address;
    private List<WorkTime> workTimes;
    private String price;
    private String close;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClose() {
        return close;
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

    public String getname() {
        return name;
    }

    public void setname(String nameSalon) {
        this.name = nameSalon;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<WorkTime> getWorkTimes() {
        return workTimes;
    }

    public void setWorkTimes(List<WorkTime> workTime) {
        this.workTimes = workTime;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}