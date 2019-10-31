# springboot-schedule
有一些需求是要求定时的，比如在每月月底生成一份报表，年末统计数据，类似于这类的功能可以通过定时任务来做。只需要把要做的事情封装到代码中，然后给这个代码设置一个什么时候执行的时间就行了，注意这个时间是任何时候，也可以是一段时间，也可以是某一时刻。

# demo做法
这里再service层中定义了一个方法，再上面加上'@Schedule'注解，再注解中设置'cron = "* * * * * *"'属性，再在主程序上加上，其中'@Schedule'注解表示这个方法是一个定时任务，他的执行时间就是由'cron = '来定义的，然后只要项目开起来的话，定时任务在其规定的时间就能自动，demo里面的cron表达式写的是每一秒都执行一下这个方法。由于cron表达式写起来不太方便，所以有在线生成cron的表达式的工具：http://cron.qqe2.com/
cron表达式的写法就可以百度啦。

# 步骤
1. 先在主程序中上添加注解'@EnableScheduling',表示开启定时任务
``` java
//表示开启定时任务
@EnableScheduling
@SpringBootApplication
public class SpringbootSchduleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSchduleApplication.class, args);
    }

}
```
2. 在service层封装一个要定时执行的方法，我这里的是在service层中封装一个打印时间的方法,并且在方法上加上'@Scheduled()'注解，并且在注解中加上cron = "* * * * * *"属性，cron表达式表示什么时候执行，这里指定每一秒都执行。
``` java
@Service
public class ScheduleService {

    //指定这个方法是定时任务
    //cron表达式定义了什么时候执行
    @Scheduled(cron = "* * * * * *")
    public void service01() {
        System.out.println("定是任务执行"+new Date());
    }
}
```
3. 然后运行项目就可以发现控制台一直有输出。
