package com.volkhart.keyboardshortcuts.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.volkhart.keyboardshortcuts.KeyboardShortcutsFragment;

public final class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {

            // Is the first launch
            getSupportFragmentManager().beginTransaction()
                    .add(KeyboardShortcutsFragment.newInstance(), KeyboardShortcutsFragment.TAG)
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_save:
                Toast.makeText(this, R.string.message_saving, Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
