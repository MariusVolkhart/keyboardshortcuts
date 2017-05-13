package com.volkhart.keyboardshortcuts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

final class MenuItemAdapter extends BindableAdapter<MenuItem> {

    private List<MenuItem> items = Collections.emptyList();

    MenuItemAdapter(Context context) {
        super(context);
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public MenuItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return items.get(position).getItemId();
    }

    @Override
    public View newView(LayoutInflater inflater, int position, ViewGroup container) {
        View view = inflater.inflate(R.layout.keyboardshortcuts_list_item_shortcut, container, false);
        view.setTag(new ViewHolder(view));
        return view;
    }

    @Override
    public void bindView(MenuItem item, int position, View view) {
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.title.setText(item.getTitle());
        holder.shortcut.setText(String.valueOf(item.getAlphabeticShortcut()));
        holder.icon.setImageDrawable(item.getIcon());
    }

    void setItems(List<MenuItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    private static class ViewHolder {
        final TextView title;
        final TextView shortcut;
        final ImageView icon;

        ViewHolder(View view) {
            title = (TextView) view.findViewById(R.id.title);
            shortcut = (TextView) view.findViewById(R.id.shortcut);
            icon = (ImageView) view.findViewById(R.id.icon);
        }
    }
}
