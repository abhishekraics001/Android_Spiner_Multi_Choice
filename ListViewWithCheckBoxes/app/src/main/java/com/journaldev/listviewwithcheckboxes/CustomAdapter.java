package com.journaldev.listviewwithcheckboxes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by anupamchugh on 29/05/17.
 */

public class CustomAdapter extends ArrayAdapter<DataModel> {

    private ArrayList<DataModel> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        CheckBox checkBox;
        RelativeLayout rlmain;
    }

    public CustomAdapter(ArrayList<DataModel> data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.mContext = context;

    }
    @Override
    public int getCount() {
        return dataSet.size();
    }

    @Override
    public DataModel getItem(int position) {
        return dataSet.get(position);
    }


    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        ViewHolder viewHolder;
        final View result;

        if (convertView == null)
        {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.txtName);
            viewHolder.checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
            viewHolder.rlmain = (RelativeLayout) convertView.findViewById(R.id.rlmain);

            result=convertView;
            convertView.setTag(viewHolder);

        }
        else
         {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }

        DataModel item = getItem(position);
        viewHolder.txtName.setText(item.name);
        viewHolder.checkBox.setChecked(item.checked);
        viewHolder.rlmain.setTag(position);
        viewHolder.rlmain.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Integer taggedPosition = (Integer) view.getTag();
                DataModel dataModel= dataSet.get(taggedPosition);
                if(dataModel.checked)
                {
                    dataModel.checked = false;
                }
                else {
                    dataModel.checked = true;
                }
                MainActivity.adapter.notifyDataSetChanged();
            }
        });

        return result;
    }


}
