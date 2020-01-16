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

import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class AddPromoFragment extends Fragment {
    private ImageView imageView;
    private EditText editTextNameSalon;
    private EditText editTextNamePromo;
    private EditText editTextOldPrise;
    private EditText editTextNewPrise;
    private EditText editTextDescN;
    private Button button;
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
        imageView = view.findViewById(R.id.imageViewAddPromo);
        editTextNameSalon = view.findViewById(R.id.editTextNamePSalonAddPromo);
        editTextNamePromo = view.findViewById(R.id.editTextNamePromoAddPromo);
        editTextOldPrise = view.findViewById(R.id.editTextOldPriseAddPromo);
        editTextNewPrise = view.findViewById(R.id.editTextNewPriseAddPromo);
        editTextDescN = view.findViewById(R.id.editTextDescNAddPromo);
        button = view.findViewById(R.id.buttonOkAddPromo);
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 mainActivity.showFragment(new KabinetSalonFragment());
             }
         });
    }
}