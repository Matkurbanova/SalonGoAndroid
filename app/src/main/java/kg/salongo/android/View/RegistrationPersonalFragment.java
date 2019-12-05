package kg.salongo.android.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import kg.salongo.android.R;

public class RegistrationPersonalFragment extends Fragment {

    private ImageView imageViewLogo;
    private EditText editTextLogin;
    private EditText editTextName;
    private EditText editTextPassword;
    private EditText editTextTell;
    private TextView textViewZaregstr;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        imageViewLogo=view.findViewById(R.id.imageViewLogoSalonGo);
        editTextName=view.findViewById(R.id.editTextNameRPF);
        editTextLogin=view.findViewById(R.id.editTextLoginRPF);
        editTextTell=view.findViewById(R.id.editTextTelRPF);
        editTextPassword=view.findViewById(R.id.editTextPasswordRPF);
        textViewZaregstr=view.findViewById(R.id.textViewZKSK);
    }



}
