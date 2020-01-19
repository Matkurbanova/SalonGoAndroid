package kg.salongo.android.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kg.salongo.android.Data.KabinetMaster;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class KabinetMasterFragment extends Fragment {

    @BindView(R.id.imageViewAvatarMasterKabinet)
    ImageView imageViewPhotoMaster;
    @BindView(R.id.imageViewIconInst)
    ImageView imageViewIconIns;
    @BindView(R.id.imageView9)
    ImageView imageViewIconPhone;
    @BindView(R.id.textViewNameMAster)
    TextView textViewNameMaster;
    @BindView(R.id.textViewPhoneNumber)
    TextView textViewPhone;
    @BindView(R.id.textView10)
    TextView textView;
    @BindView(R.id.textViewExperience)
    TextView textViewExperience;
    @BindView(R.id.switchStatus)
    Switch SwitchOnnOff;
    @BindView(R.id.textViewDescription)
    TextView textViewDescription;
    @BindView(R.id.buttonAdd)
    Button buttonEdit;
    private MainActivity mainActivity;
    private KabinetMasterPagerAdapter pagerAdapter;
    private FloatingActionButton fabAdd;

    private TabLayout tabLayout;
    private ViewPager viewPager;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_master_kabinet, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
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

        buttonEdit.setOnClickListener(v -> {
            mainActivity.showFragment(new EditMasterFragment());
        });

        pagerAdapter = new KabinetMasterPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    class KabinetMasterPagerAdapter extends FragmentPagerAdapter {
        Fragment[] fragments = new Fragment[]{
                new PromoFragment(true), //   0
                new CategoryFragment() // 1
        };

        String[] titles = new String[]{
                getString(R.string.promos),
                getString(R.string.serivices),
        };


        public KabinetMasterPagerAdapter(FragmentManager fm) {
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
