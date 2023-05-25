package sg.edu.rp.c346.id22043453.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tvDbs;
    TextView tvOcbc;
    TextView tvUob;
    String wordClicked = "";
    String dbsUrlLink = "";
    String dbsNumPhone = "";
    String ocbcUrlLink = "";
    String ocbcNumPhone = "";
    String uobUrlLink = "";
    String uobNumPhone = "";
    String dbsChineseName = "";
    String ocbcChineseName = "";
    String uobChineseName = "";
    String dbsEnglishName = "";
    String ocbcEnglishName = "";
    String uobEnglishName = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDbs = findViewById(R.id.textViewDBS);
        tvOcbc = findViewById(R.id.textViewOCBC);
        tvUob = findViewById(R.id.textViewUOB);

        dbsUrlLink = getString(R.string.dbsUrl);
        dbsNumPhone = getString(R.string.dbsNum);
        ocbcUrlLink = getString(R.string.ocbcUrl);
        ocbcNumPhone = getString(R.string.ocbcNum);
        uobUrlLink = getString(R.string.uobUrl);
        uobNumPhone = getString(R.string.uobNum);
        dbsChineseName = getString(R.string.dbsChinese);
        ocbcChineseName = getString(R.string.ocbcChinese);
        uobChineseName = getString(R.string.uobChinese);
        dbsEnglishName = getString(R.string.dbs);
        ocbcEnglishName = getString(R.string.ocbc);
        uobEnglishName = getString(R.string.uob);

        registerForContextMenu(tvDbs);
        registerForContextMenu(tvOcbc);
        registerForContextMenu(tvUob);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
        menu.add(0,2,2,"Toggle Favourite");

        if (v == tvDbs) {
            wordClicked = "dbs";
        }
        else if (v == tvOcbc) {
            wordClicked = "ocbc";
        }
        else if (v == tvUob) {
            wordClicked = "uob";
        }
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int itemId = item.getItemId();

        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(dbsUrlLink));
                startActivity(intent);
                return true;
            }
            else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + dbsNumPhone));
                startActivity(intentCall);
            }
            else if (item.getItemId() == 2) {
                // Get from res -> values -> colors.xml
                int red = getResources().getColor(R.color.red);
                int black = getResources().getColor(R.color.black);
                int currentColor = tvDbs.getCurrentTextColor();
                int newColor;

                if (currentColor == red) {
                    newColor = black;
                } else {
                    newColor = red;
                }
                tvDbs.setTextColor(newColor);
            }
        }

        if (wordClicked.equalsIgnoreCase("ocbc")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(ocbcUrlLink));
                startActivity(intent);
                return true;
            }
            else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + ocbcNumPhone));
                startActivity(intentCall);
            }
            else if (item.getItemId() == 2) {
                // Get from res -> values -> colors.xml
                int red = getResources().getColor(R.color.red);
                int black = getResources().getColor(R.color.black);
                int currentColor = tvOcbc.getCurrentTextColor();
                int newColor;

                if (currentColor == red) {
                    newColor = black;
                } else {
                    newColor = red;
                }
                tvOcbc.setTextColor(newColor);
            }
        }

        if (wordClicked.equalsIgnoreCase("uob")) {
            if (item.getItemId() == 0) {
                Intent intent = new Intent(Intent. ACTION_VIEW, Uri.parse(uobUrlLink));
                startActivity(intent);
                return true;
            }
            else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + uobNumPhone));
                startActivity(intentCall);
            }
            else if (item.getItemId() == 2) {
                // Get from res -> values -> colors.xml
                int red = getResources().getColor(R.color.red);
                int black = getResources().getColor(R.color.black);
                int currentColor = tvUob.getCurrentTextColor();
                int newColor;

                if (currentColor == red) {
                    newColor = black;
                } else {
                    newColor = red;
                }
                tvUob.setTextColor(newColor);
            }
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_translated, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDbs.setText(dbsEnglishName);
            tvOcbc.setText(ocbcEnglishName);
            tvUob.setText(uobEnglishName);
            return true;
        }
        else if (id == R.id.ChineseSelection) {
            tvDbs.setText(dbsChineseName);
            tvOcbc.setText(ocbcChineseName);
            tvUob.setText(uobChineseName);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}