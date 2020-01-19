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

import butterknife.BindView;
import butterknife.ButterKnife;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class RegistrationPersonalFragment extends Fragment {

    @BindView(R.id.imageViewSalonGoLogo)
    ImageView imageViewLogo;
    private EditText editTextLogin;
    private EditText editTextName;
    private EditText editTextPassword;
    private MaskedEditText editTextTell;
    private TextView textViewZaregstr;
    private TextView signIn;
    private Button buttonSave;
    private MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
        MaskedEditText editTextTell = new MaskedEditText.Builder(context)
                .mask("+996 (***) *** ***")
                .notMaskedSymbol("*")
                .build();; //set mask to "8 (***) *** **-**" and not masked symbol to "*"
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        editTextName=view.findViewById(R.id.editTextNameRPF);
        editTextLogin=view.findViewById(R.id.editTextLoginRPF);
        editTextTell=view.findViewById(R.id.editTextTelRPF);
        editTextPassword=view.findViewById(R.id.editTextPasswordRPF);
        textViewZaregstr=view.findViewById(R.id.textViewZKSK);
        signIn=view.findViewById(R.id.textView2);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new AuthorizationFragment());
            }
        });
        buttonSave=view.findViewById(R.id.buttonOkRPF);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new PersonalKabinetFragment());

            }
        });
        textViewZaregstr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new RegistrationSalonFragment());
            }
        });
    }



}
