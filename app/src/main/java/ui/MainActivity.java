package ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hfad.recyclerviewsocial.R;

import publisher.Publisher;
import ui.main.SocialNetworkFragment;

public class MainActivity extends AppCompatActivity {

    Navigation navigation;

    public Navigation getNavigation() {
        return navigation;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    private Publisher publisher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigation = new Navigation(getSupportFragmentManager());
        publisher = new Publisher();

        if (savedInstanceState == null) {
            navigation.replaceFragment(SocialNetworkFragment.newInstance(), false);
        }
    }
}