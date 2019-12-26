package kg.salongo.android.Data;

public class MasterService {
    private String imageMaster;
    private String NameMaster;
    private String nameofService;

    private String experienceYear;
    private String statusFree;
    private String statusBusy;

    public MasterService(
            String imageMaster, String NameMaster, String nameofService, String workExperienceYear,
            String statusFree, String statusBusy) {
        this.imageMaster = imageMaster;
        this.NameMaster = NameMaster;
        this.nameofService = nameofService;
        this.experienceYear = experienceYear;
        this.statusFree = statusFree;
        this.statusBusy = statusBusy;
    }

    public String getImageMaster() {
        return imageMaster;
    }

    public void setImageMaster(String imageMaster) {
        this.imageMaster = imageMaster;
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