package kg.salongo.android.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

import kg.salongo.android.Adapters.KabinetSalonAdapter;
import kg.salongo.android.Data.KabinetSalon;
import kg.salongo.android.R;

public class MoreServiceFragment extends Fragment {
    private RecyclerView recyclerView;
    private KabinetSalonAdapter adapter;
    private ImageView imageViewLogoSal;
    private TextView textViewNameSalon;
    private TextView textViewDescription;
    private TextView textViewKontakty;
    private TextView textViewAddress;
    private TextView textViewNomer;
    private TextView textViewTimeWork;

    private KabinetSalon kabinetSalon []=new KabinetSalon[]{
            new KabinetSalon("Varvara","https://images11.cosmopolitan.ru/upload/gallery/f84/f8449fa1ed14e7dc1000ae45007f4dd9.jpg"),
     new KabinetSalon("Alina","https://images11.cosmopolitan.ru/upload/gallery/f84/f8449fa1ed14e7dc1000ae45007f4dd9.jpg")
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_more_service, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        imageViewLogoSal=view.findViewById(R.id.imageViewKabinetLogo);
        textViewNameSalon=view.findViewById(R.id.textViewNameSalon);
        textViewDescription=view.findViewById(R.id.textViewDiscrN);
        textViewKontakty=view.findViewById(R.id.textViewKontakt);
        textViewAddress=view.findViewById(R.id.textViewadress);
        textViewNomer=view.findViewById(R.id.textViewNumber);
        textViewTimeWork=view.findViewById(R.id.textViewWorkTM);


        recyclerView = view.findViewById(R.id.recyclerViewKabinetSalon);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter = new KabinetSalonAdapter(getContext());
        recyclerView.setAdapter(adapter);
        adapter.setPersonalKabinets(Arrays.asList(kabinetSalon));
    }
}
