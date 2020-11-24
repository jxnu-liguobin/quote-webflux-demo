# SpringBoot WebFlux Demo

1. 启动MongoDB，执行`bash mac_start_mongo.sh`，该脚步将运行两个MongoDB实例，数据和日志存于当前目录
2. 启动`quote-stream`（流生产方-函数式写法）和`stream-service`（流消费方-SpringMVC写法）
3. 访问`http://localhost:8080/quotes`

<video id="video" controls="" preload="none">
    <source id="mp4" src="https://github.com/jxnu-liguobin/quote-webflux-demo/blob/master/%E9%A2%84%E8%A7%88.mp4" type="video/mp4">
</video>
