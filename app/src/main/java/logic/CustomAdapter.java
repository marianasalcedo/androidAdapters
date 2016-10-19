package logic;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import es.upm.miw.listviewsample.R;

public class CustomAdapter extends ArrayAdapter {

    private Context context;
    private Object[] dataContent;
    private int idResource;

    public CustomAdapter(Context context, int resource, Object[] objects) {
        super(context, resource, objects);
        this.dataContent = objects;
        this.context = context;
        this.idResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Object data =  this.dataContent[position];
        View resultView;

        if(convertView != null){
            resultView = (LinearLayout) convertView;

        }else{
            LayoutInflater inflater = LayoutInflater.from(context);
            resultView = inflater.inflate(idResource, parent, false);
        }

        TextView customId = (TextView) resultView.findViewById(R.id.id);
        TextView customValue = (TextView) resultView.findViewById(R.id.value);

        Resources res = context.getResources();
        customId.setText(String.format(res.getString(R.string.idString), position + 1));
        customValue.setText(String.format(res.getString(R.string.valueString), data.toString()));
        return resultView;
    }
}
