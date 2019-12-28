package kg.salongo.android.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

import kg.salongo.android.R;

public class OtherServicesMasterFragment  extends Fragment {
private ImageView imageMaster;
private TextView NameMaster;
private  TextView MasterContacts;
private TextView WorkExperience;
private TextView WorkExperienceYear;
private  TextView Status;
private TextView StatusFree;
private TextView StatusBusy;
private TextView imagePhone;
private TextView textViewNumber;
private TextView textViewDescriptionMasters;
private TextView textViewMastersServices;
private ImageView imageViewServices1;
private ImageView imageViewServices2;
private ImageView imageVieInsMaster;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_otherservicesmaster, container, false);


    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        imageMaster= view.findViewById(R.id.imageMaster);
        NameMaster = view.findViewById(R.id.NameMaster);
        MasterContacts = view.findViewById(R.id.MasterContacts);
        WorkExperience = view.findViewById(R.id.WorkExperience);
        WorkExperienceYear = view.findViewById(R.id.WorkExperienceYear);
        Status = view.findViewById(R.id.Status);
        StatusBusy = view.findViewById(R.id.StatusBusy);
        StatusFree = view.findViewById(R.id.StatusFree);
        imagePhone = view.findViewById(R.id.imagePhone);
        textViewDescriptionMasters = view.findViewById(R.id.textViewDescriptionMasters);
        textViewMastersServices = view.findViewById(R.id.textViewMastersService);
        imageViewServices1 = view.findViewById(R.id.imageViewService1);
        imageViewServices2 = view.findViewById(R.id.imageViewService2);
        imageVieInsMaster = view.findViewById(R.id.imageVieInsMaster);

        Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVtoeVcGG8cwoPtnLv95g6d9jj-vh9izm_vPtuzLZLPHKz77sQ&s").into(imageViewServices1);
        Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSX6KRlgRZkZ3GI5OvXjjTfjr_xhv-oUsXP1tjbkvEp1HV_pzaKmw&s").into(imageViewServices2);
    }


}