package smrt.com.quran;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyDatabase mydb = null;
        try {
            mydb = new MyDatabase(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        final SQLiteDatabase database = mydb.getReadableDatabase();
        mydb.opendatabase();
        Cursor cu = database.rawQuery("SELECT persian FROM table1", null);
        while (cu.moveToNext()) {
            try {

                Toast.makeText(getApplicationContext(), cu.getString(0) , Toast.LENGTH_LONG).show();

            }
            catch (Exception e) {

            }

        }
        cu.close();
        database.close();



    }
}
