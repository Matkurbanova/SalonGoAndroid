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

import com.github.pinball83.maskededittext.MaskedEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class EditPersonalFragment extends Fragment {
    @BindView(R.id.imageViewAvatarEditPersonal)
    ImageView imageViewAvatar;
    @BindView(R.id.TextViewName)
    EditText editTextName;
    @BindView(R.id.editTextPhone)
    MaskedEditText editTextPhone;
    @BindView(R.id.editTextPass)
    EditText editTextOldPass;
    @BindView(R.id.editTextNewPass)
    EditText editTextnewPass;
    @BindView(R.id.buttonSaveEdit)
    Button buttonSave;
    @BindView(R.id.textViewEditAvatar)
    TextView textViewUpdateAvatar;
    MainActivity mainActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_personal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
        buttonSave.setOnClickListener(v -> mainActivity.showFragment(new ServiceFragment()));
    }
}
