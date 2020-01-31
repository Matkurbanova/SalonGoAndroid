package kg.salongo.android.View;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import kg.salongo.android.Data.SubCategory;
import kg.salongo.android.MainActivity;
import kg.salongo.android.R;

public class TypeServiceFragment extends Fragment {
    @BindView(R.id.TypeService)
    TabLayout tabLayout;
    @BindView(R.id.viewPagerTypeServise)
    ViewPager viewPager;
    private MainActivity mainActivity;
    private TypeServicePagerAdapter pagerAdapter;
    private SubCategory subCategory;

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity)
            mainActivity = (MainActivity) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.services_type_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(this, view);


        pagerAdapter = new TypeServicePagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    class TypeServicePagerAdapter extends FragmentPagerAdapter {
        Fragment[] fragments = new Fragment[]{
                new ServiceFragment(subCategory),
                new MasterServiceFragment(subCategory)

        };
        String[] titles = new String[]{
                getString(R.string.salons),
                getString(R.string.navyezd)
        };

        public TypeServicePagerAdapter(FragmentManager fm) {
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
