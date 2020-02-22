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
import kg.salongo.android.Adapters.MoreServiceAdapter;
import kg.salongo.android.Data.MoreService;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class MoreServiceFragment extends Fragment {
    private RecyclerView recyclerView;
    private MoreServiceAdapter adapter;
    @BindView(R.id.imageViewKabinetLogo)
    ImageView imageViewLogoSal;
    @BindView(R.id.textViewNameMAster)
    TextView textViewNameSalon;
    @BindView(R.id.textViewDiscrN)
    TextView textViewDescription;
    @BindView(R.id.imageView6)
    ImageView imageViewIconPhone;
    @BindView(R.id.textViewadress)
    TextView textViewAddress;
    @BindView(R.id.textViewNumber)
    TextView textViewNomer;
    @BindView(R.id.textViewWorkTM)
    TextView textViewTimeWork;
    private MainActivity mainActivity;
    @BindView(R.id.textViewProfilSalonSatatus)
    TextView textViewProfilMasterStatus;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
    }
    private MoreService kabinetSalon[] = new MoreService[]{
            new MoreService("Varvara", "https://images11.cosmopolitan.ru/upload/gallery/f84/f8449fa1ed14e7dc1000ae45007f4dd9.jpg"),
            new MoreService("Alina", "https://images11.cosmopolitan.ru/upload/gallery/f84/f8449fa1ed14e7dc1000ae45007f4dd9.jpg")
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_more_service, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this,view);
        recyclerView = view.findViewById(R.id.recyclerViewKabinetSalon);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter = new MoreServiceAdapter(getContext());
        adapter.setMoreServiceFragment(this);
        recyclerView.setAdapter(adapter);
        adapter.setPersonalKabinets(Arrays.asList(kabinetSalon));
    }
    public void moreServiceClicked(MoreService moreService){
        ServiceSalonFragment serviceFragment=new ServiceSalonFragment();
        serviceFragment.setMoreService(moreService);
        mainActivity.showFragment(serviceFragment);
    }
    }


