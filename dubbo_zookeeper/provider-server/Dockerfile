# 基础镜像
FROM williamyeh/java8
LABEL authors="陈振寰"

# 在镜像中执行命令,创建目录，并使用它作为工作目录
RUN mkdir -p /project
# 设置工作目录，即后续命令的默认执行路径
WORKDIR /project
# 复制文件或目录到镜像中。可以将本地文件或目录复制到镜像的指定位置。
COPY ./provider.jar /project/provider.jar
COPY ./arthas-boot.jar /arthas-boot.jar

# 配置环境变量和jdk的安装目录
# ENV JAVA_DIR=/usr/local

# COPY ./jdk-8u152-linux-x64.tar.gz $JAVA_DIR

# 安装jdk
# \ 就是换到下一行输入，对实际命令没有任何影响，只是为了方便观看
# RUN cd $JAVA_DIR \
	# 使用tar命令将当前目录下（这里因为上面配置了所以所在的目录也就是 /usr/local/下面）的jdk文件进行解压
	# && tar -zxvf ./jdk-8u152-linux-x64.tar.gz \
	# 然后修改解压后的文件名为java8 ，此时就是 /usr/local/java8
	# 这里需要注意的是下面的 jdk1.8.0_321，他就是解压后的文件名
	# 如果这里你不清楚解压后的文件是什么，则可以先解压看以下文件名是什么，然后在进行书写这里的名称
	# && mv ./jdk1.8.0_152 ./java8

# 配置JAVA的环境变量
# ENV JAVA_HOME=$JAVA_DIR/java8
# 配置到PAHT中
# ENV PATH=$PATH:$JAVA_HOME/bin

# 指定容器的时区
ENV TZ=Asia/Shanghai
# 用于配置 Java 虚拟机的选项，如初始堆大小、最大堆大小和随机数生成器，可通过 docker run -e "JAVA_OPTS=" 进行覆盖
ENV JAVA_OPTS="-Xms512m -Xmx1024m"
## 应用参数
ENV ARGS=""

# 定义容器启动后执行的命令,启动后端项目
CMD java ${JAVA_OPTS} -jar /project/provider.jar $ARGS

# 暴露端口 8001 --！！！容器内部端口
EXPOSE 8001