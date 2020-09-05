package official.jahan.cprogrammingtutorials.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import official.jahan.cprogrammingtutorials.R;

public class ProgramsIntroActivity extends AppCompatActivity {

    ListView lvPrograms;
    ArrayList<String> programslist;
    BufferedReader bufferedReader = null;
    ArrayAdapter<String> adapter;
    String str;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    AdRequest adRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs_intro);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        lvPrograms = findViewById(R.id.lvPrograms);
        programslist = new ArrayList<>();

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open("programs.html")));
            str = bufferedReader.readLine();
            while (str != null) {
                programslist.add(str);
                str = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        adapter = new ArrayAdapter<String>(this, R.layout.programs_single_row, R.id.tvProgramsList, programslist);
        lvPrograms.setAdapter(adapter);
        lvPrograms.setTextFilterEnabled(true);
        lvPrograms.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = (String) parent.getAdapter().getItem(position);
                Intent intent = new Intent(ProgramsIntroActivity.this, ProgramActivity.class);
                intent.putExtra("program", str);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
