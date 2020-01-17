package kg.salongo.android.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import kg.salongo.android.Adapters.KabinetSalonAdapter;
import kg.salongo.android.Data.KabinetSalon;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class KabinetSalonFragment extends Fragment {
    private KabinetSalonAdapter adapter;
    @BindView(R.id.imageViewKabinetLogo)
    ImageView imageViewLogoSal;
    @BindView(R.id.textViewNameMAster)
    TextView textViewNameSalon;
    @BindView(R.id.textViewDiscrN)
    TextView textViewDescription;
    @BindView(R.id.textViewadress)
    TextView textViewAddress;
    @BindView(R.id.textViewNumber)
     TextView textViewNomer;
    @BindView(R.id.textViewWorkTM)
     TextView textViewTimeWork;
    @BindView(R.id.imageViewIconPhone)
     ImageView imageViewIconPhone;
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
        tabLayout = view.findViewById(R.id.tabLayoutKabinetMaster);
        viewPager = view.findViewById(R.id.viewPagerKabinetMaster);
        fabAdd = view.findViewById(R.id.fabAddKabinetMaster);
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
