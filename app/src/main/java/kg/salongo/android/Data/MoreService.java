package kg.salongo.android.Data;

public class MoreService {
    private String NameService;
    private String ImageService;

    public MoreService(String NameService, String ImageService) {

        this.ImageService = ImageService;
        this.NameService = NameService;
    }

    public String getNameService() {
        return NameService;
    }

    public void setNameService(String nameService) {
        NameService = nameService;
    }

    public String getImageService() {
        return ImageService;
    }

    public void setImageService(String imageService) {
        ImageService = imageService;
    }
}

