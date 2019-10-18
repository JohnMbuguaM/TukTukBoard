package mbuguamuthoni.tuktukboard;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navLister);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new WestFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navLister = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            switch (menuItem.getItemId()) {
                case R.id.nav_West:
                    selectedFragment= new WestFragment();
                    break;
                case R.id.nav_Kiwanja:
                    selectedFragment= new KiwanjaFragment();
                    break;
                case R.id.nav_bipass:
                    selectedFragment= new BiPassFragment();
                    break;

            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectedFragment).commit();

            return true;
        }
    };
}
