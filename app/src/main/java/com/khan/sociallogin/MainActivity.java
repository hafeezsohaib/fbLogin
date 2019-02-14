package com.khan.sociallogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.khan.mysociallogin.FaceBookUserInfo;
import com.khan.mysociallogin.MyLogin;
import com.khan.mysociallogin.SocialLogin;


public class MainActivity extends AppCompatActivity implements SocialLogin.FBListner {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SocialLogin.loginFb(MainActivity.this);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
           SocialLogin.callBack(requestCode, resultCode, data);
    }

    @Override
    public void callBackFaceBook(FaceBookUserInfo faceBookUserInfo) { }
}
