## 数据库（mysql、redis、mongo）从基本连接到框架使用
### 一、使用原始的拦截数据库的方法
#### 1.1、MySQL
**步骤：**
- 1）系统(linux、window等)安装mysql
- 2）项目导入mysql驱动
```
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.20</version>
</dependency>
```
- 3）使用mysql
#### 1.2、redis
**步骤：**
- 1）系统(linux、window等)安装[redis](https://redis.io/)
- 2）项目导入redis驱动
```
<dependency>
    <groupId>redis.clients</groupId>
    <artifactId>jedis</artifactId>
    <version>3.1.0</version>
</dependency>
```
- 3）使用redis
#### 1.3、mongo
**步骤：**
- 1）系统(linux、window等)安装mongo
- 2）项目导入mongo驱动
- 3）使用mongo
