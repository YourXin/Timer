# Timer
Java定时器
# 定时任务概念

在给定的时间点，给定的时间间隔或者给定的执行次数自动执行的任务

**两种常用的方式及主要区别**

- Timer  ---JDK直接提供，完成简单的定时任务（具体时间点），后台线程执行定时任务
- Quartz  ---第三方Jar，（周期点？），拥有线程池，可以利用多个线程进行执行

------

## Timer的概念

java.util.Timer

有且仅有**一个后台线程**对**多个业务线程**进行**定时频率的调度**

> Timer->TimerTask



![1539338180862](C:\Users\BigOrang\AppData\Roaming\Typora\typora-user-images\1539338180862.png)

- schedule的4种方法
  - `schedule(TimerTask task, Date time)`	time具体的时间，在时间等于或超过time的时候执行且只执行一次task
  - `schedule(TimerTask task, Date firstTime, long period)`
  - `schedule(TimerTask task, long delay)` 等待delay毫秒后执行一次task
  - `schedule(TimerTask task, long delay, long period)` 延迟时间，周期
- scheduleAtFixedRate
  - `scheduleAtFixedRate(TimerTask task, Date firstTime, long period)` 时间等于或超过firstTime时首次执行task，之后每period毫秒执行一次
  - `scheduleAtFixedRate(TimerTask task, long delay, long period)`

### TimerTask的其他函数用法

1. cancel //取消当前TimerTask里的任务
2. scheduledExecutionTime() 最近发生此任务执行安排的时间，sdf.format(myTimeTask.scheduledExecutionTime())

------

### schedule和scheduleAtFixedRate的区别

两种情况下的区别：开始时间早于当前时间；执行的时间大于周期执行的间隔时间

- schedule

  “fixed-delay”,如果第一次执行时间被delay，随后的执行时间按照**上一次实际执行完成的时间点**进行计算；(计划开始时间早于现在的时间，会以当前时间进行执行)

  因为下一次执行时间是相对于上一次**执行完成**的时间点，所以总共的执行时间会不断延后。

- scheduleAtFixedRate

  “fixed-rate”,如果第一次执行时间被delay，随后的执行时间按照**上一次实际执行开始的时间点**进行计算，并且为了**赶上进度**会多次执行任务，因此TimerTask中的执行体需要考虑**同步**(计划开始时间早于现在的时间，会**追赶**当前时间进行执行)



