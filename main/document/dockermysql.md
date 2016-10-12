# docker部署mysql实例

>希望在自己的机器模拟一下公司中微服务的构建，使用docker部署了mysql实例，使用spring boot进行了CRUD（增删改查）操作进行了一下验证，在后面的学习中也可以尝试更多的框架和组件。ps:我的环境是：ubuntu 14.04, 64位

### 1.获取mysql镜像

从docker hub的仓库中拉取mysql镜像

```bash

sudo docker pull mysql

```

查看镜像

```bash

sudo docker images

mysql latest 18f13d72f7f0 2 weeks ago 383.4 MB

```

### 2.运行一个mysql容器

运行一个mysql实例的命令如下：

```bash

sudo docker run --name first-mysql -p 3306:3306 -e MYSQL\_ROOT\_PASSWORD=123456 -d mysql

5b6bf6f629bfe46b4c8786b555d8db1947680138b2de1f268f310a15ced7247a

```

上述命令各个参数含义：

```

run            运行一个容器

--name         后面是这个镜像的名称

-p 3306:3306   表示在这个容器中使用3306端口(第二个)映射到本机的端口号也为3306(第一个)

-d             表示使用守护进程运行，即服务挂在后台

```

查看当前运行的容器状态：

```bash

sudo docker ps

CONTAINER ID IMAGE COMMAND CREATED STATUS PORTS NAMES5b6bf6f629bf 

mysql "docker-entrypoint.sh" 32 hours ago Up 5 hours 0.0.0.0:3306->3306/tcp first-mysql

```

想要访问mysql数据库，我的机器上需要装一个mysql-client。

```bash

sudo apt-get install mysql-client-core-5.6

```

下面我们使用mysql命令访问服务器，密码如刚才所示为123456,192.168.95.4为我这台机器的ip, 3306为刚才所示的占用本物理机的端口（不是在docker内部的端口）

```bash

mysql -h192.168.95.4 -P3306 -uroot -p123456

```

访问的结果如下：

```

mysql> show databases;

+--------------------+

| Database |

+--------------------+

| information_schema |

| mysql |

| performance_schema |

| sys |

+--------------------+

4 rows in set (0.00 sec)

```

### 3.运行第二个mysql实例

使用docker相对于虚拟机而言的原因是耗费很少的资源，可以"开辟"非常多的隔离的环境，所以我们继续运行第二个mysql实例，还用之前的镜像，名字为second-mysql。

```bash

sudo docker run --name second-mysql -p 3306:3307 -e MYSQL\_ROOT\_PASSWORD=123456 -d 

mysql2de4ddb5bfb9b9434af8e72368631e7f4c3f83ee354157328049d7d0

f5523661docker: Error response from daemon: driver failed programming external connectivity on endpoint second-mysql (33aa29d891a1cb540de250bcbbbe9a0a41cd98f61a4e9f129a2ad5db69da4984): Bind for 0.0.0.0:3306 failed: port is already allocated.

```

为了验证第一个是本机的端口号，就仍然使用了3306这个端口，那么创建如上所示，发生了错误，但是产生了一个容器id，当我们修改端口后还会报错，因为名字冲突了，也即这次失败的创建会占用这个名字：

```

sudo docker run --name second-mysql -p 3307:3306 -e MYSQL\_ROOT\_PASSWORD=123456 -d 

mysqldocker: Error response from daemon: Conflict. The name "/second-mysql" is already in use by container 2de4ddb5bfb9b9434af8e72368631e7f4c3f83ee354157328049d7d0f5523661. 

You have to remove (or rename) that container to be able to reuse that name..

```

为了验证second-mysql这个容器还在docker的进程中，我们使用ps -a这个命令，我们可以观察到first-mysql的状态为Up 34 minutes,说明已经工作了34分钟，而second-mysql只是刚刚创建的。

```

sudo docker ps -a

CONTAINER ID        IMAGE               COMMAND                  CREATED              STATUS              PORTS                    NAMES

2de4ddb5bfb9        mysql               "docker-entrypoint.sh"   About a minute ago   Created                                      second-mysql

5b6bf6f629bf        mysql               "docker-entrypoint.sh"   34 minutes ago       Up 34 minutes       0.0.0.0:3306->3306/tcp   first-mysql

```

我们用rm命令删除这个容器,如下面命令所示：

```

maintain@maintain-dev1:~$ sudo docker rm second-mysql

maintain@maintain-dev1:~$ sudo docker ps -a

CONTAINER ID IMAGE COMMAND CREATED STATUS PORTS NAMES

5b6bf6f629bf mysql "docker-entrypoint.sh" 42 minutes ago Up 42 minutes 0.0.0.0:3306->3306/tcp first-mysql

```

重新建立second-mysql这个容器，占用物理机的3307端口：

```

sudo docker run --name second-mysql -p 3307:3306 -e MYSQL\_ROOT\_PASSWORD=123456 -d mysql

5404fb11f29cba07b991f34056d6b40ed0888aa905a45e637e396d071bd7f331

sudo docker ps

CONTAINER ID        IMAGE               COMMAND                  CREATED             STATUS              PORTS                    NAMES

5404fb11f29c        mysql               "docker-entrypoint.sh"   12 seconds ago      Up 11 seconds       0.0.0.0:3307->3306/tcp   second-mysql

5b6bf6f629bf        mysql               "docker-entrypoint.sh"   43 minutes ago      Up 43 minutes       0.0.0.0:3306->3306/tcp   first-mysql

```

如上图所示，两个实例都正常运行了，为了访问第二个容器，我们指定端口3307登录到这个mysql的client。

```

maintain@maintain-dev1:~$ mysql -h192.168.95.4 -P3307 -uroot -p123456

Warning: Using a password on the command line interface can be insecure.

Welcome to the MySQL monitor. Commands end with ; or \g.

Your MySQL connection id is 2

Server version: 5.7.15 MySQL Community Server (GPL)

Copyright (c) 2000, 2016, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or itsaffiliates. Other names may be trademarks of their respectiveowners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

```

## 4.jdbc测试(maven & Spring boot)

例子来源：http://spring.io/guides/gs/relational-data-access/

<p>

使用java spring对数据库进行操作，使用了spring官网的例子，用JdbcTemplate这个裸写sql的方法，没有用hibernate或者myibatis.

<p>

spring官网的例子使用h2一个内置的内存数据库，没有配置文件生成为对象的烦恼，

<p>

为了练习下yaml替代xml，使用了如下的mysql jdbc配置,application.yaml.

```yaml

### application.yaml

### mysql config

spring:

  datasource:

    dbcp:

      driver-class-name: com.mysql.jdbc.Driver

      url: jdbc:mysql://192.168.18.129:3306/test1

      username: root

      password: 123456

```

<p>找了半天自动将依赖注入为一个JdbcTemplate对象，也没有搞定，就只好像下面一样自己先生成DataSource，再new一个JdbcTemlate对象，最后使用jdbcTemplate对数据库进行操作，这样写的很丑，希望各位可以指点一下。

``` java

@Bean

@ConfigurationProperties(prefix = "spring.datasource.dbcp")

public DataSource mysqlSource() { 

    return DataSourceBuilder.create().build();

}

```

```java

@Beanpublic JdbcTemplate mysqlJdbcTemplate() { 

    return new JdbcTemplate(mysqlSource());

}

```

下面是对数据库的一些CRUD操作，使用jdk8的函数式编程：

```java

JdbcTemplate jdbcTemplate = mysqlJdbcTemplate();

jdbcTemplate.execute("DROP TABLE IF EXISTS customers");

jdbcTemplate.execute("CREATE TABLE customers(" + "id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

// Split up the array of whole names into an array of first/last names

List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long")

  .stream() .map(name -> name.split(" ")) .collect(Collectors.toList());

// Use a Java 8 stream to print out each tuple of the list

splitUpNames.forEach(name -> log.info(String.format("Inserting customer record for %s %s", name[0], name[1])));

// Uses JdbcTemplate's batchUpdate operation to bulk load data

jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);

log.info("Querying for customer records where first_name = 'Josh':");

jdbcTemplate.query( 

   "SELECT id, first_name, last_name FROM customers WHERE first_name = ?", 

   new Object[]{"Josh"}, (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")))

   .forEach(customer -> log.info(customer.toString()));

```

下面在mysql的客户端进行了验证：

```bash

mysql> select * from customers;

+----+------------+-----------+

| id | first_name | last_name |

+----+------------+-----------+

|  1 | John       | Woo       |

|  2 | Jeff       | Dean      |

|  3 | Josh       | Bloch     |

|  4 | Josh       | Long      |

+----+------------+-----------+

4 rows in set (0.00 sec)

```

### 5. 遇到的一些坑

* maven配置

使用了jdk8的lamda表达式，必须在maven中配置java.version

```xml

<properties> 

<java.version>1.8</java.version>

</properties>

```

* docker服务重启

docker这个服务挂了，容器也就跟着挂了，并没有重启，应该在运行容器的时候带上`--restart=always`这个参数