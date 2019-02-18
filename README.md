# fbLogin
 
 please add below path in your project level gradle file. 
  
  maven { url 'https://jitpack.io' } 
    
    or like   

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  Add   implementation 'com.github.hafeezsohaib:fbLogin:1.0.1'  it
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
  callback method of above interface  in facebookUserInfo hvae all info about user name email bday etc.
  
  @Override
    public void callBackFaceBook(FaceBookUserInfo faceBookUserInfo) {
      faceBookUserInfo=null;
    }
  
