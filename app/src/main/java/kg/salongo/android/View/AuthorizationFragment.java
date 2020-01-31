package kg.salongo.android.View;

import android.content.Context;
import android.content.SharedPreferences;
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

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;
import kg.salongo.android.api.ApiRequests;
import kg.salongo.android.api.ApiResponse;
import kg.salongo.android.models.GoUser;
import kg.salongo.android.utils.PrefHelp;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthorizationFragment extends Fragment {
    @BindView(R.id.imageViewLogoSalonGo)
    ImageView imageViewLogoSalonGo;
    @BindView(R.id.editTextLogin)
    EditText editTextLogin;
    @BindView(R.id.editTextPassword)
    EditText editTextPassword;
    @BindView(R.id.buttonOK)
    Button buttonOk;
    @BindView(R.id.textViewRegistration)
    TextView textViewRegistration;
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
        ButterKnife.bind(this, view);
//        buttonOk.setOnClickListener(v -> mainActivity.showFragment(new CategoryFragment()));
        textViewRegistration.setOnClickListener(v -> mainActivity.showFragment(new RegistrationPersonalFragment(), false));
    }

    @OnClick(R.id.buttonOK)
    public void onOkClick(View v) {
        String login = editTextLogin.getText().toString();
        String password = editTextPassword.getText().toString();
        ApiRequests.login(login, password, new Callback<ApiResponse<GoUser>>() {
            @Override
            public void onResponse(Call<ApiResponse<GoUser>> call, Response<ApiResponse<GoUser>> response) {
                if (response.isSuccessful()) {
                    ApiResponse<GoUser> res = response.body();
                    if (res.getStatus() == 0) {
                        Picasso.get().load(ApiRequests.IMAGES + res.getData().getAvatarimages())
                                .into(imageViewLogoSalonGo);

                        mainActivity.showFragment(new CategoryFragment());
                        PrefHelp.edit().putBoolean("isLoggedIn", true);
                        PrefHelp.edit().putString("token", res.getData().getToken());
                    } else {
                        Toast.makeText(getContext(), res.getMessage(), Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Failure", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<ApiResponse<GoUser>> call, Throwable t) {
                Toast.makeText(getContext(), "Failure", Toast.LENGTH_LONG).show();
                t.printStackTrace();
            }
        });
    }
}
