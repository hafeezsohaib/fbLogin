# fbLogin, #SocialLogin,#FaceBookLogin
its very fast Code it will take only 30 sec for login and get the user Information like Name ,email ,gender etc
 
 There is no need to add fb integration and fb login button in xml or activity 
 two line of code for login and get the user Info.
 
 please add below path in your project level gradle file. 
  
  maven { url 'https://jitpack.io' } 
    
    or like   

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  Add   implementation 'com.github.hafeezsohaib:fbLogin:1.0.2'  it
  in app level gradle file.
  
  after sync the project 
  call below  method in any button click or where you want to fb login action.
  
  SocialLogin.loginFb(this);
  
  then used it in onActivityResult 
  
  SocialLogin.callBack(requestCode, resultCode, data);
  
   @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        SocialLogin.callBack(requestCode, resultCode, data);
    }
  
  after that  just use the interface 
  
  Activity implement SocialLogin.FBListner 
  
  in your Activity or fragment you have to override the 
  callback method of above interface  in facebookUserInfo have all info about user name email bday etc.
  
  @Override
    public void callBackFaceBook(FaceBookUserInfo faceBookUserInfo) {
      
    }
  
