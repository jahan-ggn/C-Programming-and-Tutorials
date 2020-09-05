package official.jahan.cprogrammingtutorials.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import official.jahan.cprogrammingtutorials.R;

public class StartupActivity extends AppCompatActivity {

    ImageView ivStartup;
    TextView tvDeveloperName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);
        ivStartup = findViewById(R.id.ivStartup);
        tvDeveloperName = findViewById(R.id.tvDeveloperName);

        Thread timer = new Thread()
        {
            public void run(){
                try {
                    sleep(3000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                finally {
                    Intent intent = new Intent(StartupActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };

        timer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
