package com.volkhart.keyboardshortcuts;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public final class KeyboardShortcutsFragment extends Fragment {

    public static final String TAG = "KeyboardShortcutsFragment";

    public static KeyboardShortcutsFragment newInstance() {
        return new KeyboardShortcutsFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean hasHardwareKeyboard = getResources().getConfiguration().keyboard == Configuration.KEYBOARD_QWERTY;
        setHasOptionsMenu(hasHardwareKeyboard);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.keyboardshortcuts_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.keyboardshortcuts_action_keyboard_shortcuts) {
            new KeyboardShortcutsDialogFragment().show(getFragmentManager(), KeyboardShortcutsDialogFragment.TAG);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
