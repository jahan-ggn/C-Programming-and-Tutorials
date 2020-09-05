package official.jahan.cprogrammingtutorials.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class QuestionsActivity extends AppCompatActivity {

    ListView lvQuestions;
    BufferedReader bufferedReader;
    String str;
    ArrayList<String> questionlist;
    ArrayAdapter<String> adapter;
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;
    AdRequest adRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvQuestions = findViewById(R.id.lvQuestions);
        questionlist = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open("questions.html")));
            str = bufferedReader.readLine();
            while (str != null) {
                questionlist.add(str);
                str = bufferedReader.readLine();
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        adapter = new ArrayAdapter<String>(this, R.layout.question_single_row, R.id.tvQuestionList, questionlist);
        lvQuestions.setAdapter(adapter);
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
