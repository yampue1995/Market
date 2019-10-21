package www.edwarerazo.market;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import www.edwarerazo.market.classes.connectionDB;

public class signup extends AppCompatActivity {

    EditText email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //Calls ids
        email = findViewById(R.id.emailS);
    }

    public void register (View view){
        //1. Create Database Manager
        connectionDB manager = new connectionDB(this, "data",null, 1);
        //2. Let database Read/Write
        SQLiteDatabase market = manager.getWritableDatabase();
        //3. Get values /text /numbers
        String EmailO = email.getText().toString();
        String FNAME = email.getText().toString();
        String LNAME = email.getText().toString();
        String PWS = email.getText().toString();
        //4. Create content values
        ContentValues data = new ContentValues();
        //5. create data pack
        data.put("email",EmailO);
        data.put("fistname",FNAME);
        data.put("lastname",LNAME);
        data.put("password",PWS);
        //6. save data into market database
        market.insert("users",null,data);
        Toast.makeText(this, "the user has been created !!", Toast.LENGTH_SHORT).show(); //7.
        //7. Close connection
        market.close();

    }
}
