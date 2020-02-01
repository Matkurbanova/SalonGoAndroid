package kg.salongo.android.Data;

public class Promo {

private int id;
    private String newPrice;
    private String promoDescription;
    private String productInfo;
    private String links;
    private String promoImage;
    private String textViewName;
private String oldPrice;
    public Promo(
            String newPrice, String promoDescription, String productInfo, String links, String PromoImage,
            String textViewName,String oldPrice) {
        this.newPrice = newPrice;
        this.promoDescription = promoDescription;
        this.productInfo = productInfo;
        this.links = links;
        this.promoImage = PromoImage;
        this.textViewName=textViewName;
        this.oldPrice=oldPrice;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTextViewName() {
        return textViewName;
    }

    public void setTextViewName(String textViewName) {
        this.textViewName = textViewName;
    }

    public String getPromoImage() {
        return promoImage;
    }

    public void setPromoImage(String promoImage) {
        this.promoImage = promoImage;
    }

    public String getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(String newPrice) {
        this.newPrice = newPrice;
    }

    public String getPromoDescription() {
        return promoDescription;
    }

    public void setPromoDescription(String promoDescription) {
        this.promoDescription = promoDescription;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }


    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public String getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }
}
