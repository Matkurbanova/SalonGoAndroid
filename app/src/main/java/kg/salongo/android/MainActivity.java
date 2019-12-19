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

import kg.salongo.android.View.AuthorizationFragment;
import kg.salongo.android.View.CategoryFragment;
import kg.salongo.android.View.MoreServiceFragment;
import kg.salongo.android.View.PersonalFragment;
import kg.salongo.android.View.PersonalKabinetFragment;
import kg.salongo.android.View.ServiceFragment;
import kg.salongo.android.View.SubCategoryFragment;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private FrameLayout frameLayout;
    private Fragment currentFragment;
    private BottomNavigationView bottomNavMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.mainFrame);
        bottomNavMain = findViewById(R.id.bottomNavMain);
        bottomNavMain.setOnNavigationItemSelectedListener(this);
        showFragment(new AuthorizationFragment());
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
                showFragment(new PersonalKabinetFragment());
                break;
            case R.id.action_sales:
                showFragment(new PersonalFragment());
                break;
        }
        menuItem.setChecked(true);
        return false;
    }
}
