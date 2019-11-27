主要内容是讲请求映射,就是请求地址如何
映射到一个方法

RequestMapping
1.可以支持多个地址
2.地址支持ant格式
    2.1 有一种特殊的配法:*(叫做fallback)
3.请求映射的限缩  
params
headers
produces(accept)
consumes(Content-Type)
4.类与方法上都可以配置RequestMapping
结果是两者进行合并,但consume属性不是合并,而是
方法上的设置覆盖掉类上的设置

4.组合注解
主要的作用就是简化RequestMapping的书写  

5. 多个模式都匹配一个url
最精确的优先匹配
在官方文档的RequestMapping->Pattern Match节中有详细的说明


注意点:
1.在配置多段url的时候,比如/home/list,如果InternalResourceViewResolver的前缀不以/开头
表示相对地址,那么控制器方法返回index,实际的视图地址为:/home/WEB-INF/views/index.jsp

所以强烈建议:视图解析器的前缀一定加上/开头.

