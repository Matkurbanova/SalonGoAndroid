package kg.salongo.android.Data;

public class Promo {


    private Double newPrice;
    private String promoDescription;
    private String productInfo;
    private String links;
    private String promoImage;
    public String textViewName;

    public Promo(
            Double newPrice, String promoDescription, String productInfo, String links, String PromoImage,
            String textViewName) {
        this.newPrice = newPrice;
        this.promoDescription = promoDescription;
        this.productInfo = productInfo;
        this.links = links;
        this.promoImage = PromoImage;
        this.textViewName=textViewName;
    }

    public String getTextViewName() {
        return textViewName;
    }

    public void setTextViewName(String textViewName) {
        this.textViewName = textViewName;
    }

    public Double getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(Double newPrice) {
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


}



