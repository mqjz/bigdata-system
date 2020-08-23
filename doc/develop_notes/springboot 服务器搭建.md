# springboot  restful 环境搭建步骤

1. maven 原始路径下载速度慢，更改仓库到Alibaba, 在maven目录下找到conf文件夹下的settings.xml文件，在mirrors的子节点添加以下配置,编程工具

```xml
 <mirror>
        <id>nexus-aliyun</id>
        <mirrorOf>*</mirrorOf>
        <name>Nexus aliyun</name>
        <url>http://maven.aliyun.com/nexus/content/groups/public</url>
</mirror>
```

2. 创建springboot 项目, url 选择  https://start.aliyun.com

   ![image-20200823151333146](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200823151333146.png)

   2. 填写项目配置![image-20200823151450742](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200823151450742.png)

      ![image-20200823151517141](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200823151517141.png)![image-20200823151541896](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200823151541896.png)

      3. 配置数据库链接选项

         ![image-20200823151607359](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200823151607359.png)

         ```properties
         # mybatis xml 文件路径
         mybatis.mapper-locations=classpath:mapper/*Mapper.xml
         # mybatis pojo文件路径
         mybatis.type-aliases-package=com.goodix.hi.bigdata.system.dao
         # 数据库链接选项
         spring.datasource.url=jdbc:mysql://localhost:3306/hi-database?serverTimezone=UTC
         # 数据库用户名
         spring.datasource.username=root
         # 数据库密码
         spring.datasource.password=123456
         # 数据库驱动
         spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
         ```

# 代码

## 代码结构

## ![image-20200823152237516](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200823152237516.png)

1. controller

   ```java
   @RestController
   @RequestMapping("/user")
   public class UserController {
   
       @Resource
       UserService userService;
   
       @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
       User selectUser(@PathVariable int id) {
           return userService.selectUser(id);
       }
   }
   ```

2. service

   ```java
   @Service
   public class UserService {
   
       @Resource
       UserMapper userMapper;
   
       public User selectUser(int id) {
           User u = userMapper.slelctUser(id);
           return u;
       }
   }
   ```

3. dao

   ```java
   @Data
   public class User {
       private int id;
       private String name;
       private int age;
   }
   ```

4. mapper

   ```java
   @Repository
   public interface UserMapper {
   
       @Select("select * from user where id = #{id}")
       User slelctUser(int id);
   
   }
   ```

## 错误
1. mysql 错误

The server time zone value '�й���׼ʱ��' is unrecognized or represents more than one time zone. You must configure either the server or JDBC driver (via the 'serverTimezone' configuration property) to use a more specifc time zone value if you want to utilize time zone support.

```
mysql 链接配置添加时区
spring.datasource.url=jdbc:mysql://localhost:3306/hi-database
spring.datasource.url=jdbc:mysql://localhost:3306/hi-database?serverTimezone=UTC
```

2. 解决org.apache.ibatis.binding.BindingException: Invalid bound statement (not found)问题

   mybatis.mapper-locations 路径配置错误

![image-20200823175920742](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20200823175920742.png)