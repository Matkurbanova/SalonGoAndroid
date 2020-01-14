package kg.salongo.android.View;

import android.content.Context;
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


import com.squareup.picasso.Picasso;

import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class EditFragment extends Fragment {
    private ImageView imagephoto;
    private TextView UpdatePhoto;
    private EditText EditName;
    private EditText EditAddress;
    private EditText editPhone;
    private TextView CheckWorkDay;
    private EditText editInstaLogin;
    private EditText editOldPassword;
    private EditText editNewPassword;
    private EditText editDescription;
    private Button SaveInf;
    private MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.edit_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
       imagephoto =view.findViewById(R.id.imagePhoto);
       UpdatePhoto=view.findViewById(R.id.UpdatePhoto);
       EditName=view.findViewById(R.id.EditName);
       EditAddress=view.findViewById(R.id.EditAddress);
       editPhone=view.findViewById(R.id.editPhone);
       CheckWorkDay=view.findViewById(R.id.CheckWorkDay);
        editInstaLogin=view.findViewById(R.id.editInstaLogin);
        editOldPassword=view.findViewById(R.id.editOldPassword);
        editNewPassword=view.findViewById(R.id.editNewPassword);
        editDescription=view.findViewById(R.id.editDescription);
        SaveInf=view.findViewById(R.id.SaveInf);
        SaveInf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new KabinetSalonFragment());
            }
        });

        Picasso.get().load("https://pngimage.net/wp-content/uploads/2018/05/beauty-logo-design-png-4.png").into(imagephoto);




    }
}






