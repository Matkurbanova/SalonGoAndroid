package kg.salongo.android.View;

import android.content.Context;
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


import kg.salongo.android.Data.Service;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;



public class PersonalFragment extends Fragment {

    private Service service;

    private ImageView avatar;
    private TextView textViewNameSalon;
    private TextView textContacts;
    private TextView textAddress;
    private TextView textViewPhone;
    private TextView textWorkTime;
    private TextView Close;
    private TextView TextSubCat;
    private TextView TextPrice;
    private ImageView imageViewPersonal;
    private ImageView imageViewPersonal2;
    private ImageView imageLike;
    private ImageView imageLiked;
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
        return inflater.inflate(R.layout.personal_fragment, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        avatar = view.findViewById(R.id.avatar);
        textAddress = view.findViewById(R.id.textAddress);
        textViewNameSalon = view.findViewById(R.id.textViewNameSalon);
        textContacts = view.findViewById(R.id.textContacts);
        textViewPhone = view.findViewById(R.id.textViewPhone);
        textWorkTime = view.findViewById(R.id.textWorkTime);
        Close = view.findViewById(R.id.Close);
        TextSubCat = view.findViewById(R.id.TextSubCat);
        TextPrice = view.findViewById(R.id.TextPrice);
        imageViewPersonal = view.findViewById(R.id.imageViewPersonal);
        imageViewPersonal2 = view.findViewById(R.id.imageViewPersonal2);
        imageLike = view.findViewById(R.id.imageSave);
        imageLiked = view.findViewById(R.id.imageLiked);

        imageLike.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new AuthorizationFragment());

            }

        });


        imageViewInstaLogo = view.findViewById(R.id.imageViewInstaLogo);


//        Picasso.get().load(service.getImage())
//                .into(avatar);
        Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVtoeVcGG8cwoPtnLv95g6d9jj-vh9izm_vPtuzLZLPHKz77sQ&s").into(imageViewPersonal);
        Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSX6KRlgRZkZ3GI5OvXjjTfjr_xhv-oUsXP1tjbkvEp1HV_pzaKmw&s").into(imageViewPersonal2);
    }


    }





