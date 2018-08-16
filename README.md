# LeanCloudSNSDemo-Android
 
## Android AVUser 第三方登录示例 Demo
 
 
此 Demo 以微信为例子，演示了如果使用 AuthData 登录或注册 AVUser，同时演示了如何使用 UnionID 的方式登录。

AuthData 的格式以微信为例：

```
//AuthData 格式
{
"access_token":"ACCESS_TOKEN", 
"expires_in":7200, 
"refresh_token":"REFRESH_TOKEN",
"openid":"OPENID", 
"scope":"SCOPE",
"unionid":"o6_bmasdasdsad6_2sgVt7hMZOPfL"
}

```
AuthData 需要从微信官方提供的 SDK 获取到，或者使用第三方提供的社交登录组件获取。LeanCloud 不提供获取 authData 的方法。

此 Demo 使用 [Share SDK](http://wiki.mob.com/获取授权用户资料-2/) 的相关登录授权接口获取到 AuthData，然后使用此 AuthData 来演示 AVUser 的第三方登录。

## Demo 详细

Demo 运行效果如下图所示：

http://lc-I94is3iS.cn-n1.lcfile.com/2246a554fdbb996e7862.png

Demo 中一共演示下面三种情况，更多的使用细节请参考文档。

### 1.微信 AuthData 登录

演示使用 AuthData（OpenID）登录或注册 AVUser，以微信登录为例。

### 2.微信 UnionID 登录
演示使用带有 UnionID 的 AuthData 登录或注册 AVUser。

### 3.LeanCloud 用户绑定微信
演示已经登录的 AVUser 如何绑定微信。

