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

public class RegistrationSalonFragment extends Fragment {
    private ImageView imageViewLogo;
    private ImageView imageViewAvatar;
    private EditText editTextTitle;
    private  EditText editTextlogin;
    private EditText editTextAddress;
    private EditText editTextTel;
    private EditText editTextPassword;
    private Button buttonRegistr;
    private TextView textViewZaregstr;
    private TextView textViewSign;
    private MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
        MaskedEditText editTextTel = new MaskedEditText.Builder(context)
                .mask("+996 (***) *** ***")
                .notMaskedSymbol("*")
                .build();; //set mask to "8 (***) *** **-**" and not masked symbol to "*"
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registration_salon, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        imageViewLogo=view.findViewById(R.id.imageViewLogoSalonGo);
        imageViewAvatar=view.findViewById(R.id.imageView3);
        editTextTitle=view.findViewById(R.id.editTextTitel);
        editTextlogin=view.findViewById(R.id.editTextLoginRegSalon);
        editTextAddress=view.findViewById(R.id.editTextaddres);
        editTextTel=view.findViewById(R.id.editTextTel);
        editTextPassword=view.findViewById(R.id.editTextPass);
        buttonRegistr=view.findViewById(R.id.buttonOkSalon);
        buttonRegistr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new KabinetSalonFragment());
            }
        });
        textViewZaregstr=view.findViewById(R.id.textViewZaregistrPers);
        textViewZaregstr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new RegistrationPersonalFragment());
            }
        });
        textViewSign=view.findViewById(R.id.textViewVoiti);
        textViewSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new KabinetSalonFragment());
            }
        });

    }

}
