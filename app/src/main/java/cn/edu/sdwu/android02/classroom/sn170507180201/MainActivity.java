package cn.edu.sdwu.android02.classroom.sn170507180201;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startSubActivity(View v) {
        //启动 sub actity
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode,@Nullable Intent data) {

        //3.在父Activity中获取返回值
        // requestCode用来区分从哪一个子activity返回的结果
        if(requestCode==101){
            if(requestCode==RESULT_OK){
                //用户点击确认，进一步获取数据
                String name=data.getStringExtra("name");
                Toast.makeText(this,name,Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"cancel",Toast.LENGTH_SHORT).show();
            }
        }

    }

}

