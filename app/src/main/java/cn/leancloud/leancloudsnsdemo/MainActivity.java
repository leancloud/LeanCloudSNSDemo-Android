package cn.leancloud.leancloudsnsdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.LogInCallback;
import com.avos.avoscloud.SaveCallback;

import java.util.HashMap;
import java.util.Map;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.wechat.friends.Wechat;

public class MainActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // 微信 autaData 登录
    findViewById(R.id.weixin_authdata_main).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Platform wechat = ShareSDK.getPlatform(Wechat.NAME);
        wechat.setPlatformActionListener(new PlatformActionListener() {
          @Override
          public void onComplete(final Platform platform, int i, HashMap<String, Object> hashMap) {

            final Map<String, Object> map = new HashMap<>();
            map.put("access_token", platform.getDb().getToken());
            map.put("expires_in", platform.getDb().getExpiresIn());
            map.put("openid", platform.getDb().getUserId());

            AVUser.loginWithAuthData(map, "weixin", new LogInCallback<AVUser>() {
              @Override
              public void done(AVUser avUser, AVException e) {
                if (e == null) {

                } else {
                  e.printStackTrace();
                }
              }
            });

          }

          @Override
          public void onError(Platform platform, int i, Throwable throwable) {

          }

          @Override
          public void onCancel(Platform platform, int i) {

          }
        });

        wechat.authorize();
      }
    });


    // 微信 unionid 登录
    findViewById(R.id.weixin_unionid_main).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Platform wechat = ShareSDK.getPlatform(Wechat.NAME);
        wechat.setPlatformActionListener(new PlatformActionListener() {
          @Override
          public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {

            final Map<String, Object> map = new HashMap<>();
            map.put("access_token", platform.getDb().getToken());
            map.put("expires_in", platform.getDb().getExpiresIn());
            map.put("openid", platform.getDb().getUserId());

            AVUser.loginWithAuthData(map, "weixinapp1", platform.getDb().get("unionid"), "weixin", true, new LogInCallback<AVUser>() {
              @Override
              public void done(final AVUser avUser, AVException e) {
                if (e == null) {

                } else {
                  e.printStackTrace();
                }
              }
            });

          }

          @Override
          public void onError(Platform platform, int i, Throwable throwable) {

          }

          @Override
          public void onCancel(Platform platform, int i) {

          }
        });

        wechat.authorize();
      }
    });


    // LeanCloud 绑定绑定微信
    findViewById(R.id.weixin_associate_main).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        // 已经注册过用户名为 Jerry 的用户
//        AVUser avUser = new AVUser();
//        avUser.setUsername("Jerry");
//        avUser.setPassword("123456");
//        avUser.signUpInBackground(new SignUpCallback() {
//          @Override
//          public void done(AVException e) {
//
//          }
//        });

        Platform wechat = ShareSDK.getPlatform(Wechat.NAME);
        wechat.setPlatformActionListener(new PlatformActionListener() {
          @Override
          public void onComplete(final Platform platform, int i, HashMap<String, Object> hashMap) {

            final Map<String, Object> map = new HashMap<>();
            map.put("access_token", platform.getDb().getToken());
            map.put("expires_in", platform.getDb().getExpiresIn());
            map.put("openid", platform.getDb().getUserId());

            AVUser.logInInBackground("Jerry", "123456", new LogInCallback<AVUser>() {
              @Override
              public void done(AVUser avUser, AVException e) {
                avUser.associateWithAuthData(map, "weixin", new SaveCallback() {
                  @Override
                  public void done(AVException e) {

                  }
                });
              }
            });


          }

          @Override
          public void onError(Platform platform, int i, Throwable throwable) {

          }

          @Override
          public void onCancel(Platform platform, int i) {

          }
        });

        wechat.authorize();
      }
    });

    // 解绑微信
    findViewById(R.id.weixin_unassociate_main).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {

        // 已经注册过用户名为 Jerry 的用户，并且该用户绑定了 weixin 平台的 authData

        AVUser.logInInBackground("Jerry", "123456", new LogInCallback<AVUser>() {
          @Override
          public void done(AVUser avUser, AVException e) {
            avUser.dissociateAuthData("weixin", new SaveCallback() {
              @Override
              public void done(AVException e) {

              }
            });
          }
        });
      }
    });

  }
}
