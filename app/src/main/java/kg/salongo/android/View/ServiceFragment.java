package kg.salongo.android.View;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import kg.salongo.android.Adapters.ServiceAdapter;
import kg.salongo.android.Data.MoreService;
import kg.salongo.android.Data.Service;
import kg.salongo.android.Data.SubCategory;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;
import kg.salongo.android.api.ApiRequests;
import kg.salongo.android.api.ApiResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceFragment extends Fragment {
    private RecyclerView recyclerView;
    private ServiceAdapter adapter;
    private MainActivity mainActivity;
    private SubCategory subCategory;
    private MoreService moreService;

    public ServiceFragment() {

    }

    public ServiceFragment(SubCategory subCategory) {
        setSubCategory(subCategory);
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public void loadServiceSalon(SubCategory subCategory){
        ApiRequests.getSalonService(subCategory.getId(), new Callback<ApiResponse<List<Service>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Service>>> call, Response<ApiResponse<List<Service>>> response) {
                if (response.isSuccessful() && response.body().getStatus() == 0)
                    adapter.setServiceList(response.body().getData());
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Service>>> call, Throwable t) {
                Log.e("Service", "onFailure",t);

            }
        });
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
    }

    public void setMoreService(MoreService moreService) {
        this.moreService = moreService;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_service, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recyclerViewService);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        adapter = new ServiceAdapter(getContext(), this);
        recyclerView.setAdapter(adapter);
        loadServiceSalon(subCategory);
//        adapter.setServiceList(Arrays.asList(services));


    }

    public void serviceClicked(Service service) {
        MoreSalonFragment personalFragment = new MoreSalonFragment();
        personalFragment.setService(service);
        mainActivity.showFragment(personalFragment);
    }

}
