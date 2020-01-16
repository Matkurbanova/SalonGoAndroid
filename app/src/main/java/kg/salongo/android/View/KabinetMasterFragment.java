package kg.salongo.android.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kg.salongo.android.Data.KabinetMaster;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class KabinetMasterFragment extends Fragment {

    @BindView(R.id.imageViewPhotoMaster)
    ImageView imageViewPhotoMaster;
    @BindView(R.id.imageViewIconInst)
    ImageView imageViewIconIns;
    @BindView(R.id.imageView9)
    ImageView imageViewIconPhone;
    @BindView(R.id.textViewNameMAster)
    TextView textViewNameMaster;
    @BindView(R.id.textViewPhoneNumber)
    TextView textViewPhone;
    private TextView textView;
    private TextView textViewExperience;
    private Switch SwitchOnnOff;
    private TextView textViewDescription;
    @BindView(R.id.buttonAdd)
    Button buttonEdit;
    private Button buttonAddService;
    @BindView(R.id.buttonAddPromo)
    Button buttonAddPromo;
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
        return inflater.inflate(R.layout.fragment_master_kabinet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        textView = view.findViewById(R.id.textView10);
        textViewExperience = view.findViewById(R.id.textViewExperience);
        SwitchOnnOff = view.findViewById(R.id.switchStatus);
        textViewDescription = view.findViewById(R.id.textViewDescription);
    }

    @OnClick({R.id.buttonEdit, R.id.buttonAddPromo})
    void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonEdit:
                mainActivity.showFragment(new EditServiceFragment());
                break;
            case R.id.buttonAddPromo:
                mainActivity.showFragment(new AddPromoFragment());
                break;
        }
    }
}
