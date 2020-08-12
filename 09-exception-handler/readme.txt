ch09-exception-handler:异常处理

异常处理步骤：
1.新建maven web项目
2.加入依赖
3.新建一个自定义异常类 MyUserException , 再定义它的子类NameException ,AgeException
4.在controller抛出NameException , AgeException
5.创建一个普通类，作用全局异常处理类
  1）在类的上面加入@ControllerAdvice
  2) 在类中定义方法，方法的上面加入@ExceptionHandler
6.创建处理异常的视图页面
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
