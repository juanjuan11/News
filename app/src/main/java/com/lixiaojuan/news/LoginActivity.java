package com.lixiaojuan.news;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class LoginActivity extends Activity implements View.OnClickListener {
    private EditText etPhone;
    private EditText etPassword;
    private Button btnLogin;
    private Button btnRegister;
    private CheckBox rememberPassword;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        etPhone=findViewById(R.id.et_phone);
        etPassword=findViewById(R.id.et_password);
        btnLogin=findViewById(R.id.btn_login);
        btnRegister=findViewById(R.id.btn_register);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String phone=etPhone.getText().toString();
                String password=etPassword.getText().toString();
                String spPassword=readPassword(phone);//获取密码


                if (TextUtils.isEmpty(phone)){
                    Toast.makeText(LoginActivity.this,"请输入手机号",Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this,"请输入密码",Toast.LENGTH_SHORT).show();
                }else if (password.equals(spPassword)){//输入密码等于从SharedPreference中拿到的密码 登录成功
                    Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
                    finish();
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);//跳转至主页面
                }
                else if (password!=null&&!TextUtils.isEmpty(password)&&!password.equals(spPassword)){//密码为空 或密码不等于注册时的密码
                    Toast.makeText(LoginActivity.this,"您输入的手机号或密码不正确",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(LoginActivity.this,"此手机号不存在",Toast.LENGTH_SHORT).show();//手机号不存在
                }
                break;
            case R.id.btn_register:
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * 从SharedPreferences根据手机号读取密码
     * @param phone
     * @return
     */
    private String readPassword(String phone){
        //getSharedPreferences("loginInfo",MODE_PRIVATE);
        //"loginInfo",mode_private; MODE_PRIVATE表示可以继续写入
        SharedPreferences sp=getSharedPreferences("loginInfo",MODE_PRIVATE);
        return  sp.getString(phone,"");
    }
}
