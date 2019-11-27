# 显示视图:
按照mvn的理念,永远应该是转发到jsp,控制器方法直接显示视图,视图解析器会加上在xml
    中配置的前后缀,见案例DisplayViewController
方法有2种
    1. 直接返回字符串,代表逻辑视图名
    2. 返回ModelAndView,直接设置逻辑视图名即可
# 控制器方法间的跳转
   这种情况指的是在发起请求,有forward与重定向的区别,案例见JumpController类
## 转发到其它请求方法
方法只有一种:
    1. 返回字符串,加前缀forward,比如"forward:其它请求方法的地址" 
    这种加前缀是告诉视图解析器直接转发(forward到指定的地址,而不是用来显示视图用的,所以不需要
    加前缀与后缀.

## 重定向到其它方法
    方法有两种:
    1. 返回字符串,加前缀redirect,比如"redirect:其它请求方法的地址" 
    这种加前缀是告诉视图解析器直接重定向到指定的地址,而不是用来显示视图用的,所以不需要
    加前缀与后缀.
    2. 返回RedirectView类型,直接设置其它请求方法的地址,不需要加前缀

> 总结:在返回的string类型数据中,有前缀(不管是forward还是redirect)后面跟着的就是
> 一个地址,不是一个逻辑视图名.也就是说视图解析器不会自动帮我们加上前后缀
# 传递数据到视图 
方法有3种
1.利用servlet的api,比如请求作用域,会话作用域,应用程序作用域都可以
2. 利用ModelAndView
3. 利用Model,ModelMap,Map<String,Object>类型作为参数

# 请求之间传递数据
方法有三种
1. 拼接url的方式
2.利用会话作用域,应用程序作用域
3.利用RedirectAttributes
    利用addFlashAttribute方法来传递
    原理:把数据放到session中,读取之后自动删除
    
    要掌握addAttribute的作用:添加到里面的数据会自动拼接到url参数

# 术语解释
command object:命令对象简单理解为接收表单提交过来的数据的一个bean,独属于spring mvc的一个术语.类似于DTO概念
https://stackoverflow.com/questions/40307821/command-objects-and-dtos-difference
https://www.cnblogs.com/EasonJim/p/7967999.html (包含VO,DTO,BO等阿里巴巴手册中各种bean的解释)
# 参考资料
https://www.baeldung.com/spring-mvc-and-the-modelattribute-annotation
https://www.jianshu.com/p/a8fc27da4107