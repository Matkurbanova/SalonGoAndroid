package kg.salongo.android.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import kg.salongo.android.Adapters.MasterProfileAdapter;
import kg.salongo.android.Data.MasterProfiles;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class MasterProfileFragment extends Fragment {
    private RecyclerView recyclerView;
    private MainActivity mainActivity;
    @BindView(R.id.imageViewPhotoMaster)
    ImageView imageViewPhotoMaster;
    @BindView(R.id.textViewNameMAster)
    TextView textViewNameMaster;
    TextView textViewPhoneNumber;
    private ImageView imageViewIconPhone;
    @BindView(R.id.imageViewIconInst)
    ImageView imageViewIconInst;

    @BindView(R.id.textViewExperience)
    TextView textViewExperiences;
    @BindView(R.id.textViewDescription)
    TextView textViewDescription;
    @BindView(R.id.tabLayoutProfileMaster)
    TabLayout tabLayout;
    @BindView(R.id.viewPagerProfileMaster)
    ViewPager viewPager;
    private MasterProfileAdapter adapter;
    private PagerAdapter pagerAdapter;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
    }

    private MasterProfiles masterProfile[] = new MasterProfiles[]{
            new MasterProfiles("https://images11.cosmopolitan.ru/upload/gallery/f84/f8449fa1ed14e7dc1000ae45007f4dd9.jpg", "Kamilla")
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profil_master, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);
//        recyclerView = view.findViewById(R.id.recyclerViewKabin);
//        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
//        adapter= new MasterProfileAdapter(getContext());
//        adapter.setMasterProfiles(this);
//        recyclerView.setAdapter(adapter);
        pagerAdapter = new MasterProfilePagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        //adapter.setMasterProfiles(Arrays.asList(masterProfile));


    }

    class MasterProfilePagerAdapter extends FragmentPagerAdapter {
        Fragment[] fragments = new Fragment[]{
                new CategoryFragment(), //   0
                new PromoFragment(true) // 1
        };

        String[] titles = new String[]{
                getString(R.string.serivices),
                getString(R.string.promos),
        };

        public MasterProfilePagerAdapter(FragmentManager fm) {
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

    public void masterProfilClicked(MasterProfiles masterProfile) {
        MasterServiceFragment masterServiceFragment = new MasterServiceFragment();
        masterServiceFragment.setMasterProfil(masterProfile);
        mainActivity.showFragment(masterServiceFragment);

    }


}
    