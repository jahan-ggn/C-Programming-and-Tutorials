package official.jahan.cprogrammingtutorials.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import official.jahan.cprogrammingtutorials.R;


public class TutorialActivity extends AppCompatActivity {

    TextView tvTutorialTopicHeader, tvTutorialTopicData;
    ScrollView tutorialsScrollView;
    FloatingActionButton fabShare;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tutorialsScrollView = findViewById(R.id.tutorialsScrollView);
        tvTutorialTopicHeader = findViewById(R.id.tvTutorialTopicHeader);
        tvTutorialTopicData = findViewById(R.id.tvTutorialTopicData);
        fabShare = findViewById(R.id.fabShare);

        String str = getIntent().getExtras().getString("tutorials");
        String str2 = "tutorial/" + str + ".html";
        try {
            tvTutorialTopicHeader.setText(str);
            InputStream localInputStream = getAssets().open(str2);
            byte[] arrayOfByte = new byte[localInputStream.available()];
            localInputStream.read(arrayOfByte);
            localInputStream.close();
            tvTutorialTopicData.setText(Html.fromHtml(new String(arrayOfByte)));
            fabShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String str = "Download this app for more tutorials";
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT, tvTutorialTopicHeader.getText().toString() + "\n \n" + tvTutorialTopicData.getText().toString() + "\n \n" + str + "\n \n" + "https://play.google.com/store/apps/details?id=official.jahan.cprogrammingtutorials");
                    startActivity(Intent.createChooser(intent, "Share Using..."));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
