package official.jahan.cprogrammingtutorials.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

import official.jahan.cprogrammingtutorials.R;

public class TutorialsIntroAdapter extends BaseExpandableListAdapter {
    private Context context;
    private List tutorialstitle;
    private HashMap<String, List<String>> tutorialdata;

    public TutorialsIntroAdapter(Context context, List tutorialstitle, HashMap<String, List<String>> tutorialdata) {
        this.context = context;
        this.tutorialstitle = tutorialstitle;
        this.tutorialdata = tutorialdata;
    }

    @Override
    public int getGroupCount() {
        return tutorialstitle.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return tutorialdata.get(tutorialstitle.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return tutorialstitle.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return tutorialdata.get(tutorialstitle.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String str = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.tutorial_title_header_single_row, null);
        }
        TextView tvTutorialTitleHeader = convertView.findViewById(R.id.tvTutorialTitleHeader);
        tvTutorialTitleHeader.setTypeface(null, Typeface.BOLD);
        tvTutorialTitleHeader.setText(str);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String str = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.tutorial_title_data_single_row, null);
        }
        final TextView tvTutorialTitleData = convertView.findViewById(R.id.tvTutorialTitleData);
        tvTutorialTitleData.setText(str);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
