package kg.salongo.android.Data;

public class MasterService {
    private int id;
    private String image;
    private String NameMaster;
    private String nameofService;
    private String experienceYear;
    private String statusFree;
    private String statusBusy;

    public MasterService(
            String imageMaster, String NameMaster, String nameofService, String workExperienceYear,
            String statusFree, String statusBusy) {
        this.image = imageMaster;
        this.NameMaster = NameMaster;
        this.nameofService = nameofService;
        this.experienceYear = experienceYear;
        this.statusFree = statusFree;
        this.statusBusy = statusBusy;
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



    public String getNameofService() {
        return nameofService;
    }

    public void setNameofService(String nameofService) {
        this.nameofService = nameofService;
    }

    public String getExperienceYear() {
        return experienceYear;
    }

    public void setExperienceYear(String experienceYear) {
        this.experienceYear = experienceYear;
    }

    public String getNameMaster() {
        return NameMaster;
    }

    public void setNameMaster(String nameMaster) {
        NameMaster = nameMaster;
    }

    public String getStatusFree() {
        return statusFree;
    }

    public void setStatusFree(String statusFree) {
        this.statusFree = statusFree;
    }

    public String getStatusBusy() {
        return statusBusy;
    }

    public void setStatusBusy(String statusBusy) {
        this.statusBusy = statusBusy;
    }
}