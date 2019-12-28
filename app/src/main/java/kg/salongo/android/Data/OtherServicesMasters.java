package kg.salongo.android.Data;

import android.widget.ImageView;
import android.widget.TextView;

public class OtherServicesMasters {
    private TextView nameMaster;
    private TextView number;
    private TextView workExperienceYear;
    private TextView statusBusy;
    private TextView statusFree;
    private TextView description;
    private ImageView imageViewService1;
    private ImageView imageViewService2;
    public OtherServicesMasters(TextView nameMaster,TextView number,
                                TextView workExperienceYear,TextView statusFree,TextView statusBusy,TextView description,ImageView imageViewService1,ImageView imageViewService2){
        this.nameMaster = nameMaster;
        this.number=number;
        this.workExperienceYear=workExperienceYear;
        this.statusFree=statusFree;
        this.statusBusy=statusBusy;
        this.description=description;
        this.imageViewService1=imageViewService1;
        this.imageViewService2=imageViewService2;

    }

    public TextView getNumber() {
        return number;
    }

    public void setNumber(TextView number) {
        this.number = number;
    }

    public void setNameMaster(TextView nameMaster) {
        this.nameMaster = nameMaster;
    }

    public TextView getNameMaster() {
        return nameMaster;
    }

    public void setWorkExperienceYear(TextView workExperienceYear) {
        this.workExperienceYear = workExperienceYear;
    }

    public TextView getWorkExperienceYear() {
        return workExperienceYear;
    }

    public void setStatusFree(TextView statusFree) {
        this.statusFree = statusFree;
    }

    public void setStatusBusy(TextView statusBusy) {
        this.statusBusy = statusBusy;
    }

    public TextView getStatusBusy() {
        return statusBusy;
    }

    public TextView getStatusFree() {
        return statusFree;
    }

    public TextView getDescription() {
        return description;
    }

    public void setDescription(TextView description) {
        this.description = description;
    }

    public ImageView getImageViewService1() {
        return imageViewService1;
    }

    public void setImageViewService1(ImageView imageViewService1) {
        this.imageViewService1 = imageViewService1;
    }

    public ImageView getImageViewService2() {
        return imageViewService2;
    }

    public void setImageViewService2(ImageView imageViewService2) {
        this.imageViewService2 = imageViewService2;
    }
}
