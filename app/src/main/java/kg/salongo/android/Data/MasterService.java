package kg.salongo.android.Data;

import android.os.AsyncTask;

import java.util.List;

public class MasterService {
    private int id;
    private String image;
    private String name;
    private String description;
    private String workExperienceYear;
    private List<Satus> status;
    private  String phone;

    public MasterService(
            String imageMaster, String name, String description, String workExperienceYear,
            List<Satus> status) {
        this.image = imageMaster;
        this.name = name;
        this.description = description;
        this.workExperienceYear = workExperienceYear;
        this.status = status;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExperienceYear() {
        return workExperienceYear;
    }

    public void setExperienceYear(String workExperienceYear) {
        this.workExperienceYear = workExperienceYear;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public List<Satus> getStatus() {
        return status;
    }

    public void setStatus(List<Satus> status) {
        this.status = status;
    }
}