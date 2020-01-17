package kg.salongo.android.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class AddPromoFragment extends Fragment {
    @BindView(R.id.imageViewAddPromo)
    ImageView imageView;
    @BindView(R.id.editTextNamePSalonAddPromo)
    EditText editTextNameSalon;
    @BindView(R.id.editTextNamePromoAddPromo)
    EditText editTextNamePromo;
    @BindView(R.id.editTextOldPriseAddPromo)
    EditText editTextOldPrise;
    @BindView(R.id.editTextNewPriseAddPromo)
     EditText editTextNewPrise;
    @BindView(R.id.editTextDescNAddPromo)
    EditText editTextDescN;
    @BindView(R.id.buttonOkAddPromo)
    Button button;
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
        return inflater.inflate(R.layout.fragment_add_promo, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        button.setOnClickListener(v -> mainActivity.showFragment(new KabinetSalonFragment()));
    }
}