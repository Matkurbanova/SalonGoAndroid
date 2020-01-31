package kg.salongo.android.View;

import android.content.Context;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import kg.salongo.android.Adapters.MasterProfileAdapter;
import kg.salongo.android.Data.MasterProfiles;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class MasterProfileFragment extends Fragment {
    private RecyclerView recyclerView;
    private MainActivity mainActivity;
    @BindView(R.id.imageViewPhotoMaster)
    ImageView imageViewPhotoMaster;
    @BindView(R.id.textViewNameMAster)
    TextView textViewNameMaster;
    TextView textViewPhoneNumber;
    private ImageView imageViewIconPhone;
    @BindView(R.id.imageViewIconInst)
    ImageView imageViewIconInst;

    @BindView(R.id.textViewExperience)
    TextView textViewExperiences;
    @BindView(R.id.textViewDescription)
    TextView textViewDescription;
    private MasterProfileAdapter adapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
    }

    private MasterProfiles masterProfile[]=new MasterProfiles[]{
            new MasterProfiles("https://images11.cosmopolitan.ru/upload/gallery/f84/f8449fa1ed14e7dc1000ae45007f4dd9.jpg", "Kamilla")
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profil_master, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this,view);
        recyclerView = view.findViewById(R.id.recyclerViewKabin);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter= new MasterProfileAdapter(getContext());
        adapter.setMasterProfiles(this);
        recyclerView.setAdapter(adapter);
        adapter.setMasterProfiles(Arrays.asList(masterProfile  ));


    }
    public void masterProfilClicked(MasterProfiles masterProfile){
        MasterServiceFragment masterServiceFragment=new MasterServiceFragment();
        masterServiceFragment.setMasterProfil(masterProfile);
        mainActivity.showFragment(masterServiceFragment);

    }


}
    