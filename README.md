# 环境需求：
- JDK 8
- Maven
- Nacos

# 安装Nacos
参考官方文档：https://nacos.io/zh-cn/docs/quick-start.html

启动命令 ./bin/startup.sh -m standalone

# 启动服务
provider服务启动后会自动注册到nacos 

consumer服务通过nacos服务发现调用provider服务提供的接口