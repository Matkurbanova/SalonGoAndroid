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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;
import kg.salongo.android.api.ApiRequests;
import kg.salongo.android.api.ApiResponse;
import kg.salongo.android.models.GoAddServise;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddServiceFragment extends Fragment {
    @BindView(R.id.mainImage)
    ImageView mainImage;
    @BindView(R.id.imageGallery)
    ImageView imageGallery;
    @BindView(R.id.imagePlus)
    ImageView imagePlus;
    @BindView(R.id.EditNameOfService)
    EditText EditNameOfService;
    @BindView(R.id.editPrice)
    EditText editPrice;
    @BindView(R.id.editDescription)
    EditText editDescription;
    @BindView(R.id.PhotoGalleryText)
    TextView PhotoGalleryText;
    @BindView(R.id.buttonSaveService)
    Button buttonSaveService;
    MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
    }

    void loadAddService() {
        ApiRequests.addService("","","",1,"",
                new Callback<ApiResponse<GoAddServise>>() {

                    @Override
                    public void onResponse(Call<ApiResponse<GoAddServise>> call, Response<ApiResponse<GoAddServise>> response) {
                        if (response.isSuccessful()) {
                            ApiResponse<GoAddServise> res = response.body();
                            if (res.getStatus() == 0) {
                                mainActivity.showFragment(new KabinetSalonFragment());
                                Toast.makeText(getContext(), "Failure", Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ApiResponse<GoAddServise>> call, Throwable t) {
                        t.printStackTrace();

                    }
                });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.addservice_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        buttonSaveService.setOnClickListener(v -> mainActivity.showFragment(new ServiceSalonFragment()));
    }
}
