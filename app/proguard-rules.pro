# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in E:\sdk\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in E:\sdk\sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}


-keep public class * extends android.app.Activity
-keep public class * extends android.app.Fragment
-keep public class * extends android.support.v4.app.Fragment



-libraryjars 'io.reactivex:rxjava:1.1.3'
-libraryjars 'io.reactivex:rxandroid:1.1.0'
-libraryjars 'com.squareup.retrofit2:retrofit:2.0.2'
-libraryjars 'com.squareup.retrofit2:converter-gson:2.0.2'
-libraryjars 'com.squareup.retrofit2:adapter-rxjava:2.0.2'
-libraryjars 'com.github.bumptech.glide:glide:3.7.0'
-libraryjars 'com.rengwuxian.materialedittext:library:2.1.4'
-libraryjars 'com.jakewharton:butterknife:7.0.1'
-libraryjars 'com.jakewharton.rxbinding:rxbinding:0.4.0'
-libraryjars 'com.github.liuguangqiang.swipeback:library:1.0.2'
-libraryjars 'org.greenrobot:greendao:2.2.0'
-libraryjars 'de.hdodenhof:circleimageview:2.0.0'

 -keepclasseswithmembernames class * {
    native <methods>;
 }

-keep public class com.null.test.ui.fragment.** {*;}
# 保留自定义控件不能被混淆
-keep public class * extends android.view.View {
    public <init>(android.content.Context);
    public <init>(android.content.Context, android.util.AttributeSet);
    public <init>(android.content.Context, android.util.AttributeSet, int);
    public void set*(***);
    *** get* ();
}

# 保留Parcelable序列化的类不能被混淆
-keep class * implements android.os.Parcelable{
    public static final android.os.Parcelable$Creator *;
}


# 保留Serializable 序列化的类不被混淆
-keepclassmembers class * implements java.io.Serializable {
   static final long serialVersionUID;
   private static final java.io.ObjectStreamField[] serialPersistentFields;
   !static !transient <fields>;
   private void writeObject(java.io.ObjectOutputStream);
   private void readObject(java.io.ObjectInputStream);
   java.lang.Object writeReplace();
   java.lang.Object readResolve();
}

# 对R文件下的所有类及其方法，都不能被混淆
-keepclassmembers class **.R$* {
    *;
}

# 对于带有回调函数onXXEvent的，不能混淆
-keepclassmembers class * {
    void *(**On*Event);
}

-keepclassmembers class * {
    void *(**Callback);
}


#混淆butterknife

-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }

-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}

-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}





