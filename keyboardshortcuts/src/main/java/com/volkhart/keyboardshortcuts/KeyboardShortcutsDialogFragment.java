package com.volkhart.keyboardshortcuts;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public final class KeyboardShortcutsDialogFragment extends DialogFragment {

    static final String TAG = "KeyboardShortcutsDialogFragment";

    private MenuItemAdapter adapter;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        adapter = new MenuItemAdapter(getContext());
        return new AlertDialog.Builder(getContext())
                .setAdapter(adapter, null)
                .create();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        // Lift all of the menu items from the underlying menu. The underlying menu should have
        // been populated already, so it contains all the items for which we want to display shortcuts
        int numberOfItems = menu.size();
        ArrayList<MenuItem> items = new ArrayList<>(numberOfItems);
        for (int i = 0; i < numberOfItems; i++) {
            MenuItem item = menu.getItem(i);
            items.add(item);
        }

        // Now that we have the items, add them all to the view
        adapter.setItems(items);
    }
}
