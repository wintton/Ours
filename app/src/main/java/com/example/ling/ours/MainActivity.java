package com.example.ling.ours;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView  heartimage;
    private EditText   edit_username;
    private EditText   edit_userpwd;
    private Button     button_login;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_new);
        init();
        bindviews();
        bindviewlisenter();
        creatanmi();

    }

    private void init() {
        builder = new AlertDialog.Builder(MainActivity.this);
    }
    private void bindviewlisenter() {
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edit_username.getText().toString();
                String userpwd= edit_userpwd.getText().toString();
                if (username.length() == 0){
                    showdialog("请输入账号");
                    return;
                }
                if (userpwd.length() == 0){
                    showdialog("请输入密码");
                    return;
                }
                if ("850127575".equalsIgnoreCase(username) && "520".equalsIgnoreCase(userpwd)){
                    Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this,OurActivity.class);
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                    button_login.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            MainActivity.this.finish();
                        }
                    },1000);

                }else{
                    showdialog("账号名或者密码不正确！");
                }
            }
        });
    }
    private void showdialog(String msg){
        builder.setTitle("提示");
        builder.setMessage(msg);
        builder.create().show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void bindviews() {
        heartimage = (ImageView)this.findViewById(R.id.image_main);
        edit_username = (EditText)this.findViewById(R.id.edit_username);
        edit_userpwd = (EditText)this.findViewById(R.id.edit_password);
        button_login = (Button)this.findViewById(R.id.btn_login);
    }
    private void creatanmi(){
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.7f,1f,0.7f,1f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setRepeatCount(Animation.INFINITE);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setStartOffset(500);
        heartimage.startAnimation(scaleAnimation);
    }
}
