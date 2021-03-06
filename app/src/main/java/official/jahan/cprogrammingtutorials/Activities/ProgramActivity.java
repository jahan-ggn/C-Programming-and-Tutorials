package official.jahan.cprogrammingtutorials.Activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

import official.jahan.cprogrammingtutorials.R;

public class ProgramActivity extends AppCompatActivity {

    TextView tvProgramTopicHeader, tvProgramTopicData;
    ScrollView programScrollView;
    ImageView ivProgramOutput;
    FloatingActionButton fabShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvProgramTopicHeader = findViewById(R.id.tvProgramTopicHeader);
        tvProgramTopicData = findViewById(R.id.tvProgramTopicData);
        ivProgramOutput = findViewById(R.id.ivProgramOutput);
        programScrollView = findViewById(R.id.programScrollView);
        fabShare = findViewById(R.id.fabShare);

        String str = getIntent().getExtras().getString("program");
        String str2 = "programs/" + str + ".html";
        String str3 = "output/" + str + ".png";
        try {
            tvProgramTopicHeader.setText(str);
            InputStream localInputStream = getAssets().open(str2);
            byte[] arrayOfByte = new byte[localInputStream.available()];
            localInputStream.read(arrayOfByte);
            localInputStream.close();
            tvProgramTopicData.setText(Html.fromHtml(new String(arrayOfByte)));
            Bitmap localBitmap = BitmapFactory.decodeStream(getAssets().open(str3));
            ivProgramOutput.setImageBitmap(localBitmap);
            fabShare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String str = "Download this app for more programs";
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT,  tvProgramTopicHeader.getText().toString() + "\n \n" + tvProgramTopicData.getText().toString() + "\n \n" + str + "\n \n" + "https://play.google.com/store/apps/details?id=official.jahan.cprogrammingtutorials");
                    startActivity(Intent.createChooser(intent,"Share Using..."));
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