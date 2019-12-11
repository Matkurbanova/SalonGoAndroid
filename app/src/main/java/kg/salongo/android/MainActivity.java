package kg.salongo.android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import kg.salongo.android.View.AuthorizationFragment;
import kg.salongo.android.View.CategoryFragment;
import kg.salongo.android.View.EditFragment;
import kg.salongo.android.View.PersonalKabinetFragment;
import kg.salongo.android.View.RegistrationPersonalFragment;
import kg.salongo.android.View.RegistrationSalonFragment;
import kg.salongo.android.View.ServiceFragment;
import kg.salongo.android.View.SubCategoryFragment;


public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.mainFrame);
        showFragment(new EditFragment());
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.mainFrame, fragment, fragment.getTag());
        transaction.commit();
    }
}
