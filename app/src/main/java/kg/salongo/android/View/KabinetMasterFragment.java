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

import kg.salongo.android.Data.KabinetMaster;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class KabinetMasterFragment extends Fragment {
    private RecyclerView recyclerView;
    private ImageView imageViewPhotoMaster;
    private ImageView imageViewIconIns;
    private ImageView imageViewIconPhone;
    private TextView textViewNameMaster;
    private TextView textViewPhone;
    private TextView textView;
    private TextView textViewExperience;
    private Switch SwitchOnnOff;
    private TextView textViewDescription;
    private Button buttonEdit;
    private Button buttonAddService;
    private Button buttonAddPromo;
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
        imageViewPhotoMaster=view.findViewById(R.id.imageViewPhotoMaster);
        imageViewIconIns=view.findViewById(R.id.imageViewIconInst);
        imageViewIconPhone=view.findViewById(R.id.imageView9);
        textViewNameMaster=view.findViewById(R.id.textViewNameMAster);
        textViewPhone=view.findViewById(R.id.textViewPhoneNumber);
        textView=view.findViewById(R.id.textView10);
        textViewExperience=view.findViewById(R.id.textViewExperience);
        SwitchOnnOff=view.findViewById(R.id.switchStatus);
        textViewDescription=view.findViewById(R.id.textViewDescription);
        buttonEdit=view.findViewById(R.id.buttonAdd);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new EditMasterFragment());

            }
        });
        buttonAddService=view.findViewById(R.id.buttonEdit);
        buttonAddService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new EditServiceFragment());
            }
        });
        buttonAddPromo=view.findViewById(R.id.buttonAddPromo);

    }
}
