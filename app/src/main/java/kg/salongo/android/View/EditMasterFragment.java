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

import com.squareup.picasso.Picasso;

import kg.salongo.android.R;

public class EditMasterFragment extends Fragment {
    private ImageView imageMasterLogo;
    private EditText EditNameMaster;
    private EditText EditWorkExperience;
    private EditText editPhoneMaster;
    private EditText editInstaLinks;
    private EditText editOldPassword;
    private EditText editNewPassword;
    private EditText editAboutMaster;
    private Button buttonSave;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_master, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
       imageMasterLogo =view.findViewById(R.id.imageMasterLogo);
       EditNameMaster=view.findViewById(R.id.EditNameMaster);
       EditWorkExperience=view.findViewById(R.id.EditWorkExperience);
       editPhoneMaster=view.findViewById(R.id.editPhoneMaster);
       editInstaLinks=view.findViewById(R.id.editInstaLinks);
       editAboutMaster=view.findViewById(R.id.CheckWorkDay);
        editOldPassword=view.findViewById(R.id.editOldPassword);
        editNewPassword=view.findViewById(R.id.editNewPassword);
        buttonSave=view.findViewById(R.id.buttonSave);

        Picasso.get().load("https://pngimage.net/wp-content/uploads/2018/05/beauty-logo-design-png-4.png").into(imageMasterLogo);




    }
}






