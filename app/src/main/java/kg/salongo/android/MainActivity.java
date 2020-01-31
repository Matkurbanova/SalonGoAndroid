package kg.salongo.android;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import kg.salongo.android.View.CategoryFragment;
import kg.salongo.android.View.KabinetMasterFragment;
import kg.salongo.android.View.MasterProfileFragment;
import kg.salongo.android.View.MasterServiceFragment;
import kg.salongo.android.View.MoreMasterFragment;
import kg.salongo.android.View.MoreSalonFragment;
import kg.salongo.android.View.PersonalKabinetFragment;
import kg.salongo.android.View.PromoFragment;
import kg.salongo.android.View.TypeFragment;
import kg.salongo.android.utils.PrefHelp;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.bottomNavMain)
    BottomNavigationView bottomNavMain;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        bottomNavMain.setOnNavigationItemSelectedListener(this);
        showFragment(new CategoryFragment());
    }

    public void showFragment(Fragment fragment, boolean withBottomNavigation) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.mainFrame, fragment, fragment.getTag());
        if (currentFragment != null)
            transaction.addToBackStack(currentFragment.getTag());
        transaction.commit();

        if (withBottomNavigation)
            bottomNavMain.setVisibility(View.VISIBLE);
        else
            bottomNavMain.setVisibility(View.GONE);
        currentFragment = fragment;
    }

    public void showFragment(Fragment fragment) {
        showFragment(fragment, true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.action_home:
                showFragment(new CategoryFragment());
                break;
            case R.id.action_personal:
                if (PrefHelp.edit().getBoolean("isLoggedIn")) {
                    showFragment(new PersonalKabinetFragment());
                } else {
                    showFragment(new TypeFragment());
                }
                break;
            case R.id.action_sales:
                showFragment(new PromoFragment(false));
                break;
        }
        menuItem.setChecked(true);
        return false;
    }
}
