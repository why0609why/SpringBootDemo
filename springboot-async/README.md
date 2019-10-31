# springboot-async
如果不使用异步请求来处理某些特殊的请求，比如处理批量数据、批量发送邮件这种的处理时间长的请求，那么在这些请求没有处理完之前，客户端是啥都不能干的，也就是阻塞的，自然这样是不合适的，所以就有了处理异步请求。

# demo演示内容
这里采用线程的休眠来模拟需要处理时间长的请求，并且将这个代码块封装到service的一个方法中，如果不给这个service层的方法加异步注解，那么在controller中调用这个方法的时候会得等待线程休眠以后controller才有返回值，如果将service层的方法变成异步的，在contrller层中的方法调用这个方法之后会立刻执行controller的下面的代码