package kg.salongo.android.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.pinball83.maskededittext.MaskedEditText;

import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class RegistrationMasterFragment extends Fragment {
    private ImageView imageViewLogo;
    private ImageView imageViewPhon;
    private EditText editTextName;
    private EditText editTextPhone;
    private EditText editTextPass;
    private EditText editText;
    private Button buttonOk;
    private TextView textViewSalon;
    private TextView textViewPersonal;
    private TextView textViewSignIn;
    private MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
        MaskedEditText editTextPhone = new MaskedEditText.Builder(context)
                .mask("+996 (***) *** ***")
                .notMaskedSymbol("*")
                .build();; //set mask to "8 (***) *** **-**" and not masked symbol to "*"
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registration_master, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        imageViewLogo = view.findViewById(R.id.imageView5);
        imageViewPhon = view.findViewById(R.id.imageViewPhotoMaster);
        editTextName = view.findViewById(R.id.editTextNameMaster);
        editTextPhone = view.findViewById(R.id.editTextPhoneMaster);
        editTextPass = view.findViewById(R.id.editTextPasswordMaster);
        editText = view.findViewById(R.id.editText3);
        buttonOk = view.findViewById(R.id.buttonOk);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new KabinetMasterFragment());

            }
        });
        textViewSalon = view.findViewById(R.id.textViewSalon);
        textViewSalon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new RegistrationSalonFragment());
            }
        });
        textViewPersonal = view.findViewById(R.id.textViewPersonal);
        textViewPersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new RegistrationPersonalFragment());
            }
        });
        textViewSignIn = view.findViewById(R.id.textViewSignIn);
        textViewSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new AuthorizationFragment());
            }
        });


    }
}
