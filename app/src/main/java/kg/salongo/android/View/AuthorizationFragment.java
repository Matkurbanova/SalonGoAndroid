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

import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class AuthorizationFragment extends Fragment {
    private ImageView imageViewLogoSalonGo;
    private EditText editTextLogin;
    private EditText editTextPassword;
    private Button buttonOk;
    private TextView textViewRegistration;
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
        return inflater.inflate(R.layout.fragment_personalauthorization, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        imageViewLogoSalonGo = view.findViewById(R.id.imageViewLogoSalonGo);
        editTextLogin = view.findViewById(R.id.editTextLogin);
        editTextPassword = view.findViewById(R.id.editTextPassword);
        buttonOk = view.findViewById(R.id.buttonOK);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new CategoryFragment());
            }
        });

        textViewRegistration = view.findViewById(R.id.textViewRegistration);
        textViewRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new RegistrationPersonalFragment(), false);
            }
        });
    }
}
