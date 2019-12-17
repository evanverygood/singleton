package com.zhujian;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleTon {

    //私有的属性
    private static volatile SingleTon instence;

    //私有的构造方法
    private SingleTon(){

    }

    //共有的获取方法
    public static SingleTon getSingleTon(){

        /*第一次获取时多线程有可能发生两个线程同时判断
            singleton这个属性为空，同时创建两个不同的对象，发生数据不安全

        * */

        if (instence==null){
            //加锁之后，还是会有创建两个同对象的问题
            synchronized (SingleTon.class) {
                //因此在锁里面再来一个判断，这样只有当一个线程完全实例化好对象就，第二个线程
                //才能进行。进来的第一件事就是再次判断instence对象是否为空
                //w为空就直接退出，返回上一个线程new出来的对象即可
                if (instence==null)

                //new一个单例对象时，会有三个步骤，在这里，2和3的顺序可能会因为指令重排
                    //而发生先将M的地址赋给instence的情况，这时，c线程进来判断第一个
                    //不为空直接返回，这时会发生insetence对象是空值得情况，因此好需要加volital关键字
                /**
                 * 1.声明一块内存空间M
                 * 2.在内存M上初始化SingTon对象
                 * 3.最后将M的地址值赋给instrnce
                 *
                 * 指令重排后
                 * 1.声明一块内存空间M
                 * 3.最后将M的地址值赋给instrnce
                 *  2.在内存M上初始化SingTon对象
                 *  发生空指针异常，因为没有初始化
                 */
                instence = new SingleTon();
            }
        }

        return instence;

    }



}

class test{

    public static void main(String[] args) {

        SingleTon singleTon = SingleTon.getSingleTon();
        SingleTon singleTon1 = SingleTon.getSingleTon();
        System.out.println(singleTon==singleTon1);


        ExecutorService executorService = Executors.newFixedThreadPool(200);

      //  executorService.submit("dd",t);


    }

}