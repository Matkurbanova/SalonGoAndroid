package kg.salongo.android.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

import kg.salongo.android.Adapters.MasterProfileAdapter;
import kg.salongo.android.Adapters.ServiceAdapter;
import kg.salongo.android.Data.MasterProfile;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class MasterProfileFragment extends Fragment {
    private RecyclerView recyclerView;
    private MainActivity mainActivity;
    private ImageView imageViewPhotoMaster;
    private TextView textViewNameMaster;
    private TextView textViewPhoneNumber;
    private ImageView imageViewIconPhone;
    private ImageView imageViewIconInst;
    private TextView textViewExperience;
    private TextView textViewExperiences;
    private TextView textViewDescription;
    private MasterProfileAdapter adapter;

    private MasterProfile masterProfile[]=new MasterProfile[]{
            new MasterProfile("https://images11.cosmopolitan.ru/upload/gallery/f84/f8449fa1ed14e7dc1000ae45007f4dd9.jpg", "Kamilla")
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_master_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        imageViewPhotoMaster=view.findViewById(R.id.imageViewPhotoMaster);
        textViewNameMaster=view.findViewById(R.id.textViewNameMAster);
        textViewPhoneNumber=view.findViewById(R.id.textViewPhoneNumber);
        imageViewIconInst=view.findViewById(R.id.imageViewIconInst);
        textViewExperience=view.findViewById(R.id.textView10);
        textViewExperiences=view.findViewById(R.id.textViewExperience);
        textViewDescription=view.findViewById(R.id.textViewDescription);

        recyclerView = view.findViewById(R.id.recyclerViewMasterProfile);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter= new MasterProfileAdapter(getContext());
        recyclerView.setAdapter(adapter);
        adapter.setMasterProfiles(Arrays.asList(masterProfile  ));


    }


}
