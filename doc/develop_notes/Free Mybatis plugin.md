# 2019版本IDEA 使用mybatis插件Free Mybatis plugin

[![img](https://upload.jianshu.io/users/upload_avatars/1205414/8c7389ae-ba2a-4743-b070-51f892776a6e.png?imageMogr2/auto-orient/strip|imageView2/1/w/96/h/96/format/webp)](https://www.jianshu.com/u/6a24efcd67ec)

[Lazy1](https://www.jianshu.com/u/6a24efcd67ec)关注

0.1382020.01.08 16:27:14字数 263阅读 17,282

- ![img](https://upload-images.jianshu.io/upload_images/1205414-fc1053354d555878.jpg?imageMogr2/auto-orient/strip|imageView2/2/w/1155/format/webp)

  微信截图_20200108160829.png

- 首先安装插件如图所示选择第一个插件安装，安装完毕重启IDEA

- 然后我们选择我们已经配置好的数据库如下图

![img](https://upload-images.jianshu.io/upload_images/1205414-a9bd74dc63a6d1d6.jpg?imageMogr2/auto-orient/strip|imageView2/2/w/454/format/webp)

微信截图_20200108161048.png

- 在需要生成配置文件的数据库上右键，就会出现mybatis-generator选项打开这个

![img](https://upload-images.jianshu.io/upload_images/1205414-6d0eb72b7e1fa0bb.jpg?imageMogr2/auto-orient/strip|imageView2/2/w/1179/format/webp)

微信截图_20200108161210.png

- 就打开如上图所示配置窗口，这里我们使用默认的就行，如果不想使用lombok去掉这个勾选即可，然后我们选择ok即可

![img](https://upload-images.jianshu.io/upload_images/1205414-567f0dec063f3b2d.jpg?imageMogr2/auto-orient/strip|imageView2/2/w/279/format/webp)

微信截图_20200108161516.png

- 就会生成以上文件,一个数据库的映射类，一个操作数据库的映射接口，和具体操作数据库的xml，主配置文件就在Configure里面这个自己生成

![img](https://upload-images.jianshu.io/upload_images/1205414-aba4123214eb7663.jpg?imageMogr2/auto-orient/strip|imageView2/2/w/653/format/webp)

微信截图_20200108161657.png

- 我们打开生成的接口具体操作数据的，就可以看到右边右箭头可以点击，就可以跳转到具体的映射xml

![img](https://upload-images.jianshu.io/upload_images/1205414-e31860b87eadf8b7.jpg?imageMogr2/auto-orient/strip|imageView2/2/w/844/format/webp)

微信截图_20200108161854.png

- 可以看到xml也可以直接跳转到具体的接口,下面就可以操作数据库了



```java
  private static SqlSessionFactory sqlSessionFactory;
     private static Reader reader;
 
     static {
         try {
             reader = Resources.getResourceAsReader("Configure.xml");
             sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     public static SqlSessionFactory getSession() {
         return sqlSessionFactory;
     }
 
 
     public static void main(String[] args) {
         SqlSession session = sqlSessionFactory.openSession();
         try {
             UserDao mapper = session.getMapper(UserDao.class);
             User user =mapper.selectByPrimaryKey(1L);
             if(user!=null){
                 String userInfo =user.toString();
                 System.out.println(userInfo);
             }
         } finally {
             session.close();
         }
     }
```