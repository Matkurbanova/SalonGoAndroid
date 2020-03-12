package kg.salongo.android.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.esafirm.imagepicker.features.ImagePicker;
import com.esafirm.imagepicker.model.Image;
import com.github.pinball83.maskededittext.MaskedEditText;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;
import kg.salongo.android.api.ApiRequests;
import kg.salongo.android.api.ApiResponse;
import kg.salongo.android.models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationSalonFragment extends Fragment {
    @BindView(R.id.imageViewLogoSalonGo)
    ImageView imageViewLogo;
    @BindView(R.id.imageView3)
    ImageView imageViewAvatar;
    @BindView(R.id.editTextTitel)
    EditText editTextTitle;
    @BindView(R.id.editTextLoginRegSalon)
    EditText editTextlogin;
    @BindView(R.id.editTextaddres)
    EditText editTextAddress;
    @BindView(R.id.editTextTel)
    EditText editTextTel;
    @BindView(R.id.editTextPass)
    EditText editTextPassword;
    @BindView(R.id.buttonOkSalon)
    Button buttonRegistr;
    @BindView(R.id.textViewZaregistrPers)
    TextView textViewZaregstr;
    @BindView(R.id.textViewVoiti)
    TextView textViewSign;
    private MainActivity mainActivity;
    private File select;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
        MaskedEditText editTextTel = new MaskedEditText.Builder(context)
                .mask("+996 (***) *** ***")
                .notMaskedSymbol("*")
                .build();
        ; //set mask to "8 (***) *** **-**" and not masked symbol to "*"
    }

    void loadRegisterSalon() {
        ApiRequests.registerSalon(
                editTextlogin.getText().toString(),
                editTextTitle.getText().toString(),
                editTextPassword.getText().toString(),
                editTextTel.getText().toString(),
                editTextAddress.getText().toString(),
                select,
                new Callback<ApiResponse<User>>() {
                    @Override
                    public void onResponse(Call<ApiResponse<User>> call, Response<ApiResponse<User>> response) {
                        if (response.isSuccessful()) {
                            ApiResponse<User> res = response.body();
                            if (res.getStatus() == 0) {
                                mainActivity.showFragment(new PersonalKabinetFragment());
                                Toast.makeText(getContext(), "Success", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            try {
                                System.err.println(response.errorBody().string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ApiResponse<User>> call, Throwable t) {
                        t.printStackTrace();
                    }
                });

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registration_salon, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this,view);
        buttonRegistr.setOnClickListener(v -> loadRegisterSalon());
        textViewZaregstr.setOnClickListener(v -> mainActivity.showFragment(new RegistrationPersonalFragment()));
        textViewSign.setOnClickListener(v -> mainActivity.showFragment(new KabinetSalonFragment()));

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (ImagePicker.shouldHandle(requestCode, resultCode, data)) {
            Image image = ImagePicker.getFirstImageOrNull(data);
            String imgPath = image.getPath();
            select = new File(imgPath);
            if (!select.exists()) {
                select = null;
            } else {
                Picasso.get().load(new File(imgPath)).into(imageViewAvatar);
            }
            System.out.println("IMG PATH: " + imgPath);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}


