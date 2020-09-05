package official.jahan.cprogrammingtutorials.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import official.jahan.cprogrammingtutorials.Adapters.TutorialsIntroAdapter;
import official.jahan.cprogrammingtutorials.R;


public class TutorialsIntroActivity extends AppCompatActivity {

    ExpandableListView elvTutorial;
    List tutorialstitle;
    HashMap<String, List<String>> tutorialdata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_tutorials_intro);
        elvTutorial = findViewById(R.id.elvTutorial);

        tutorialData();

        TutorialsIntroAdapter tutorialsIntroAdapter = new TutorialsIntroAdapter(this, tutorialstitle, tutorialdata);
        elvTutorial.setAdapter(tutorialsIntroAdapter);

        elvTutorial.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                String str = tutorialdata.get(tutorialstitle.get(groupPosition)).get(childPosition);
                Intent intent = new Intent(TutorialsIntroActivity.this, TutorialActivity.class);
                intent.putExtra("tutorials", str);
                startActivity(intent);
                return false;
            }
        });

    }
    public void tutorialData() {
        tutorialstitle = new ArrayList();
        tutorialdata = new HashMap<>();

        tutorialstitle.add("1. Introduction");
        tutorialstitle.add("2. An example of c program");
        tutorialstitle.add("3. Variables & operators");
        tutorialstitle.add("4. Input & Output");
        tutorialstitle.add("5. Flow of control");
        tutorialstitle.add("6. Functions");
        tutorialstitle.add("7. Scope, Blocks & Variables");
        tutorialstitle.add("8. Arrays, Pointer & String");
        tutorialstitle.add("9. Structure & Union");
        tutorialstitle.add("10. Files");
        tutorialstitle.add("11. Preprocessor Directives");

        List localArrayList1 = new ArrayList();
        localArrayList1.add("1.1 Introduction");
        localArrayList1.add("1.2 Advantages of C");
        List localArrayList2 = new ArrayList();
        localArrayList2.add("2.1 Structure of program");
        List localArrayList3 = new ArrayList();
        localArrayList3.add("3.1 Variables");
        localArrayList3.add("3.2 Operators");
        List localArrayList4 = new ArrayList();
        localArrayList4.add("4.1 Formatted IO - printf & scanf");
        localArrayList4.add("4.2 Chracter IO - getchar & putchar");
        List localArrayList5 = new ArrayList();
        localArrayList5.add("5.1 Conditional branching - if");
        localArrayList5.add("5.2 Conditional selection - switch");
        localArrayList5.add("5.3 Loops - while & for");
        localArrayList5.add("5.4 Local Jumps goto");
        localArrayList5.add("5.5 Break and Continue");
        List localArrayList6 = new ArrayList();
        localArrayList6.add("6.1 Function Basics");
        localArrayList6.add("6.2 Defination & Declaration");
        localArrayList6.add("6.3 Standard Header Files");
        List localArrayList7 = new ArrayList();
        localArrayList7.add("7.1 Blocks and Scope");
        localArrayList7.add("7.2 Variable Storage Classes");
        localArrayList7.add("7.3 Definition & Declaration");
        localArrayList7.add("7.4 Initialisation of Variables");
        List localArrayList8 = new ArrayList();
        localArrayList8.add("8.1 Arrays");
        localArrayList8.add("8.2 Pointer");
        localArrayList8.add("8.3 String");
        List localArrayList9 = new ArrayList();
        localArrayList9.add("9.1 Structure");
        localArrayList9.add("9.2 Union");
        List localArrayList10 = new ArrayList();
        localArrayList10.add("10.1 File Operations and Functions");
        List localArrayList11 = new ArrayList();
        localArrayList11.add("11.1 C Preprocessor directives");

        tutorialdata.put((String) tutorialstitle.get(0), localArrayList1);
        tutorialdata.put((String) tutorialstitle.get(1), localArrayList2);
        tutorialdata.put((String) tutorialstitle.get(2), localArrayList3);
        tutorialdata.put((String) tutorialstitle.get(3), localArrayList4);
        tutorialdata.put((String) tutorialstitle.get(4), localArrayList5);
        tutorialdata.put((String) tutorialstitle.get(5), localArrayList6);
        tutorialdata.put((String) tutorialstitle.get(6), localArrayList7);
        tutorialdata.put((String) tutorialstitle.get(7), localArrayList8);
        tutorialdata.put((String) tutorialstitle.get(8), localArrayList9);
        tutorialdata.put((String) tutorialstitle.get(9), localArrayList10);
        tutorialdata.put((String) tutorialstitle.get(10), localArrayList11);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
