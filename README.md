# 这是什么

一个Android开发用的工具集  
因为没有电脑 仅支持AIDE使用

## 注意

因为AIDE未支持使用jar包内非英文类类/方法  
所以使用引用工程的方式使用  

# 使用说明

## 导入

将整个项目克隆到一个 文件夹内  
[这个文件夹和工程文件夹同目录]  
也就是下面说的根文件夹

```gradle

dependencies {

    compile project('<文件夹名>/<引用的工具>')
    ...
}

```

### 说明

需要将本工程下build.gradle  
复制到根文件夹  
否则AIDE不会自动下载依赖库

## 所有

### 基本

一些常用工具类 不含Android类调用  
注意: 其他部分都会引用 不用手动引用

### 安卓

框架主体 工具类/视图等各种封装

### 数据

常用数据格式的操作  
  
- JSON
- Properties
- XML
- YAML
  
支持序列化/读取Bean对象

### 网络

基于okhttp的网络封装  
一行Post文件/JSON传参

### 辅助

Android辅助服务操作封装

### PDF

封装了 PDF视图 打开PDF文件  
注意 : 只能在界面使用  
悬浮窗 等无法显示该控件(不知为啥

### v2ray

v2ray客户端 不了解的算了  
自动解析不同配置 (原生配置即可)

### 二维码

封装了基于zxing的二维码操作  
生成二维码支持 :  
- 修改背景颜色
- 修改二维码颜色
- 添加中央的图标

### 后端

基于LeanCloud的后端封装  

### 图灵

封装了图灵机器人的API  
支持多用户 请求出错换APIKEY

### 拦截

封装了Xposed的一些操作  
(未完善具体操作

### 脚本

基于Mozilla Rhino的中英文脚本引擎   
但速度不理想 速度低于Lua但比BeanShell快

### 其他不常用的

编辑器: 一个代码编辑器  
编译: java/axml/dex/apk/jks操作
