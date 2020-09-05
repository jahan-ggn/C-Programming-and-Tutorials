package official.jahan.cprogrammingtutorials.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import official.jahan.cprogrammingtutorials.Adapters.PatternProgramAdapter;
import official.jahan.cprogrammingtutorials.R;


public class PatternProgramsIntroActivity extends AppCompatActivity {

    ListView lvProgramList;
    int[] pattern_icon = {R.drawable.pattern_1, R.drawable.pattern_2, R.drawable.pattern_3, R.drawable.pattern_4, R.drawable.pattern_5, R.drawable.pattern_6, R.drawable.pattern_7, R.drawable.pattern_8, R.drawable.pattern_9, R.drawable.pattern_10, R.drawable.pattern_11, R.drawable.pattern_12, R.drawable.pattern_13, R.drawable.pattern_14, R.drawable.pattern_15, R.drawable.pattern_16, R.drawable.pattern_17, R.drawable.pattern_18, R.drawable.pattern_19, R.drawable.pattern_20, R.drawable.pattern_21, R.drawable.pattern_22, R.drawable.pattern_23, R.drawable.pattern_24, R.drawable.pattern_25, R.drawable.pattern_26, R.drawable.pattern_27, R.drawable.pattern_28, R.drawable.pattern_29, R.drawable.pattern_30, R.drawable.pattern_31, R.drawable.pattern_32, R.drawable.pattern_33, R.drawable.pattern_34, R.drawable.pattern_35, R.drawable.pattern_36, R.drawable.pattern_37, R.drawable.pattern_38, R.drawable.pattern_39, R.drawable.pattern_40, R.drawable.pattern_41, R.drawable.pattern_42, R.drawable.pattern_43, R.drawable.pattern_44, R.drawable.pattern_45, R.drawable.pattern_46, R.drawable.pattern_47, R.drawable.pattern_48, R.drawable.pattern_49, R.drawable.pattern_50, R.drawable.pattern_51, R.drawable.pattern_52, R.drawable.pattern_53, R.drawable.pattern_54, R.drawable.pattern_55, R.drawable.pattern_56, R.drawable.pattern_57, R.drawable.pattern_58, R.drawable.pattern_59, R.drawable.pattern_60, R.drawable.pattern_61, R.drawable.pattern_62, R.drawable.pattern_63, R.drawable.pattern_64, R.drawable.pattern_65, R.drawable.pattern_66, R.drawable.pattern_67, R.drawable.pattern_68, R.drawable.pattern_69, R.drawable.pattern_70, R.drawable.pattern_71, R.drawable.pattern_72, R.drawable.pattern_73, R.drawable.pattern_74, R.drawable.pattern_75, R.drawable.pattern_76, R.drawable.pattern_77, R.drawable.pattern_78, R.drawable.pattern_79, R.drawable.pattern_80, R.drawable.pattern_81, R.drawable.pattern_82, R.drawable.pattern_83, R.drawable.pattern_84, R.drawable.pattern_85, R.drawable.pattern_86, R.drawable.pattern_87, R.drawable.pattern_88, R.drawable.pattern_89, R.drawable.pattern_90, R.drawable.pattern_91, R.drawable.pattern_92, R.drawable.pattern_93, R.drawable.pattern_94, R.drawable.pattern_95, R.drawable.pattern_96, R.drawable.pattern_97, R.drawable.pattern_98, R.drawable.pattern_99, R.drawable.pattern_100, R.drawable.pattern_101, R.drawable.pattern_102, R.drawable.pattern_103, R.drawable.pattern_104, R.drawable.pattern_105, R.drawable.pattern_106, R.drawable.pattern_107, R.drawable.pattern_108, R.drawable.pattern_109, R.drawable.pattern_110, R.drawable.pattern_111, R.drawable.pattern_112, R.drawable.pattern_113, R.drawable.pattern_114, R.drawable.pattern_115, R.drawable.pattern_116, R.drawable.pattern_117, R.drawable.pattern_118, R.drawable.pattern_119, R.drawable.pattern_120, R.drawable.pattern_121, R.drawable.pattern_122, R.drawable.pattern_123, R.drawable.pattern_124, R.drawable.pattern_125, R.drawable.pattern_126, R.drawable.pattern_127, R.drawable.pattern_128, R.drawable.pattern_129, R.drawable.pattern_130};
    String[] pattern_prog_list = {"Pattern 1", "Pattern 2", "Pattern 3", "Pattern 4", "Pattern 5", "Pattern 6", "Pattern 7", "Pattern 8", "Pattern 9", "Pattern 10", "Pattern 11", "Pattern 12", "Pattern 13", "Pattern 14", "Pattern 15", "Pattern 16", "Pattern 17", "Pattern 18", "Pattern 19", "Pattern 20", "Pattern 21", "Pattern 22", "Pattern 23", "Pattern 24", "Pattern 25", "Pattern 26", "Pattern 27", "Pattern 28", "Pattern 29", "Pattern 30", "Pattern 31", "Pattern 32", "Pattern 33", "Pattern 34", "Pattern 35", "Pattern 36", "Pattern 37", "Pattern 38", "Pattern 39", "Pattern 40", "Pattern 41", "Pattern 42", "Pattern 43", "Pattern 44", "Pattern 45", "Pattern 46", "Pattern 47", "Pattern 48", "Pattern 49", "Pattern 50", "Pattern 51", "Pattern 52", "Pattern 53", "Pattern 54", "Pattern 55", "Pattern 56", "Pattern 57", "Pattern 58", "Pattern 59", "Pattern 60", "Pattern 61", "Pattern 62", "Pattern 63", "Pattern 64", "Pattern 65", "Pattern 66", "Pattern 67", "Pattern 68", "Pattern 69", "Pattern 70", "Pattern 71", "Pattern 72", "Pattern 73", "Pattern 74", "Pattern 75", "Pattern 76", "Pattern 77", "Pattern 78", "Pattern 79", "Pattern 80", "Pattern 81", "Pattern 82", "Pattern 83", "Pattern 84", "Pattern 85", "Pattern 86", "Pattern 87", "Pattern 88", "Pattern 89", "Pattern 90", "Pattern 91", "Pattern 92", "Pattern 93", "Pattern 94", "Pattern 95", "Pattern 96", "Pattern 97", "Pattern 98", "Pattern 99", "Pattern 100", "Pattern 101", "Pattern 102", "Pattern 103", "Pattern 104", "Pattern 105", "Pattern 106", "Pattern 107", "Pattern 108", "Pattern 109", "Pattern 110", "Pattern 111", "Pattern 112", "Pattern 113", "Pattern 114", "Pattern 115", "Pattern 116", "Pattern 117", "Pattern 118", "Pattern 119", "Pattern 120", "Pattern 121", "Pattern 122", "Pattern 123", "Pattern 124", "Pattern 125", "Pattern 126", "Pattern 127", "Pattern 128", "Pattern 129", "Pattern 130"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern_programs_intro);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvProgramList = findViewById(R.id.lvProgramList);

        PatternProgramAdapter patternProgramAdapter = new PatternProgramAdapter(this, pattern_icon, pattern_prog_list);
        lvProgramList.setAdapter(patternProgramAdapter);

        lvProgramList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = lvProgramList.getItemAtPosition(position).toString();
                Intent intent = new Intent(PatternProgramsIntroActivity.this, PatternProgramsActivity.class);
                intent.putExtra("patternprograms", str);
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
