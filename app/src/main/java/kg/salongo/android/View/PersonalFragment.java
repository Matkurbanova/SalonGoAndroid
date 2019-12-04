package kg.salongo.android.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import kg.salongo.android.R;

public class PersonalFragment extends Fragment {
    private ImageView avatar;
    private TextView textViewNameSalon;
    private TextView textContacts;
    private TextView textAddress;
    private EditText editTextNumber;
    private TextView textWorkTime;
    private TextView Close;
    private TextView TextSubCat;
    private Button buttonPrice;
    private ImageView imageViewPersonal;
    private ImageView imageViewPersonal2;
    private ImageView imageLike;
    private ImageView imageSave;

    @Nullable
@Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.personal_fragment, container, false);
    }

 @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        avatar=view.findViewById(R.id.avatar);
        textAddress=view.findViewById(R.id.textAddress);
        textViewNameSalon=view.findViewById(R.id.textViewNameSalon);
        textContacts=view.findViewById(R.id.textContacts);
        editTextNumber=view.findViewById(R.id.editTextNumber);
        textWorkTime=view.findViewById(R.id.textWorkTime);
        Close=view.findViewById(R.id.Close);
        TextSubCat=view.findViewById(R.id.TextSubCat);
        buttonPrice=view.findViewById(R.id.buttonPrice);
        imageViewPersonal=view.findViewById(R.id.imageViewPersonal);
        imageViewPersonal2=view.findViewById(R.id.imageViewPersonal2);
        imageLike=view.findViewById(R.id.imageSave);

    }
}

