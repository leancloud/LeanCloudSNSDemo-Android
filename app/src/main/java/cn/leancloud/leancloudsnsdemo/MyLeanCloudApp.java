package cn.leancloud.leancloudsnsdemo;

import android.app.Application;

import com.mob.MobSDK;

import cn.leancloud.AVLogger;
import cn.leancloud.AVOSCloud;

/**
 * Created by BinaryHB on 2018/5/11.
 */

public class MyLeanCloudApp extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    AVOSCloud.setLogLevel(AVLogger.Level.DEBUG);
    // 初始化参数依次为 this, AppId, AppKey
    AVOSCloud.initialize(this, "I94is3iS8CzyLsY4lmYz2HjT-gzGzoHsz", "yDObYfeTC9Y0e1aqT7nrWJgu");

    MobSDK.init(this);

  }
}
