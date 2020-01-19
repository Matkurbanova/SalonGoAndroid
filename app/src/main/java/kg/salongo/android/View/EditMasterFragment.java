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
import de.hdodenhof.circleimageview.CircleImageView;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class EditMasterFragment extends Fragment {
    @BindView(R.id.imageViewAvatarEditMaster)
    CircleImageView imageMasterLogo;
    @BindView(R.id.EditNameMaster)
    EditText EditNameMaster;
    @BindView(R.id.EditWorkExperience)
    EditText EditWorkExperience;
    @BindView(R.id.editPhoneMaster)
    EditText editPhoneMaster;
    @BindView(R.id.editInstaLinks)
    EditText editInstaLinks;
    @BindView(R.id.editOldPassword)
    EditText editOldPassword;
    @BindView(R.id.editNewPassword)
    EditText editNewPassword;
    EditText editAboutMaster;
    @BindView(R.id.buttonSave)
    Button buttonSave;
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
        return inflater.inflate(R.layout.fragment_edit_master, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        buttonSave.setOnClickListener(v -> mainActivity.showFragment(new KabinetMasterFragment()));
        Picasso.get().load("https://pngimage.net/wp-content/uploads/2018/05/beauty-logo-design-png-4.png").into(imageMasterLogo);


    }
}






