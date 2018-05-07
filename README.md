# refusing to merge unrelated histories
git pull origin master --allow-unrelated-histories


# springBootDemo
2018/05/06 
           
          创建、SpringBoot集成mybatis+freemark

Spring Boot的基础结构共三个文件:

        src/main/java 程序开发以及主程序入口
        src/main/resources 配置文件
        src/test/java 测试程序

另外，spingboot建议的目录结果如下：
root package结构：com.example.myproject          
        com
          +- example
            +- myproject
              +- Application.java
              |
              +- domain
              |  +- Customer.java
              |  +- CustomerRepository.java
              |
              +- service
              |  +- CustomerService.java
              |
              +- controller
              |  +- CustomerController.java
              |
1、Application.java 建议放到根目录下面,主要用于做一些框架配置
2、domain目录主要用于实体（Entity）与数据访问层（Repository）
3、service 层主要是业务类代码
4、controller 负责页面访问控制

在官网(http://start.spring.io/)上generate project，将生成的项目导入idea中，
运行之后控制台输出“Unregistering JMX-exposed beans on shutdown”，
tomcat也没有运行。寻找原因，看了下pom.xml文件中tomcat依赖关系如下：

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
        <scope>provided</scope>
    </dependency>
解决：将<scope>provided</scope>注释掉