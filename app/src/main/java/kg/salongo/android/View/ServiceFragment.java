package kg.salongo.android.View;

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

import kg.salongo.android.Adapters.CategoryAdapter;
import kg.salongo.android.Adapters.ServiceAdapter;
import kg.salongo.android.Data.Service;
import kg.salongo.android.R;

public class ServiceFragment extends Fragment {
    private RecyclerView recyclerView;
    private ServiceAdapter adapter;

    private Service Service[] = new Service[]{
            new Service("Dein","Коррекция бровей","5-й микрорайон, 63Б","Открыто c 10:00 до 17:00", "500",
                    "https://i.pinimg.com/600x315/63/f9/4a/63f94a65f8d2a49fb430fd7a26bbcf3c.jpg"),
            new Service("VarVara","Коррекция бровей","5-й микрорайон, 63Б","Открыто c 10:00 до 17:00", "500",
                    "https://i.pinimg.com/600x315/63/f9/4a/63f94a65f8d2a49fb430fd7a26bbcf3c.jpg")
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_service, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.RecyclerViewService);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        adapter = new ServiceAdapter(getContext());
        recyclerView.setAdapter(adapter);
        adapter.setServices(Arrays.asList(Service));
    }

}
