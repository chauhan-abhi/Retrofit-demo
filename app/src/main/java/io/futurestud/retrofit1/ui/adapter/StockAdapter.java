package io.futurestud.retrofit1.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import io.futurestud.retrofit1.R;
import io.futurestud.retrofit1.api.model.Stock;

/**
 * Created by abhi on 13/10/17.
 */

public class StockAdapter extends ArrayAdapter<Stock> {

    private Context context;
    private List<Stock> values;

    public StockAdapter(Context context, List<Stock> values) {
        super(context, R.layout.list_item_pagination, values);

        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_item_pagination, parent, false);
        }

        TextView textView = (TextView) row.findViewById(R.id.list_item_pagination_text);

        Stock item = values.get(position);
        String message = item.getTicker()+"-->"+item.getOpen1()+"-->"+item.getClose()+"-->"+item.getVolume();
        textView.setText(message);

        return row;
    }
}
