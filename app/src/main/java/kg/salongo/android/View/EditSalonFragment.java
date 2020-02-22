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

import butterknife.BindView;
import butterknife.ButterKnife;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class EditSalonFragment extends Fragment {
    @BindView(R.id.imageViewAvatarEditFragment)
    ImageView imagephoto;
    @BindView(R.id.UpdatePhoto)
    TextView UpdatePhoto;
    @BindView(R.id.EditName)
    EditText EditName;
    @BindView(R.id.EditAddress)
    EditText EditAddress;
    @BindView(R.id.editPhone)
    EditText editPhone;
    @BindView(R.id.CheckWorkDay)
    TextView CheckWorkDay;
    @BindView(R.id.editInstaLogin)
    EditText editInstaLogin;
    @BindView(R.id.editOldPassword)
    EditText editOldPassword;
    @BindView(R.id.editNewPassword)
    EditText editNewPassword;
    @BindView(R.id.editDescription)
    EditText editDescription;
    @BindView(R.id.SaveInf)
    Button SaveInf;
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
        ButterKnife.bind(this, view);
        SaveInf.setOnClickListener(v -> mainActivity.showFragment(new KabinetSalonFragment()));
        Picasso.get().load("https://pngimage.net/wp-content/uploads/2018/05/beauty-logo-design-png-4.png").into(imagephoto);




    }
}






