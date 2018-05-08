[TOC]

# 参考地址
1. [ARouter GitHub](https://github.com/alibaba/ARouter)

# 组件化配置
1. 在根目录的config.gradle中的componentsInfo中添加组件信息
2. 在app的build.gradle中添加组件，如`compile project(":LoginModule")`
3. 在main目录下添加debug目录，分别有`java`，`res`，`AndroidManifest.xml`
4. 在组件的build.gradle中配置，主要有以下内容，具体请参考项目中3个***Module中的配置
```
apply plugin: 'com.android.library' or apply plugin: 'com.android.application'
applicationId
resourcePrefix
sourceSets
```
5. 组件化方式运行时， 需要将config.gradle中的isComponent设为true，集成打包时，需要设置为false，修改完成后，需要重新执行`Sync Project With Gradle Files`

# 踩坑记录
1. build.gradle中指定AndroidManifest.xml文件的时候，直接复制其他项目中的build.gradle时，manifest会改为Manifest，需要手动修改为小写
2. 使用拦截器Interceptor是，但声明一个Interceptor，必须执行`callback.onContinue`或`callback.onInterrupt`，否则会不往下执行
3. 如果出现灵异事件，建议clean project
4. 牢记组件为library 和 application在AS中icon的区别