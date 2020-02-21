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

import butterknife.BindView;
import butterknife.ButterKnife;
import kg.salongo.android.Adapters.PersonalKabinetAdapter;
import kg.salongo.android.Data.PersonalKabinet;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;
import kg.salongo.android.utils.PrefHelp;

public class PersonalKabinetFragment extends Fragment {
    @BindView(R.id.userAvatar)
    ImageView userAvatar;
    @BindView(R.id.textViewNameUser)
    TextView textViewNameUser;
    @BindView(R.id.EditProfile)
    Button EditProfile;
    private RecyclerView recyclerView;
    @BindView(R.id.textViewGoOut)
    TextView textViewGoOut;
    private PersonalKabinetAdapter personalKabinetAdapter;
    private PersonalKabinet personalKabinet;
    private MainActivity mainActivity;

    public void setPersonalKabinet(PersonalKabinet personalKabinet){
        this.personalKabinet=personalKabinet;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
    }
    private PersonalKabinet personalKabinets[]=new PersonalKabinet[]{
            new PersonalKabinet("Варвара","Коррекция бровей","5-й микрорайон, 63B 5м-н, Октябрский район,Бишкек",
                    "Сегодня c 09:00 до 19:00 ","Закрыто. Откроется в 09:00","500 сом","https://www.48hourslogo.com/48hourslogo_data/2018/02/11/69878_1518331834.jpg")

    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_personalcabinet, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        EditProfile.setOnClickListener(v -> mainActivity.showFragment(new EditPersonalFragment()));
        textViewGoOut.setOnClickListener(v -> {
            PrefHelp.edit().clear();
            mainActivity.showFragment(new TypeFragment());
        });

        recyclerView = view.findViewById(R.id.RecyclerViewPersonalKabinet);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1));
        personalKabinetAdapter= new PersonalKabinetAdapter(getContext(),this);
        recyclerView.setAdapter(personalKabinetAdapter);
        personalKabinetAdapter.setPersonalKabinetList(Arrays.asList(personalKabinet));

        recyclerView.setAdapter(personalKabinetAdapter);

    }

}
