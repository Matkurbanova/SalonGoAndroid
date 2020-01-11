package kg.salongo.android.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;

import kg.salongo.android.Adapters.PromoAdapter;
import kg.salongo.android.Adapters.ServiceAdapter;
import kg.salongo.android.Data.Promo;
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
    Promo promos[] = {
            new Promo(400.0, "Центр красоты  Мир Эстетики рад подарить вам новогоднюю скидку 10% на все услуги!", "Центр красоты  Мир Эстетики рад подарить вам новогоднюю скидку 10% на все услуги!", "", "", "Мир Эстетики"),
            new Promo(300.0, "Центр красоты  Мир Эстетики рад подарить вам новогоднюю скидку 10% на все услуги!", "Центр красоты  Мир Эстетики рад подарить вам новогоднюю скидку 10% на все услуги!", "", "", "Мир Эстетики"),
            new Promo(100.0, "Центр красоты  Мир Эстетики рад подарить вам новогоднюю скидку 10% на все услуги!", "Центр красоты  Мир Эстетики рад подарить вам новогоднюю скидку 10% на все услуги!", "", "", "Мир Эстетики"),
    };

    private void initViews(View view) {
        recyclerViewAksii = view.findViewById(R.id.recyclerViewAksii);
        promoAdapter = new PromoAdapter(getContext());
        recyclerViewAksii.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewAksii.setAdapter(promoAdapter);
        promoAdapter.setPromoList(Arrays.asList(promos));


}}


