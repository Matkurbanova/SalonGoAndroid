package kg.salongo.android.View;

import android.content.Context;
import android.os.Bundle;
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

import butterknife.BindView;
import kg.salongo.android.Adapters.ServiceAdapter;
import kg.salongo.android.Data.MoreService;
import kg.salongo.android.Data.Service;
import kg.salongo.android.Data.SubCategory;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class ServiceFragment extends Fragment{
    private RecyclerView recyclerView;
    private ServiceAdapter adapter;
    private MainActivity mainActivity;
    private SubCategory subCategory;
    private MoreService moreService;

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
    }

    public void setMoreService(MoreService moreService){
        this.moreService=moreService;
    }

    private Service Service[] = new Service[]{
            new Service("Варвара", "Коррекция бровей", "5-й микрорайон, 63B 5м-н,Октябрский район,Бишкек", "Сегодня c 09:00 до 19:00 ", "Закрыто. Откроется в 09:00", "500",
                    "https://i.pinimg.com/600x315/63/f9/4a/63f94a65f8d2a49fb430fd7a26bbcf3c.jpg"),
            new Service("Варвара", "Коррекция бровей", "5-й микрорайон, 63B 5м-н,Октябрский район,Бишкек", "Сегодня c 09:00 до 19:00 ", "Закрыто. Откроется в 09:00", "500",
                    "https://i.pinimg.com/600x315/63/f9/4a/63f94a65f8d2a49fb430fd7a26bbcf3c.jpg"),

    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_service, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        recyclerView=view.findViewById(R.id.recyclerViewServise);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        adapter = new ServiceAdapter(getContext(), this);
        recyclerView.setAdapter(adapter);
        adapter.setServices(Arrays.asList(Service));
    }

    public void serviceClicked(Service service) {
        MoreSalonFragment personalFragment = new MoreSalonFragment();
        personalFragment.setService(service);
        mainActivity.showFragment(personalFragment);
    }
}
