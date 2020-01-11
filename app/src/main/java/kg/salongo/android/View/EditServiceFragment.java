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

import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class EditServiceFragment extends Fragment {
    private ImageView mainImage;
    private ImageView imageGallery;
    private ImageView imagePlus;
    private EditText EditNameOfService;
    private EditText editPrice;
    private EditText editDescription;
    private TextView PhotoGalleryText;
    private Button buttonSaveService;
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
        return inflater.inflate(R.layout.editservice_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mainImage=view.findViewById(R.id.mainImage);
        imageGallery=view.findViewById(R.id.imageGallery);
        imagePlus=view.findViewById(R.id.imagePlus);
        EditNameOfService=view.findViewById(R.id.EditNameOfService);
        editPrice=view.findViewById(R.id.editPrice);
        editDescription=view.findViewById(R.id.editDescription);
        PhotoGalleryText=view.findViewById(R.id.PhotoGalleryText);
        buttonSaveService=view.findViewById(R.id.buttonSaveService);
        buttonSaveService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.showFragment(new ServiceFragment());
            }
        });
        mainImage=view.findViewById(R.id.mainImage);
    }
}
