package kg.salongo.android.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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

public class RegistrationMasterFragment extends Fragment {
    private MainActivity mainActivity;
    @BindView(R.id.imageView5)
    ImageView imageViewLogo;
    @BindView(R.id.imageViewPhotoMaster)
    ImageView imageViewPhon;
    @BindView(R.id.editTextLoginRegistrMaster)
    EditText editTextLogin;
    @BindView(R.id.editTextNameMaster)
    EditText editTextName;
    @BindView(R.id.editTextPhoneMaster)
    EditText editTextPhone;
    @BindView(R.id.editTextPasswordMaster)
    EditText editTextPass;
    @BindView(R.id.editText3)
    EditText editText;
    @BindView(R.id.buttonOk)
    Button buttonOk;
    @BindView(R.id.textViewSalon)
    TextView textViewSalon;
    @BindView(R.id.textViewPersonal)
    TextView textViewPersonal;
    @BindView(R.id.textViewSignIn)
    TextView textViewSignIn;

    private File selected;

    public RegistrationMasterFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
        MaskedEditText editTextPhone = new MaskedEditText.Builder(context)
                .mask("+996 (***) *** ***")
                .notMaskedSymbol("*")
                .build();
        ; //set mask to "8 (***) *** **-**" and not masked symbol to "*"
    }


    void loadRegisterMaster() {
        ApiRequests. registerMaster(
                editTextLogin.getText().toString(),
                editTextName.getText().toString(),
                editTextPass.getText().toString(),
                editTextPhone.getText().toString(),
                editText.getText().toString(),
                selected,
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
        return inflater.inflate(R.layout.fragment_registration_master, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        buttonOk.setOnClickListener(v -> loadRegisterMaster());
        textViewSalon.setOnClickListener(v -> mainActivity.showFragment(new RegistrationSalonFragment()));
        textViewPersonal.setOnClickListener(v -> mainActivity.showFragment(new RegistrationPersonalFragment()));
        textViewSignIn.setOnClickListener(v -> mainActivity.showFragment(new AuthorizationFragment()));
        imageViewPhon.setOnClickListener(v -> ImagePicker.create(this).single().start());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (ImagePicker.shouldHandle(requestCode, resultCode, data)) {
            Image image = ImagePicker.getFirstImageOrNull(data);
            String imgPath = image.getPath();
            selected = new File(imgPath);
            if (!selected.exists()) {
                selected = null;
            } else {
                Picasso.get().load(new File(imgPath)).into(imageViewPhon);
            }
            System.out.println("IMG PATH: " + imgPath);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
