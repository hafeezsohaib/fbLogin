package com.khan.mysociallogin;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.gson.Gson;
import org.json.JSONException;
import org.json.JSONObject;

public class SocialLogin {
    private int code=0;
    private static CallbackManager callbackManager;

    public static  void loginFb(final Context context){

        LoginButton loginButton=new LoginButton(context);
        loginButton.setReadPermissions("email");

        callbackManager = CallbackManager.Factory.create();
        loginButton.performClick();

        loginButton.registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                getFacebookData(loginResult,context);
                Toast.makeText(context,"Login...",Toast.LENGTH_SHORT).show(); }
            @Override
            public void onCancel() {
                Toast.makeText(context,"Some thing went wrong",Toast.LENGTH_SHORT).show(); }
            @Override
            public void onError(FacebookException exception) {
                Toast.makeText(context,"Some thing went wrong",Toast.LENGTH_SHORT).show(); }
        });
    }



    private  static void   getFacebookData(LoginResult loginResult, final Context context){
        GraphRequest request = GraphRequest.newMeRequest(loginResult.getAccessToken(),new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                FaceBookUserInfo faceBookUserInfo = new Gson().fromJson(object.toString(), FaceBookUserInfo.class);
               if(faceBookUserInfo.gender!=null)
                faceBookUserInfo.gender= String.valueOf(faceBookUserInfo.gender.charAt(0)).toUpperCase();
                try {
                    faceBookUserInfo.userPicture=object.getJSONObject("picture").getJSONObject("data")
                            .getString("url");

                } catch (JSONException e) {
                    e.printStackTrace();
                }
                ((FBListner)context).callBackFaceBook(faceBookUserInfo);
            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,first_name,last_name,gender, email,birthday,picture.type(large)");
        request.setParameters(parameters);
        request.executeAsync();
    }

    public static void callBack(int requestCode, int resultCode, Intent data){ callbackManager.onActivityResult(requestCode,resultCode,data); }

    public  interface FBListner {
        void callBackFaceBook(FaceBookUserInfo faceBookUserInfo);}
}
