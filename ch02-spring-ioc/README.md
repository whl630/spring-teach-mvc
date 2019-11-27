IOC:inverse of control:控制反转
matin fowler: DI:dependency injection(依赖注入)

ioc= DI
网上有些人认为ioc跟di不是一回事

假设有2个类UserService,UserDao
不反转的情况,意思是
service = new UserService(); 
service.setDao(new UserDao);
因为上面的UserService类需要userDao,给其添加
userDao实例的过程是由自己写代码控制,
就是一切都在自己的掌握中.这种情况就叫做不反转

反转的就是
context.getBean("UserService",UserService.class);
上面的代码执行完毕后,userService已经帮其设置了
userDao


class UserServiceImpl{
    private UserDao dao;
    
    
    public void setDao(UserDao dao){
    
        this.dao = dao;
    }


}

依赖注入:所有被spring管理的bean,当它依赖一个其它
被spring管理的bean的时候,spring负责把其注入进来.


1. spring管理的依赖注入的形式有3种
    1.构造函数的注入
    2.属性注入(setter)
    3.接口注入(不推荐使用)

2. 构造函数注入:
   2.1 这种配置形式可以用在
    a)类的构造函数配置
    b)工厂方法参数的配置上
    
   2.2 构造函数注入模糊性解决办法
    1.name
    2.index
    3 type

3. 基本类型的注入(UserInfo)
    普通属性(name)
    对象属性(Address)
    List属性
    Map
    Set
    Properties:
        配置的时候,值只能是string类型
        
      
      小知识:内部bean的配置

    注意点:类型跟元素一般是一样,两者都其效果
    
 4. p命名空间
 5. c命名空间
 6. 父子bean定义
 7. null值处理  
 8. 复合(Compound)属性设置
 9. method injection
 
 #作业:
  写一个类叫做SqlSessionFactory
  
   class SqlSessionFactory(Properties prop){
   
   }
   
   
   在写一个类
   class SqlSessionFactorCreator {
    private Properties prop;
    SqlSessionFactory create(){
        new SqlSessionFactory(prop);
    }
   } 
   
   目标:把SqlSessionFactory对象创建出来
   如何用spring的套路来实现???