package official.jahan.cprogrammingtutorials.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import official.jahan.cprogrammingtutorials.R;


public class PatternProgramAdapter extends BaseAdapter {

    Context context;
    int[] images;
    String[] title;

    public PatternProgramAdapter(Context context, int[] images, String[] title) {
        this.context = context;
        this.images = images;
        this.title = title;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int position) {
        return title[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.pattern_single_row, null);
            viewHolder.ivPattern = convertView.findViewById(R.id.ivPattern);
            viewHolder.tvPatternTitle = convertView.findViewById(R.id.tvPatternTitle);
            convertView.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.ivPattern.setImageResource(images[position]);
        viewHolder.tvPatternTitle.setText(title[position]);
        return convertView;
    }

    static class ViewHolder{
        ImageView ivPattern;
        TextView tvPatternTitle;
    }
}
