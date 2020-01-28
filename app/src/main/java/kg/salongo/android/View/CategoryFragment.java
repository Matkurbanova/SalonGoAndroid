package kg.salongo.android.View;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.List;

import kg.salongo.android.Adapters.CategoryAdapter;
import kg.salongo.android.Data.Category;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;
import kg.salongo.android.api.ApiRequests;
import kg.salongo.android.api.ApiResponse;
import kg.salongo.android.api.services.CategoryService;
import kg.salongo.android.models.GoCategory;
import kg.salongo.android.models.GoUser;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.content.Intent.getIntent;
import static android.content.Intent.getIntentOld;

public class CategoryFragment extends Fragment {
    private RecyclerView recyclerView;
    private CategoryAdapter adapter;
    private MainActivity mainActivity;
    private  int id;
    Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(ApiRequests.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))

            .build();
    CategoryService categoryService=retrofit.create(CategoryService.class);

//    Call<List<GoCategory>> goCategory=getCategoryById("id");

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
    }


    private Category categories[] = new Category[]{
            new Category("Брови ", "https://avatars.mds.yandex.net/get-pdb/1044853/e556f94a-7fcc-4b47-91c0-c440900ad792/s1200"),
            new Category("Ногтевой сервис", "https://st03.kakprosto.ru/tumb/680/images/article/2011/4/14/1_52551e78ad3cf52551e78ad40e.jpg"),
            new Category(" Ресницы", "https://minio.profiles.ru/profiles/7945cfaaa9fc4a0fae83490cddba77dd.jpeg"),
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category, container, false);
    }





    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        adapter = new CategoryAdapter(getContext(), this);
        recyclerView.setAdapter(adapter);
        adapter.setCategoryList(Arrays.asList(categories));
    }
//    void  loadCategory(){
//        Call<List<Category>>call=id>0? categoryService.getCategoryById(id): categoryService.getCategory();
//        call.enqueue(new Callback<List<Category>>() {
//            @Override
//            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
//                if (response.isSuccessful())
//                    adapter.setCategoryList(response.body());
//            }
//
//            @Override
//            public void onFailure(Call<List<Category>> call, Throwable t) {
//
//                Log.e("Category","onFailure",t);
//            }
//        });



    public void categoryClicked(Category category) {
        SubCategoryFragment subCategoryFragment = new SubCategoryFragment();
        subCategoryFragment.setCategory(category);
        mainActivity.showFragment(subCategoryFragment);
    }
}


