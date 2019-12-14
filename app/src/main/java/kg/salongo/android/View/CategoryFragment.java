package kg.salongo.android.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

import kg.salongo.android.Adapters.CategoryAdapter;
import kg.salongo.android.Data.Category;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class CategoryFragment extends Fragment {
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
            new Category("NailsService", "https://opmakeup.com/wp-content/uploads/2018/09/screen-shot-2016-12-16-at-5-48-16-pm-1481928523.png"),
            new Category("Salon A", "https://opmakeup.com/wp-content/uploads/2018/09/screen-shot-2016-12-16-at-5-48-16-pm-1481928523.png"),
            new Category("Salon B", "https://opmakeup.com/wp-content/uploads/2018/09/screen-shot-2016-12-16-at-5-48-16-pm-1481928523.png")
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


