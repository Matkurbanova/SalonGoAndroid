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

import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class TypeFragment extends Fragment {
    private TextView textViewText;
    private ImageView imageViewLogo;
    private Button buttonPersonal;
    private Button buttonSalon;
    private Button  buttonMaster;
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
        return inflater.inflate(R.layout.fragment_type, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        textViewText=view.findViewById(R.id.textViewtext);
        imageViewLogo=view.findViewById(R.id.imageView);
        buttonPersonal=view.findViewById(R.id.buttonPersonal);
        buttonPersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new RegistrationPersonalFragment());
            }
        });
        buttonSalon=view.findViewById(R.id.buttonSalon);
        buttonSalon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new RegistrationSalonFragment());
            }
        });
        buttonMaster=view.findViewById(R.id.buttonMaster);
        buttonMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new RegistrationMasterFragment());
            }
        });
}}
