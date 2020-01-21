package kg.salongo.android.View;

import android.content.Context;
import android.os.Bundle;
import android.print.PrinterId;
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

import kg.salongo.android.Adapters.CategoryAdapter;
import kg.salongo.android.Adapters.SubCategoryAdapter;
import kg.salongo.android.Data.Category;
import kg.salongo.android.Data.SubCategory;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

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

    private SubCategory subCategories[] = new SubCategory[]{

            new SubCategory("Окрашивание бровей с хной"),
            new SubCategory("Коррекция бровей"),
            new SubCategory("Окрашивание бровей краской")
    };

    public void setCategory(Category category) {
        this.category = category;
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
        adapter.setSubCategoryList(Arrays.asList(subCategories));
    }

    public void subCategoryClicked(SubCategory subCategory) {
        TypeServiceFragment typeServiceFragment = new TypeServiceFragment();
        typeServiceFragment.setSubCategory(subCategory);
        mainActivity.showFragment(typeServiceFragment);
    }


}

