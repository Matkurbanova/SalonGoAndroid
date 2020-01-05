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

import kg.salongo.android.Data.Service;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class MoreMasterFragment extends Fragment {
    private Service service;

    private ImageView avatar;
    private TextView textViewNameMaster;
    private TextView textContacts;
    private TextView textViewPhone;
    private TextView TextSubCat;
    private TextView TextPrice;
    private TextView textViewOpt;
    private TextView textViewyears;
    private ImageView imageViewPersonal;
    private ImageView imageViewPersonal2;
    private ImageView imageViewPersonal3;
    private ImageView imageViewPersonal4;
    private ImageView imageViewInstaLogo;
    private MainActivity mainActivity;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_more_master, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        avatar = view.findViewById(R.id.imageViewmaster);
        textViewNameMaster = view.findViewById(R.id.textViewnameMaster);
        textContacts = view.findViewById(R.id.textViewkantakty);
        textViewPhone = view.findViewById(R.id.textViewNumber);
        TextSubCat = view.findViewById(R.id.textViewNameService);
        TextPrice = view.findViewById(R.id.textViewPrice);
        imageViewInstaLogo = view.findViewById(R.id.imageViewinsLogo);
        textViewOpt = view.findViewById(R.id.textViewStaj);
        textViewyears = view.findViewById(R.id.textViewYears);
        imageViewPersonal=view.findViewById(R.id.imageViewMoreImage1);
        imageViewPersonal2=view.findViewById(R.id.imageViewMoreImage2);
        imageViewPersonal3=view.findViewById(R.id.imageViewMoreImage3);
        imageViewPersonal4=view.findViewById(R.id.imageView10);
    }


}


