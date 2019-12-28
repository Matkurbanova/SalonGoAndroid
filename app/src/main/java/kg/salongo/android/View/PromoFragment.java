package kg.salongo.android.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import kg.salongo.android.Adapters.PromoAdapter;

import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class PromoFragment extends Fragment {
    private RecyclerView recyclerViewAksii;
    private PromoAdapter promoAdapter;
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
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_aksii, container, false);
        initViews(view);
        return view;





}

    private void initViews(View view) {
        recyclerViewAksii = view.findViewById(R.id.recyclerViewAksii);
        promoAdapter = new PromoAdapter(getContext());
        recyclerViewAksii.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewAksii.setAdapter(promoAdapter);

    }


}


