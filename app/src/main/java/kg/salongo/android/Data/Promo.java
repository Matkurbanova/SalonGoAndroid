package kg.salongo.android.Data;

import android.media.Image;

public class Promo {


    private Double newPrice;
    private String promoDescription;
    private String productInfo;
    private String links;
    private Image PromoImage;
    private Image Liked;
    private Image PromoShare;
    public String textViewName;


    public Promo(
            Double newPrice, String promoDescription, String productInfo, String links, Image PromoImage,
            Image Liked, Image PromoShare,String textViewName) {
        this.newPrice = newPrice;
        this.promoDescription = promoDescription;
        this.productInfo = productInfo;
        this.links = links;
        this.PromoImage = PromoImage;
        this.Liked = Liked;
        this.PromoShare = PromoShare;
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

    public Image getLiked() {
        return Liked;
    }

    public void setLiked(Image liked) {
        Liked = liked;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public Image getPromoImage() {
        return PromoImage;
    }

    public void setPromoImage(Image promoImage) {
        PromoImage = promoImage;
    }

    public Image getPromoShare() {
        return PromoShare;
    }

    public void setPromoShare(Image promoShare) {
        PromoShare = promoShare;
    }

}



