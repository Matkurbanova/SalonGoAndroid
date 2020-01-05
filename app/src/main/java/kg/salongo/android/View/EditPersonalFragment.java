package kg.salongo.android.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class EditPersonalFragment extends Fragment {
    private ImageView imageViewAvatar;
    private EditText editTextName;
    private EditText editTextPhone;
    private EditText editTextOldPass;
    private EditText editTextnewPass;
    private Button buttonSave;
    private EditText editText;
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
        imageViewAvatar=view.findViewById(R.id.imageViewAvatar);
        editTextName=view.findViewById(R.id.TextViewName);
        editTextPhone=view.findViewById(R.id.editTextPhone);
        editTextOldPass=view.findViewById(R.id.editTextPass);
        editTextnewPass=view.findViewById(R.id.editTextNewPass);
        buttonSave=view.findViewById(R.id.buttonSaveEdit);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new ServiceSalonFragment());
            }
        });
        editText=view.findViewById(R.id.textViewEditAvatar);
    }
}
