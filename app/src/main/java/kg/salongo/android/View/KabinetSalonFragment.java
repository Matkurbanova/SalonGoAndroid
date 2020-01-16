package kg.salongo.android.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;

import kg.salongo.android.Adapters.KabinetSalonAdapter;
import kg.salongo.android.Data.KabinetSalon;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class KabinetSalonFragment extends Fragment {
    private KabinetSalonAdapter adapter;
    private ImageView imageViewLogoSal;
    private TextView textViewNameSalon;
    private TextView textViewDescription;
    private TextView textViewKontakty;
    private TextView textViewAddress;
    private TextView textViewNomer;
    private TextView textViewTimeWork;
    private ImageView imageViewIconPhone;
    private MainActivity mainActivity;
    private KabinetSalonaPagerAdapter pagerAdapter;
    private FloatingActionButton fabAdd;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
    }

    private KabinetSalon kabinetSalon[] = new KabinetSalon[]{
            new KabinetSalon("Varvara", "https://images11.cosmopolitan.ru/upload/gallery/f84/f8449fa1ed14e7dc1000ae45007f4dd9.jpg"),
            new KabinetSalon("Alina", "https://images11.cosmopolitan.ru/upload/gallery/f84/f8449fa1ed14e7dc1000ae45007f4dd9.jpg")
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_kabinet_salona, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        imageViewLogoSal = view.findViewById(R.id.imageViewKabinetLogo);
        textViewNameSalon = view.findViewById(R.id.textViewNameMAster);
        textViewDescription = view.findViewById(R.id.textViewDiscrN);
        imageViewIconPhone = view.findViewById(R.id.imageViewIconPhone);
        textViewAddress = view.findViewById(R.id.textViewadress);
        textViewNomer = view.findViewById(R.id.textViewNumber);
        textViewTimeWork = view.findViewById(R.id.textViewWorkTM);

        tabLayout = view.findViewById(R.id.tabLayoutKabinetSalona);
        viewPager = view.findViewById(R.id.viewPagerKabinetSalona);
        fabAdd = view.findViewById(R.id.fabAddKabinetSalona);
        fabAdd.setOnClickListener(v -> {
            if (viewPager.getCurrentItem() == 0) {
                Toast.makeText(getContext(), "Promo Add", Toast.LENGTH_SHORT).show();
                mainActivity.showFragment(new AddPromoFragment());
            } else if (viewPager.getCurrentItem() == 1) {
                Toast.makeText(getContext(), "Service Add", Toast.LENGTH_SHORT).show();
                mainActivity.showFragment(new AddPromoFragment());
            }
        });

        pagerAdapter = new KabinetSalonaPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    class KabinetSalonaPagerAdapter extends FragmentPagerAdapter {

        Fragment[] fragments = new Fragment[]{
                new PromoFragment(true), //   0
                new CategoryFragment() // 1
        };

        String[] titles = new String[]{
                getString(R.string.promos),
                getString(R.string.serivices),
        };

        public KabinetSalonaPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
