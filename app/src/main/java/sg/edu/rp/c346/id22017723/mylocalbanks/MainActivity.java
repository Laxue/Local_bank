package sg.edu.rp.c346.id22017723.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView dbs;
    TextView ocbc;
    TextView uob;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbs = findViewById(R.id.dbs);
        ocbc = findViewById(R.id.ocbc);
        uob = findViewById(R.id.uob);

        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            dbs.setText(getString(R.string.dbs));
            ocbc.setText(getString(R.string.ocbc));
            uob.setText(getString(R.string.uob));
            return true;
        } else if (id == R.id.ChineseSelection) {
            dbs.setText(getString(R.string.dbscl));
            ocbc.setText(getString(R.string.ocbccl));
            uob.setText(getString(R.string.uobcl));
            return true;
        } else {
            dbs.setText(getString(R.string.error));
            ocbc.setText(getString(R.string.error));
            uob.setText(getString(R.string.error));
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v== dbs){
            wordClicked = "dbs";
        }
        else if (v == ocbc){
            wordClicked = "ocbc";
        }else if (v == uob){
            wordClicked = "uob";}

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                //code for action
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
                return true; //menu item successfully handled
            } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                //code for action
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.dbstele)));
                startActivity(intent);
                return true;  //menu item successfully handled
            }
            } else if (wordClicked.equalsIgnoreCase("ocbc")) {
                if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                    //code for action
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                    startActivity(intent);
                    return true; //menu item successfully handled
                } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                    //code for action
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.ocbctele)));
                    startActivity(intent);
                    return true;  //menu item successfully handled
                }
            } else if (wordClicked.equalsIgnoreCase("uob")) {
                if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
                    //code for action
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                    startActivity(intent);
                    return true; //menu item successfully handled
                } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
                    //code for action
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + getString(R.string.uobtele)));
                    startActivity(intent);
                    return true;  //menu item successfully handled
                }
            }
            return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
}