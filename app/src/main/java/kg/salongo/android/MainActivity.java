package kg.salongo.android;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import kg.salongo.android.View.AuthorizationFragment;


public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.mainFrame);
        showFragment(new AuthorizationFragment());
    }

    public void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.mainFrame, fragment, fragment.getTag());
        if (currentFragment != null)
            transaction.addToBackStack(currentFragment.getTag());
        transaction.commit();
        currentFragment = fragment;
    }
}
