package kg.salongo.android.View;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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

import com.synnapps.carouselview.CarouselView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kg.salongo.android.Data.Service;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class MoreMasterFragment extends Fragment {
    private Service service;

    @BindView(R.id.imageViewmaster)
    ImageView avatar;
    @BindView(R.id.textViewnameMaster)
    TextView textViewNameMaster;
    @BindView(R.id.textViewkantakty)
    TextView textContacts;
    @BindView(R.id.textViewNumber)
    TextView textViewPhone;
    @BindView(R.id.textViewNameService)
    TextView TextSubCat;
    @BindView(R.id.textViewPrice)
    TextView TextPrice;
    @BindView(R.id.textViewStaj)
    TextView textViewOpt;
    @BindView(R.id.textViewYears)
    TextView textViewyears;
    @BindView(R.id.imageViewinsLogo)
    ImageView imageViewInstaLogo;
    @BindView(R.id.buttonMoreService)
    Button buttonMore;
    @BindView(R.id.imageViewPhone)
    ImageView imageViewIconPhone;
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
         ButterKnife.bind(this, view);
        buttonMore.setOnClickListener(v -> mainActivity.showFragment(new MasterProfileFragment()));
        imageViewIconPhone.setOnClickListener(v -> {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:+996******"));
            startActivity(callIntent);
        });


    }


}


