/**
 * @author cj
 * @date 2019/11/5
 */
package com.parentchild;



/**
 * 此包以及对应的配置类与测试类是为了演示下面这段官方文字的,主要表明该bean方法返回接口或父类型的情况.
 However, this limits the visibility for advance type prediction to the specified interface type (TransferService).
 Then, with the full type (TransferServiceImpl) known to the container only once, the affected singleton bean has been instantiated.
 Non-lazy singleton beans get instantiated according to their declaration order,
 so you may see different type matching results depending on when another component tries to match
 by a non-declared type (such as @Autowired TransferServiceImpl, which resolves only once the transferService bean has been instantiated).

 If you consistently refer to your types by a declared service interface,
 your @Bean return types may safely join that design decision.
 However, for components that implement several interfaces or for components potentially referred to by their implementation type,
 it is safer to declare the most specific return type possible (at least as specific as required by the injection points that refer to your bean).

 */