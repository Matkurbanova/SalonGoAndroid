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


import kg.salongo.android.Data.MoreService;
import kg.salongo.android.Data.Service;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;


public class MoreSalonFragment extends Fragment {

    private Service service;

    private ImageView avatar;
    private TextView textViewNameSalon;
    private ImageView imageViewIconInst;
    private ImageView imageViewIconTell;
    private TextView textAddress;
    private TextView textViewPhone;
    private TextView textWorkTime;
    private TextView Close;
    private TextView TextSubCat;
    private TextView TextPrice;
    private ImageView imageViewPersonal;
    private ImageView imageViewPersonal2;
    private ImageView imageLike;
    private Button buttonMoreServiceSalon;
    private TextView textViewDesN;
    private ImageView imageSave;
    private ImageView imageViewInstaLogo;
    private MainActivity mainActivity;

    // private CarouselView carouselView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
    }


    public void setService(Service service) {
        this.service = service;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_more_salon, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        avatar = view.findViewById(R.id.avatar);
        textAddress = view.findViewById(R.id.textAddress);
        textViewNameSalon = view.findViewById(R.id.textViewNameMAster);
        textViewPhone = view.findViewById(R.id.textViewPhone);
        textWorkTime = view.findViewById(R.id.textWorkTime);
        Close = view.findViewById(R.id.Close);
        TextSubCat = view.findViewById(R.id.TextSubCat);
        TextPrice = view.findViewById(R.id.TextPrice);
        textViewDesN=view.findViewById(R.id.textViewDeN);
        imageViewIconInst = view.findViewById(R.id.imageViewInstIcon);
        imageViewIconTell = view.findViewById(R.id.imageViewPhoneIcon);
        imageViewPersonal = view.findViewById(R.id.imageViewPersonal);
        imageViewPersonal2 = view.findViewById(R.id.imageViewPersonal2);
        buttonMoreServiceSalon = view.findViewById(R.id.buttonMoreServiceSalon);
        buttonMoreServiceSalon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new MoreServiceFragment());
            }
        });
        imageLike = view.findViewById(R.id.imageSave);


        imageLike.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new AuthorizationFragment());

            }

        });
//        Picasso.get().load(service.getImage())
//                .into(avatar);
        Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVtoeVcGG8cwoPtnLv95g6d9jj-vh9izm_vPtuzLZLPHKz77sQ&s").into(imageViewPersonal);
        Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSX6KRlgRZkZ3GI5OvXjjTfjr_xhv-oUsXP1tjbkvEp1HV_pzaKmw&s").into(imageViewPersonal2);
    }


}





