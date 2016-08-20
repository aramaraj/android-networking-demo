package adalwin.com.mainactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imaegView=(ImageView)findViewById(R.id.ivImage);

        String url="https://i.imgur.com/tGbaZCY.jpg";

        Davinci.load(url,imaegView);
        //Davinci

        //MyLoadingLibrary.foo("hello").load();
    }

}
