### Keep Younger API

***

### 前言
###### 本着学习精神，不代表任何商业用途。
###### 基于 Spring Boot 2.1.7 `jar`包运行。

### linux jar包运行

##### 命令：
nohup java -jar xxx.jar >xxx.log &

    nohup：不挂断运行
    >xxx.log：日志生成
    &：后台运行
创建 java_run.sh文件（名字随意）
填写：
    
    #！/bin/bash
    
    export JAVA_HOME=/usr/local/jdk1.8.0_171
    export JRE_HOME=/usr/local/jdk1.8.0_171/jre
    export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar:$JRE_HOME/lib:$CLASSPATH
    export PATH=$JAVA_HOME/bin:$PATH
    
    # 切换到你的jar包位置
    cd /usr/java/jar/
    
    nohup java -jar xxx.jar >xxx.log &
授予rc.local文件执行权限和java_run.sh文件执行权限

    chmod +x /etc/rc.d/rc.local
    chmod +x /usr/java/jar/java_run.sh
    
修改rc.local文件，文件末尾添加java_run.sh执行命令

    # 末尾添加
    /usr/local/jar/java_run.sh
    
重启服务器

    reboot
