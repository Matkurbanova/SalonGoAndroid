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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

import kg.salongo.android.Adapters.PromoAdapter;
import kg.salongo.android.Data.Promo;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;
import kg.salongo.android.api.ApiRequests;
import kg.salongo.android.api.ApiResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PromoFragment extends Fragment {
    private RecyclerView recyclerViewAksii;
    private PromoAdapter promoAdapter;
    private MainActivity mainActivity;

    private boolean isUserPromos;

    public PromoFragment(boolean isUserPromos) {
        this.isUserPromos = isUserPromos;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_promo, container, false);
        initViews(view);
        return view;


    }
    void  loadPromo(){
        ApiRequests.getPromo(new Callback<ApiResponse<List<Promo>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<Promo>>> call, Response<ApiResponse<List<Promo>>> response) {
                if (response.isSuccessful() && response.body().getStatus() == 0)
                    promoAdapter.setPromoList(response.body().getData());
            }

            @Override
            public void onFailure(Call<ApiResponse<List<Promo>>> call, Throwable t) {
                Log.e("Promo", "onFailure", t);

            }
        });
    }

    private void initViews(View view) {
        recyclerViewAksii = view.findViewById(R.id.recyclerViewAksii);
        promoAdapter = new PromoAdapter(getContext(), isUserPromos);
        recyclerViewAksii.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewAksii.setAdapter(promoAdapter);
        loadPromo();
        //promoAdapter.setPromoList(Arrays.asList(promos));


    }
}


