#sed详细语法

##使用方法

```bash
sed [ -nefr] [n1,n2] acction 
```

```
-n: 是安静模式，只有经过sed处理的行才会显示，其他不现实
-e: 表示直接在命令行上执行。是默认选项不用填写。
-f: 将Sed的操作写在一个文件里面，用的时候-f filename 就可以按照内容进行Sed操作
-r：表示支持扩展正则表达式，默认支持基础正则表达式
-i: 直接修改读取的文件内容，而不是由文件输出
n1,n2 代表的是行数
```

* Sed的action (动作)支持如下参数
```bash
a: 表示添加，后接字符串，添加到当前行的下一行
c：表示替换，后接的字符串，用它来替换N1到N2之间的行
d：删除行
i：表示插入，后街字符串，添加到当然行的上一行
p:表示打印和-n一起使用
s: 表示搜索，还可以替换1,20s/old/new/g表示把1到20行的old换成new
```

##正则替换

```bash
sed 's/要被替换的字符串/新的字符串/g'
```

##使用示例

* 将old 替换为 new
```bash
echo "old new djkalfja" | sed '1,20s/old/new/g'
echo "old new djkalfja" | sed 's/old/new/g'
```

* \ 与 /
 * 测试echo
```bash
   echo "\\\\///"
\\///
```

 * 将\替换为/
```bash
   echo "\\\\///" | sed 's#\\#/#g'
/////
```

  * 将/替换为\
```bash
echo "\\\\///" | sed 's#/#\\#g'
\\\\\
```

* 查看密码文件
```bash
nl /etc/passwd | head -5
1 root:x:0:0:root:/root:/bin/bash
2 daemon:x:1:1:daemon:/usr/sbin:/usr/sbin/nologin
3 bin:x:2:2:bin:/bin:/usr/sbin/nologin
4 sys:x:3:3:sys:/dev:/usr/sbin/nologin
5 sync:x:4:65534:sync:/bin:/bin/sync
```


  * 增加功能
```bash
nl /etc/passwd | head -5 | sed '2,4a hello\nworld'
1 root:x:0:0:root:/root:/bin/bash
2 daemon:x:1:1:daemon:/usr/sbin:/usr/sbin/nologin
hello
world
3 bin:x:2:2:bin:/bin:/usr/sbin/nologin
hello
world
4 sys:x:3:3:sys:/dev:/usr/sbin/nologin
hello
world
5 sync:x:4:65534:sync:/bin:/bin/sync
```

  * 删除功能
    ```bash
    nl /etc/passwd | head -5 | sed '2,4d'
    1 root:x:0:0:root:/root:/bin/bash
    5 sync:x:4:65534:sync:/bin:/bin/sync
    ```

  * 按行修改
```bash
     nl /etc/passwd | head -5 | sed '2,4c No 2-4 number'
     1 root:x:0:0:root:/root:/bin/bash
    No 2-4 number
     5 sync:x:4:65534:sync:/bin:/bin/sync
```

  * 打印功能
```bash
    nl /etc/passwd | head -5 | sed -n '2,4p'
     2	daemon:x:1:1:daemon:/usr/sbin:/usr/sbin/nologin
     3	bin:x:2:2:bin:/bin:/usr/sbin/nologin
     4	sys:x:3:3:sys:/dev:/usr/sbin/nologin
```


* eth0网卡 ip 提取

  * 查看eth0信息
```bash
ifconfig eth0
```

  * 信息如下
```
eth0 Link encap:Ethernet HWaddr b8:ae:ed:db:dd:2f
inet addr:192.168.1.82 Bcast:192.168.1.255 Mask:255.255.255.0
inet6 addr: fe80::baae:edff:fedb:dd2f/64 Scope:Link
UP BROADCAST RUNNING MULTICAST MTU:1500 Metric:1
RX packets:1817953 errors:0 dropped:23976 overruns:0 frame:0
TX packets:162649 errors:0 dropped:0 overruns:0 carrier:0
collisions:0 txqueuelen:1000
RX bytes:461052740 (461.0 MB) TX bytes:22537583 (22.5 MB)
```

  * 获取192.168.1.82这个ip
```bash
ifconfig eth0 | grep 'inet addr:' | sed 's/^.*addr://g' | sed 's/ Bcast.*$//g'
```

* 综合运用
 * 删除 manpath.config这个文件中没有注释的MAN的行，并且显示
```bash
cat /etc/manpath.config | grep "MAN" | sed 's/^#.*$//g' | sed '/^$/d' | head -5
MANDATORY_MANPATH /usr/man
MANDATORY_MANPATH /usr/share/man
MANDATORY_MANPATH /usr/local/share/man
MANPATH_MAP /bin /usr/share/man
MANPATH_MAP /usr/bin /usr/share/man
```

 * 修改文件内容
   * 将结尾的.换成!
```bash
sed -i 's/\.$/\!/g' test.txt
```

   * 在文档最后一行增加Hello world!
```bash
sed -i 'a Hello world!' test.txt
```

## vim中sed使用

* 将rep 10替换为rep 100， 一个一个替换
```bash
:1,$s/rep 10/rep 100/gc
```

* 将\替换为/，一个一个替换
```bash
:1,$s#\\#/#gc
```