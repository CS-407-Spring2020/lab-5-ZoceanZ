package c.sakshi.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String key = "username";
        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        if(!sharedPreferences.getString(key, "").equals("")){

            goToAct2(sharedPreferences.getString(key, ""));
        }
        else{
            //Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_main);
        }


    }
    public void onButtonClick(View view){
        EditText field = (EditText) findViewById(R.id.username);
        SharedPreferences sharedPreferences = getSharedPreferences("c.sakshi.lab5", Context.MODE_PRIVATE);
        sharedPreferences.edit().putString("username", field.getText().toString()).apply();
        //Toast.makeText(getApplicationContext(),sharedPreferences.getString("username",""),Toast.LENGTH_SHORT).show();
        String s = field.getText().toString();
        goToAct2(s);
    }
    public void goToAct2(String s){
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("message",s);
        startActivity(intent);
    }
}
