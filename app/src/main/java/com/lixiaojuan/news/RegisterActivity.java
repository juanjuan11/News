package com.lixiaojuan.news;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class RegisterActivity extends Activity{
    private EditText etPhone,etPassword,etConfirmPassword;
    String phone,password,confirmPassword;
    private Button btnRegister;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }

    private void initView() {
        etPhone=findViewById(R.id.et_phone);
        etPassword=findViewById(R.id.et_password);
        etConfirmPassword=findViewById(R.id.et_confirm_password);
        btnRegister=findViewById(R.id.btn_register);
    }

    public void register(View view){
        getEditTextString();
        if (TextUtils.isEmpty(phone)){
            Toast.makeText(this,"请您输入手机号",Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(password)){
            Toast.makeText(this,"请您输入密码",Toast.LENGTH_SHORT).show();
        }else if (TextUtils.isEmpty(confirmPassword)){
            Toast.makeText(this,"请再次输入密码",Toast.LENGTH_SHORT).show();
        }else if (!password.equals(confirmPassword)){
            Toast.makeText(this,"密码与确认密码不一致",Toast.LENGTH_SHORT).show();
        }else if (isExistPhone(phone)){
            Toast.makeText(this,"此手机号已被注册过",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
            //把手机号、密码和账号标识保存到sp里面
            /**
             * 保存账号和密码到SharedPreferences中
             */
            saveRegisterInfo(phone,password);
            //注册成功后把账号传递到LoginActivity.java中
            // 返回值到loginActivity显示
            Intent intent=new Intent();
            intent.putExtra("phone",phone);
            setResult(RESULT_OK, intent);
            //RESULT_OK为Activity系统常量，状态码为-1，
            // 表示此页面下的内容操作成功将intent返回到上一页面，如果是用back返回过去的则不存在用setResult传递data值
           finish();
        }

    }

    /**
     * 获取控件中的字符串
     */
    private void getEditTextString() {
        phone=etPhone.getText().toString();
        password=etPassword.getText().toString();
        confirmPassword=etConfirmPassword.getText().toString();
    }

    /**
     * 判断SharedPreferences是否存在手机号
     * @param phone
     * @return
     */
    private boolean isExistPhone(String phone){
        boolean isExistPhone=false;
        SharedPreferences sp=getSharedPreferences("loginInfo",MODE_PRIVATE);
        String spPassword=sp.getString(phone,"");//根据传入的手机号获取密码
        if (!TextUtils.isEmpty(spPassword)){//密码不为空 说明已保存过这个手机号
            isExistPhone=true;
        }
        return isExistPhone;
    }


    /**
     * 保存注册信息
     * @param phone
     * @param password
     */
    private void saveRegisterInfo(String phone,String password){
        SharedPreferences sp=getSharedPreferences("loginInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString(phone,password);//把手机号密码保存进去
        editor.commit();//提交修改
    }
}
