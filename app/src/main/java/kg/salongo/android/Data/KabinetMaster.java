package kg.salongo.android.Data;

public class KabinetMaster {
    private String Image;
    private String NameService;
    public KabinetMaster(String Image, String nameService){
        this.Image=Image;
        this.NameService=nameService;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getImage() {
        return Image;
    }

    public String getNameService() {
        return NameService;
    }

    public void setNameService(String nameService) {
        NameService = nameService;
    }
}

