package kg.salongo.android.View;

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

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registration_salon, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        imageViewLogo=view.findViewById(R.id.imageViewLogoSalonGo);
        imageViewAvatar=view.findViewById(R.id.imageViewPrAvatar);
        editTextTitle=view.findViewById(R.id.editTextTitel);
        editTextlogin=view.findViewById(R.id.editTextLoginRegSalon);
        editTextAddress=view.findViewById(R.id.editTextaddres);
        editTextTel=view.findViewById(R.id.editTextTel);
        editTextPassword=view.findViewById(R.id.editTextPass);
        buttonRegistr=view.findViewById(R.id.buttonOkSalon);
        textViewZaregstr=view.findViewById(R.id.textViewZaregistrPers);
        textViewSign=view.findViewById(R.id.textViewVoiti);
    }

}
