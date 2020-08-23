一、下载安装包
MySQL安装有两种格式，一种是msi格式的，一种是zip格式的。如果是msi格式，可以直接点击安装，按照给出的安装提示进行安装就可以了，如果是zip格式是自己解压，解压缩之后就可以使用了，但是要进行配置。我这里是使用zip格式的，然后进行知己配置的。

点击下载MySQL安装文件

下载完成之后解压，解压完是这个样子的:



二、配置初始化my.ini文件、配置环境变量
这个版本的MySQL安装文件是没有my.ini配置文件的，需要自己手动创建这个文件，然后写入基本的配置项:

[mysqld]
# 设置3306端口
port=3306
# 设置mysql的安装目录
basedir=D:\MySQL
# 设置mysql数据库的数据的存放目录
datadir=D:\MySQL\Data<br># 允许最大连接数
max_connections=200
# 允许连接失败的次数。
max_connect_errors=10
# 服务端使用的字符集默认为utf8mb4
character-set-server=utf8mb4
# 创建新表时将使用的默认存储引擎
default-storage-engine=INNODB
# 默认使用“mysql_native_password”插件认证
#mysql_native_password
default_authentication_plugin=mysql_native_password
[mysql]
# 设置mysql客户端默认字符集
default-character-set=utf8mb4
[client]
# 设置mysql客户端连接服务端时默认使用的端口
port=3306
default-character-set=utf8mb4
在这个配置文件中需要修改的配置项是

basedir=D:\MySQL（mysql所在目录） 

datadir=D:\MySQL\data（mysql所在目录\data）

把这文件放在安装包的根目录就可以了，另外需要注意的是，安装文件中需要data文件夹，这个不需要手动创建

# 配置环境变量也很简单：
我的电脑->属性->高级->环境变量
选择PATH,在其后面添加: 你的mysql到 bin文件夹的路径即可

## 初始化MySQL
在安装时，应该以管理员身份运行cmd，不然，在安装时会报错，会导致安装失败的情况

## 打开后进入MySQL的bin目录，并在MySQL的bin目录下面执行命令:

mysqld --initialize --console

注意:[MY-010454] [服务器]为root @ localhost生成临时密码：9P0gYk-？0，kT其中root @ localhost：后面的9P0gYk-？0，kT就是初始密码（不含首位空格）。在没有更改密码前，需要记住这个密码，后续登录需要用到。复制密码先保存起来。

注意即使以管理员身份运行，执行这个步骤的时候也可能会报错。
原因：
之所以出现报错，是因为之前MySQL已经安装成功了，只是用Navicat或者是dos窗口连接数据库时，报”1045 access denied 。。。。“的错误
解决办法:
删除MySQL文件中data文件夹，然后按照下面的步骤继续执行
# 三、安装MySQL服务
如果真的是像上面说的报1045的错误，按照下面的操作步骤执行，如何没有报1045的错误，可以直接执行安装MySQL服务的命令。 第一、 使用sc删除之前的MySQL服务 删除MySQL服务的命令

sc delete mysql
删除之前安装的MySQL服务成功之后，重新执行安装MySQL的命令 执行以下命令安装MySQL服务:

mysqld --install

执行安装MySQL服务的命令时，可能会提示 VCRUNTIME140_1.dll文件，然后按照提示，把电脑安装一下这个文件就可以了，安装成功之后，应该就可以成功安装MySQL服务了

MySQL服务安装成功之后通过 net start mysql命令启动MySQL服务

四、连接MySQL、修改密码
使用dos窗口在MySQL的bin目录下连接数据库执行

mysql -u root -p
然后输入刚才保存的临时密码 然后回车，就应该已经连接到MySQL数据库了 然后执行

ALTER USER 'root'@'localhost' IDENTIFIED BY '123456';
修改密码成功之后

exit;
　　
最后，再下载个Navicat可视化工具连接数据库，登陆时，使用刚才修改成功之后的密码

选择PATH,在其后面添加: 你的mysql bin文件夹的路径