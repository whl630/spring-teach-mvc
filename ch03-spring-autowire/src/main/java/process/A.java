package process;

import org.springframework.beans.factory.InitializingBean;

/**
 * 首先实例化:构造函数会先执行
 * 2.进行装配(wire):帮我们注入(如果有设定显示的注入或者自动注入)
 * 3.执行afterPropertiesSet
 * 4.执行你指定的init方法:因为init方法按照spring的要求是无参无返回值的
 *      那么afterPropertiesSet也是无参无返回值
 *      所以如果你设定的自定义init方法就是afterPropertiesSet
 *      那么此方法不会执行两次
 *
 *  详细流程如下:
 *  1. instantiate
 *  2. populate properties
 *  3. BeanNameAware.setBeanName()
 *  4. BeanFactoryAware.setBeanFactory()
 *  5. BeanPostProcessor.postProcessBeforeInitialization()
 *  6. InitializingBean.afterPropertiesSet()
 *  7. 调用指定的init-method
 *  8. BeanPostProcessor.postProcessAfterInitiallization()
 *  9. Bean可以用了
 *  10. Spring容器销毁(close方法)
 *  11. DisposableBean.destroy()
 *  12. 结束
 * @author cj
 * @date 2019/10/21
 */
public class A implements InitializingBean {
    private B b;
    private C c;



    public A(B b, C c){
        System.out.println("A的有参构造函数");
        this.b = b;
        this.c = c;
    }

    public void setB(B b) {
        System.out.println("A的setB方法");
        this.b = b;
    }

    public void init(){
        System.out.println("A的init方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("after properties--");
    }


}
