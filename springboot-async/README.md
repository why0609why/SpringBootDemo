# springboot-async
如果不使用异步请求来处理某些特殊的请求，比如处理批量数据、批量发送邮件这种的处理时间长的请求，那么在这些请求没有处理完之前，客户端是啥都不能干的，也就是阻塞的，自然这样是不合适的，所以就有了处理异步请求。

# demo演示内容
这里采用线程的休眠来模拟需要处理时间长的请求，并且将这个代码块封装到service的一个方法中，如果不给这个service层的方法加异步注解'@Async'，那么在controller中调用这个方法的时候会得等待线程休眠以后controller才有返回值，如果将service层的方法变成异步的，在contrller层中的方法调用这个方法之后会立刻执行controller的下面的代码，注意封装好异步执行的方法之后还得在主程序上加上'@EnableAsync'开启异步执行。

# 步骤
1. 在主程序上添加注解```@EnableAsync```,表示开启异步任务
``` java
//要开启异步注解所需要的注解
@EnableAsync
@SpringBootApplication
public class SpringbootAsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAsyncApplication.class, args);
    }

}
```
2. 在service层模拟一个长处理时间的方法(这里是使线程sleep5秒),并且在方法上添加```@Async```注解，表示这个方法是一个异步任务
``` java
@Service
public class AsyncService {

    //加了这个注解表示是异步方法，别的方法在调用这个方法的时候会在别的方法中的代码块中异步执行这个方法
    @Async
    public void service01() {
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

```
3. 在controller层创建一个接收长处理时间请求的handler，并且在这个handler中调用service层中的异步方法
``` java
@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @RequestMapping("/async")
    public String handler01() {
        //在这里调用异步方法
        asyncService.service01();
        return "success";
    }
}

```
4. 开启项目后，访问/async这个请求，就可以发现并没有等5秒请求才有响应，说明调用的service层的方法是异步的。