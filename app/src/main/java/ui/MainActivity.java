package ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hfad.recyclerviewsocial.R;

import publisher.Publisher;
import ui.main.SocialNetworkFragment;

public class MainActivity extends AppCompatActivity {

    public Publisher getPublisher() {
        return publisher;
    }

    private Publisher publisher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        publisher = new Publisher();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, SocialNetworkFragment.newInstance()).commit();
        }
    }

}