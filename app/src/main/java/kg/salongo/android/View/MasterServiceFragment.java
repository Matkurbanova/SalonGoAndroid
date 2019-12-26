package kg.salongo.android.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.Arrays;


import kg.salongo.android.Adapters.ServiceMasterAdapter;
import kg.salongo.android.Data.MasterService;
import kg.salongo.android.Data.PersonalKabinet;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class MasterServiceFragment extends Fragment {
    private RecyclerView recyclerViewServiceMaster;
    private ServiceMasterAdapter serviceMasterAdapter;
    private MasterServiceFragment masterServiceFragment;
    private MainActivity mainActivity;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
    }
    private MasterService masterServices[] = new MasterService[]{
         new MasterService("http://ilookroom.ru/images/Veronica.jpg","Камила","Коррекция бровей","2 года","свободна","занята"),


};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_servicesmaster, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerViewServiceMaster = view.findViewById(R.id.recyclerViewServiceMaster);
        recyclerViewServiceMaster.setLayoutManager(new GridLayoutManager(getContext(), 1));
        serviceMasterAdapter = new ServiceMasterAdapter(getContext(),this);
        recyclerViewServiceMaster.setAdapter(serviceMasterAdapter);
        serviceMasterAdapter.setMasterService(Arrays.asList(masterServices));

    }


}
