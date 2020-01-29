package kg.salongo.android.View;

import android.content.Context;
import android.os.Bundle;
import android.print.PrinterId;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Arrays;
import java.util.List;

import kg.salongo.android.Adapters.CategoryAdapter;
import kg.salongo.android.Adapters.SubCategoryAdapter;
import kg.salongo.android.Data.Category;
import kg.salongo.android.Data.SubCategory;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;
import kg.salongo.android.api.ApiRequests;
import kg.salongo.android.api.ApiResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubCategoryFragment extends Fragment {
    private RecyclerView recyclerView;
    private SubCategoryAdapter adapter;
    private Category category;
    private MainActivity mainActivity;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
    }



    public void setCategory(Category category) {
        this.category = category;
    }

    private void loadSubCategories(Category category) {
        ApiRequests.getSubCategories(category.getId(), new Callback<ApiResponse<List<SubCategory>>>() {
            @Override
            public void onResponse(Call<ApiResponse<List<SubCategory>>> call, Response<ApiResponse<List<SubCategory>>> response) {
                if (response.isSuccessful() && response.body().getStatus() == 0)
                    adapter.setSubCategoryList(response.body().getData());
            }

            @Override
            public void onFailure(Call<ApiResponse<List<SubCategory>>> call, Throwable t) {
                Log.e("SubCategory", "onFailure",t);
            }
        });
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_subcategory, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recyclerViewSubCategory);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        adapter = new SubCategoryAdapter(getContext(), this);
        recyclerView.setAdapter(adapter);
        loadSubCategories(category);
//        adapter.setSubCategoryList(Arrays.asList(subCategories));
    }

    public void subCategoryClicked(SubCategory subCategory) {
        TypeServiceFragment typeServiceFragment = new TypeServiceFragment();
        typeServiceFragment.setSubCategory(subCategory);
        mainActivity.showFragment(typeServiceFragment);
    }


}

