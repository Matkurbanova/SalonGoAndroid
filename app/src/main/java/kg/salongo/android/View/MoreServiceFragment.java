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

import kg.salongo.android.Adapters.KabinetSalonAdapter;
import kg.salongo.android.Adapters.MoreServiceAdapter;
import kg.salongo.android.Data.KabinetSalon;
import kg.salongo.android.Data.MasterService;
import kg.salongo.android.Data.MoreService;
import kg.salongo.android.Data.Service;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class MoreServiceFragment extends Fragment {
    private RecyclerView recyclerView;
    private MoreServiceAdapter adapter;
    private ImageView imageViewLogoSal;
    private TextView textViewNameSalon;
    private TextView textViewDescription;
    private ImageView imageViewIconPhone;
    private TextView textViewAddress;
    private TextView textViewNomer;
    private TextView textViewTimeWork;
    private MainActivity mainActivity;

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
        imageViewLogoSal = view.findViewById(R.id.imageViewKabinetLogo);
        textViewNameSalon = view.findViewById(R.id.textViewNameMAster);
        textViewDescription = view.findViewById(R.id.textViewDiscrN);
        textViewAddress = view.findViewById(R.id.textViewadress);
        textViewNomer = view.findViewById(R.id.textViewNumber);
        textViewTimeWork = view.findViewById(R.id.textViewWorkTM);
        imageViewIconPhone = view.findViewById(R.id.imageView6);
        recyclerView = view.findViewById(R.id.recyclerViewKabinetSalon);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter = new MoreServiceAdapter(getContext());
        adapter.setMoreServiceFragment(this);
        recyclerView.setAdapter(adapter);
        adapter.setPersonalKabinets(Arrays.asList(kabinetSalon));
    }
    public void moreServiceClicked(MoreService moreService){
        ServiceFragment serviceFragment=new ServiceFragment();
        serviceFragment.setMoreService(moreService);
        mainActivity.showFragment(serviceFragment);
    }
    }


