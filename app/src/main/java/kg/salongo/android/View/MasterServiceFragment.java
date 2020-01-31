package kg.salongo.android.View;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import kg.salongo.android.Adapters.ServiceMasterAdapter;


import kg.salongo.android.Data.MasterProfiles;
import kg.salongo.android.Data.MasterService;

import kg.salongo.android.Data.SubCategory;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;
import kg.salongo.android.api.ApiRequests;
import kg.salongo.android.api.ApiResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MasterServiceFragment extends Fragment {
    private RecyclerView recyclerViewServiceMaster;
    private ServiceMasterAdapter serviceMasterAdapter;
    private SubCategory subCategory;
    private MainActivity mainActivity;
    private MasterProfiles masterProfile;

    public MasterServiceFragment() {
    }

    public MasterServiceFragment(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
    }

    public void setMasterProfil(MasterProfiles masterProfil) {
        this.masterProfile = masterProfil;
    }


    private void loadMasterServices(SubCategory subCategory) {
        if (subCategory != null)
            ApiRequests.getMasterServices(subCategory.getId(), new Callback<ApiResponse<List<MasterService>>>() {
                @Override
                public void onResponse(Call<ApiResponse<List<MasterService>>> call, Response<ApiResponse<List<MasterService>>> response) {
                    if (response.isSuccessful() && response.body().getStatus() == 0)
                        serviceMasterAdapter.setMasterServiceFragmentList(response.body().getData());
                }

                @Override
                public void onFailure(Call<ApiResponse<List<MasterService>>> call, Throwable t) {
                    Log.e("MasterService", "onFailure", t);

                }
            });
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_servicesmaster, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerViewServiceMaster = view.findViewById(R.id.recyclerViewServiceMaster);
        recyclerViewServiceMaster.setLayoutManager(new GridLayoutManager(getContext(), 1));
        serviceMasterAdapter = new ServiceMasterAdapter(getContext(), this);
        recyclerViewServiceMaster.setAdapter(serviceMasterAdapter);
        loadMasterServices(subCategory);
//        serviceMasterAdapter.setMasterServiceFragmentList(Arrays.asList(masterServices));

    }

    public void masterServiceClicked(MasterService masterService) {
        OtherServicesMasterFragment otherServicesMasterFragment = new OtherServicesMasterFragment();
        otherServicesMasterFragment.setMasterService(masterService);
        mainActivity.showFragment(otherServicesMasterFragment);
    }

}
