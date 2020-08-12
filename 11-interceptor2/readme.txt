ch09-exception-handler:异常处理

异常处理步骤：
1.新建maven web项目
2.加入依赖
3.创建Controller类
4.创建一个普通类，作为拦截器使用
  1）实现HandlerInterceptor接口
  2) 实现接口中的三个方法
5.创建show.jsp
6.创建springmvc的配置文件
    1)组件扫描器，扫描@Controller注解
    2)声明拦截器，并指定拦截的请求uri地址

7.创建springmvc的配置文件
 1）组件扫描器 ，扫描@Controller注解
 2）组件扫描器，扫描@ControllerAdvice所在的包名
 3）声明注解驱动

拦截器：
1）拦截器是springmvc中的一种，需要实现HanlerInterceptor接口。
2）拦截器常用在和过滤器类似，功能方面侧重点不同。过滤器是用来过滤器请求参数，设置编码字符集等工作。
    拦截器是拦截用户的请求，做请求做判断处理的。
3）拦截器是全局的，可以对多个Controller做拦截。
一个项目中可以有0个或多个拦截器，他们在一起拦截用户的请求。
拦截器常用在：用户登录处理，权限检查，记录日志。
拦截器的使用步骤：
    1.定义类实现Handlerinterceptor接口
    2.在springmvc配置文件中，声明拦截器，让框架知道拦截器的存在。
拦截器的执行时间;
    1)在请求处理之前，也就是controller类中的方法执行之前鲜卑拦截
    2）在控制方法执行之后也会执行拦截器
    3）在请求处理完成后也会执行拦截器。
拦截器：看做是多个Controller中公用的功能，集中到拦截器统一处理。使用的aop的思想

======================================
多个拦截器：
第一个拦截器preHandler=true,第二个拦截器preHandler=true

111111-拦截器的MyController的preHandler()
222222-拦截器的MyController的preHandler()
====执行MyController中的doSome方法=====
2222222 拦截器的MyInterceptor的postHandle()
111111111 拦截器的MyInterceptor的postHandle()
222222 拦截器的MyInterceptor的afterCompletion()
111111111 拦截器的MyInterceptor的afterCompletion()

-----------------------------------------
第一个拦截器preHandler=true ，第二个拦截器prehandler=false

111111-拦截器的MyController的preHandler()
222222-拦截器的MyController的preHandler()
111111111 拦截器的MyInterceptor的afterCompletion()
-----------------------------------------------
第一个拦截器preHandler=true ，第二个拦截器prehandler=true|false

111111-拦截器的MyController的preHandler()

=========================================
拦截器和过滤器的区别
1.过滤器是servlet中的对象，拦截器是框架中的对象
2.过滤器试下Filter接口的对象，拦截器是实现HandlerInterceptor
3.过滤器是用来设置请求的，能阶段请求。
4.过滤器是在拦截器之前先执行的。
5.过滤器是tomcat服务器创建的对象
    拦截器是springmvc容器中创建的对象
6.过滤器是一个执行时间点。
    拦截器有三个执行时间点
7.过滤器可以处理jsp，js，html等等。
    拦截器是侧重拦截对Controller的对象。如果你的请求不能被DispatherServlet接收。这个请求不会执行拦截器内容
8.拦截器拦截普通类方法执行，过滤器过滤servlet请求响应。