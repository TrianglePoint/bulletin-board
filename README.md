# bulletin-board
bulletin board project.

# requirements
 - client can check the all post.
 - client can check the one post.
 - client can create the post.
 - client can modify the post.
 - client can delete the post.
* * *
 - 고객은 전체 게시물을 조회할 수 있다.
 - 고객은 하나의 게시물을 조회할 수 있다.
 - 고객은 게시물을 작성할 수 있다.
 - 고객은 게시물을 수정할 수 있다.
 - 고객은 게시물을 삭제할 수 있다.
* * *
 - 客は全体の掲示物が照会できる。
 - 客は一つの掲示物が照会できる。
 - 客は掲示物が作成できる。
 - 客は掲示物が修正できる。
 - 客は掲示物が削除できる。
 
# design
## package
 - org.trianglepoint.post.controller (controller of MVC2)
 - org.trianglepoint.post.domain (store the data that receive from DB)
 - org.trianglepoint.post.mapper (connect to DB as mybatis)
 - org.trianglepoint.post.service (business logic)

## maven repository
### add
 - https://mvnrepository.com/artifact/org.springframework/spring-test /${org.springframework-version}
 - https://mvnrepository.com/artifact/org.springframework/spring-jdbc /${org.springframework-version}
 - https://mvnrepository.com/artifact/org.springframework/spring-tx /${org.springframework-version}
 - https://mvnrepository.com/artifact/com.zaxxer/HikariCP/2.7.8
 - https://mvnrepository.com/artifact/org.mybatis/mybatis/3.4.6
 - https://mvnrepository.com/artifact/org.mybatis/mybatis-spring/1.3.2
 - https://mvnrepository.com/artifact/org.bgee.log4jdbc-log4j2/log4jdbc-log4j2-jdbc4/1.16
 - https://mvnrepository.com/artifact/org.projectlombok/lombok/1.18.0 (need install in IDE folder)
### modify
 - properties
   - java-version 1.8
   - org.springframework-version 5.0.7.RELEASE
 - dependency
   - junit/junit/4.12
   - javax.servlet/<b>javax.</b>servlet-api/3.1.0
 - plugin
   - org.apache.maven.plugins/maven-compiler-plugin
     - configuration
       - source 1.8
       - target 1.8
