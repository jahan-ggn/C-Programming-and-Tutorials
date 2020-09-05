package official.jahan.cprogrammingtutorials.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import official.jahan.cprogrammingtutorials.R;


public class WelcomeMenuAdapter extends BaseAdapter {
    int[] welcomescreenimages;
    String[] welcomescreenmenu;
    Context context;

    public WelcomeMenuAdapter(int[] welcomescreenimages, String[] welcomescreenmenu, Context context) {
        this.welcomescreenimages = welcomescreenimages;
        this.welcomescreenmenu = welcomescreenmenu;
        this.context = context;
    }

    @Override
    public int getCount() {
        return welcomescreenmenu.length;
    }

    @Override
    public Object getItem(int position) {
        return welcomescreenmenu[position];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.welcomemenu_single_row, null);
            viewHolder.welcomeGridImage = convertView.findViewById(R.id.welcomeGridImage);
            viewHolder.welcomeMenuName = convertView.findViewById(R.id.welcomeMenuName);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder= (ViewHolder) convertView.getTag();
        }
        viewHolder.welcomeGridImage.setImageResource(welcomescreenimages[i]);
        viewHolder.welcomeMenuName.setText(welcomescreenmenu[i]);
        return convertView;
    }

     class ViewHolder {

        ImageView welcomeGridImage;
        TextView welcomeMenuName;
    }
}
