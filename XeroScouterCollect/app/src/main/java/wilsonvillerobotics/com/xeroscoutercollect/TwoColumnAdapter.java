package wilsonvillerobotics.com.xeroscoutercollect;

import android.content.Context;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by nick on 11/5/16.
 */
public class TwoColumnAdapter extends BaseAdapter {
    private final Context mContext;
    private List<Pair<String, String>> mPairStrings;

    public TwoColumnAdapter(Context mContext, List<Pair<String, String>> mPairStrings) {
        this.mContext = mContext;
        this.mPairStrings = mPairStrings;
    }

    static class ViewHolder {
        public TextView columnOne;
        public TextView columnTwo;
    }

    @Override
    public int getCount() {
        return mPairStrings.size();
    }

    @Override
    public Object getItem(int i) {
        return mPairStrings.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mPairStrings.get(i).hashCode();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.layout_2_col_list, viewGroup, false);
            holder = new ViewHolder();
            holder.columnOne = (TextView) view.findViewById(R.id.list_item_element_1);
            holder.columnTwo = (TextView) view.findViewById(R.id.list_item_element_2);

            view.setTag(holder);

        } else {
            holder = (ViewHolder) view.getTag();
        }

        Pair<String, String> item = mPairStrings.get(i);

        holder.columnOne.setText(item.first);
        holder.columnTwo.setText(item.second);

        return view;

    }
}
