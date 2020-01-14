package kg.salongo.android.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import kg.salongo.android.Data.MasterService;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class OtherServicesMasterFragment  extends Fragment {
    private MasterService masterService;
private ImageView imageMaster;
private TextView NameMaster;
private  TextView MasterContacts;
private TextView WorkExperience;
private TextView WorkExperienceYear;
private  TextView Status;
private TextView StatusBusy;
private ImageView imagePhone;
private TextView textViewNumber;
private TextView textViewDescriptionMasters;
private TextView textViewMastersServices;
private ImageView imageViewServices1;
private ImageView imageViewServices2;
private ImageView imageVieInsMaster;
private MainActivity mainActivity;
private ImageView imageViewSeved;
private ImageView imageViewLike;
private ImageView imageViewShere;
private Button buttonServicesMaster;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
    }
     public void setMasterService(MasterService masterService) {
         this.masterService = masterService;
     }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_otherservicesmaster, container, false);


    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        imageMaster= view.findViewById(R.id.imageMaster);
        NameMaster = view.findViewById(R.id.NameMaster);
        WorkExperience = view.findViewById(R.id.WorkExperience);
        WorkExperienceYear = view.findViewById(R.id.WorkExperienceYear);
        Status = view.findViewById(R.id.Status);
        StatusBusy = view.findViewById(R.id.StatusBusy);
        imagePhone = view.findViewById(R.id.imagePhone);
        textViewDescriptionMasters = view.findViewById(R.id.textViewDescriptionMasters);
        textViewMastersServices = view.findViewById(R.id.textViewMastersService);
        imageViewServices1 = view.findViewById(R.id.imageViewService1);
        imageViewServices2 = view.findViewById(R.id.imageViewService2);
        imageVieInsMaster = view.findViewById(R.id.imageVieInsMaster);
        imageViewSeved=view.findViewById(R.id.imageViewSeved);
        imageViewLike=view.findViewById(R.id.imageViewLike);
        imageViewShere=view.findViewById(R.id.imageViewSeved);
        buttonServicesMaster=view.findViewById(R.id.buttonAddServicesMaster);
        buttonServicesMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new MasterProfileFragment());
            }
        });

        Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVtoeVcGG8cwoPtnLv95g6d9jj-vh9izm_vPtuzLZLPHKz77sQ&s").into(imageViewServices1);
        Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSX6KRlgRZkZ3GI5OvXjjTfjr_xhv-oUsXP1tjbkvEp1HV_pzaKmw&s").into(imageViewServices2);
    }


}