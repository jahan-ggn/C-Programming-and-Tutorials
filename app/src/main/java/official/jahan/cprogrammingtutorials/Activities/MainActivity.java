package official.jahan.cprogrammingtutorials.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import official.jahan.cprogrammingtutorials.Adapters.WelcomeMenuAdapter;
import official.jahan.cprogrammingtutorials.R;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    GridView welcomeGridView;
    int[] welcomescreenimages = new int[]{R.drawable.open_book, R.drawable.code, R.drawable.coding, R.drawable.questions, R.drawable.star, R.drawable.share};
    String[] welcomescreenmenu = new String[]{"Tutorial", "Programs", "C Pattern \n Programs", "University Exam Questions", "Rate", "Suggest and Share"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeGridView = findViewById(R.id.welcomeGridView);
        WelcomeMenuAdapter welcomeMenuAdapter = new WelcomeMenuAdapter(welcomescreenimages, welcomescreenmenu, this);
        welcomeGridView.setAdapter(welcomeMenuAdapter);

        welcomeGridView.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.welcomemenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_report) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String to[] = {"jtechprogramming@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL, to);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Report a bug");
            intent.setType("message/rfc822");
            startActivity(Intent.createChooser(intent, "Report a bug Using..."));

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            startActivity(new Intent(MainActivity.this, TutorialsIntroActivity.class));
        }

        if (position == 1) {
            startActivity(new Intent(MainActivity.this, ProgramsIntroActivity.class));
        }

        if (position == 2) {
            Intent intent = new Intent(MainActivity.this, PatternProgramsIntroActivity.class);
            startActivity(intent);
        }

        if (position == 3) {
            startActivity(new Intent(MainActivity.this, QuestionsActivity.class));
        }

        if (position == 4) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=official.jahan.cprogrammingtutorials"));
            startActivity(intent);
        }

        if (position == 5) {
            String str = "Hey,\nI am learning C programming with this amazing app\nThis is Best app with Proper Tutorials with 100+ programs \n Download it :\n";
            Intent intent = new Intent(android.content.Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, "C Programming And Tutorial");
            intent.putExtra(Intent.EXTRA_TEXT, str + "\n" + "https://play.google.com/store/apps/details?id=official.jahan.cprogrammingtutorials");
            startActivity(Intent.createChooser(intent, "Share Using..."));
        }
    }


    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit?");
        builder.setMessage("Do you really want to exit?");
        builder.setIcon(R.drawable.icon);

        builder.setPositiveButton("EXIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setNeutralButton("RATE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=official.jahan.cprogrammingtutorials"));
                startActivity(intent);
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}