package kg.salongo.android.View;

import android.content.Context;
import android.os.Bundle;
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

import java.util.Arrays;

import kg.salongo.android.Adapters.CategoryAdapter;
import kg.salongo.android.Data.Category;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class CategoryFragment extends Fragment{
    private RecyclerView recyclerView;
    private CategoryAdapter adapter;
    private MainActivity mainActivity;

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
        adapter = new CategoryAdapter(getContext(),this);
        recyclerView.setAdapter(adapter);
        adapter.setCategoryList(Arrays.asList(categories));
    }

    public void categoryClicked(Category category) {
        SubCategoryFragment subCategoryFragment = new SubCategoryFragment();
        subCategoryFragment.setCategory(category);
        mainActivity.showFragment(subCategoryFragment);
    }
}


