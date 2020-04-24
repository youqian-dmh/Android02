package cn.edu.sdwu.android02.classroom.sn170507180201;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ch13Activity1 extends AppCompatActivity {
    private EditText ip;
    private EditText port;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ch13_1);

        ip=(EditText)findViewById(R.id.ch13_1_ip);
        port=(EditText)findViewById(R.id.ch13_1_port);

        SharedPreferences sharedPreference=getSharedPreferences("prefs",MODE_PRIVATE);
        ip.setText(sharedPreference.getString("ip",""));
        port.setText(sharedPreference.getString("port",""));
    }

    public void write(View v){
        EditText editText=(EditText)findViewById(R.id.ch13_1_et);
        String content=editText.getText().toString();
        try{
            FileOutputStream fileOutputStream=openFileOutput("sn1705071802012.txt,",MODE_PRIVATE);

            fileOutputStream.write(content.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();
        }catch(Exception e){
            Log.e(Ch13Activity1.class.toString(),e.toString());
        }
    }

    public void read(View view){
        try {
            FileInputStream fileOutputStream=openFileInput("sn1705071802012.txt");

            int size=fileOutputStream.available();
            byte[] bytes=new byte[size];
            fileOutputStream.read(bytes);//读取字符流
            String content=new String(bytes);//装换成字符串

            fileOutputStream.close();
            Toast.makeText(this,content,Toast.LENGTH_SHORT).show();
        }catch(Exception e){
            Log.e(Ch13Activity1.class.toString(),e.toString());
        }
    }

    public void saveSharePref(View view){
        SharedPreferences sharedPreferences=getSharedPreferences("prefs",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("ip",ip.getText().toString());
        editor.putString("port",port.getText().toString());
        editor.commit();
    }
}
