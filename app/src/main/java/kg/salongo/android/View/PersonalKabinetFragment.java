package kg.salongo.android.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

import kg.salongo.android.Adapters.PersonalKabinetAdapter;
import kg.salongo.android.Data.PersonalKabinet;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class PersonalKabinetFragment extends Fragment {
    private RecyclerView recyclerViewPrKabien;
    private PersonalKabinetAdapter adapter;
    private TextView TextViewName;
    private Button buttonEdit;
    private ImageView imageViewPrAvatar;
    private MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
    }


    private PersonalKabinet personalKabinets[] = new PersonalKabinet[]{
            new PersonalKabinet("Варвара", "Коррекция бровей", "5-й микрорайон, 63B 5м-н,Октябрский район,Бишкек", "Сегодня c 09:00 до 19:00", "Закрыто. Откроется в 09:00", "500",
                    "https://i.pinimg.com/600x315/63/f9/4a/63f94a65f8d2a49fb430fd7a26bbcf3c.jpg"),
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_moreservise_salon, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        TextViewName = view.findViewById(R.id.TextViewName);
        buttonEdit = view.findViewById(R.id.buttonEdit);
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new PersonalKabinetFragment());

            }
        });
        imageViewPrAvatar = view.findViewById(R.id.imageViewPrAvatar);
        recyclerViewPrKabien = view.findViewById(R.id.RecyclerViewPersonalKabinet);
        recyclerViewPrKabien.setLayoutManager(new GridLayoutManager(getContext(), 1));
        adapter = new PersonalKabinetAdapter(getContext());
        recyclerViewPrKabien.setAdapter(adapter);
        adapter.setPersonalKabinet(Arrays.asList(personalKabinets));
    }
}
