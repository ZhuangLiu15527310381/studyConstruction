package com.example.demo.design.singleton;


/**
 * 懒汉式方法总是会出现这样或那样的问题的，因为考虑到了多线程机制，实现起来比较麻烦，并且还会出现问题，
 * 就算是使用了一定的解救办法（同步、加锁、双重判断）的办法，性能还是被损耗了，因此懒汉式方法的不推荐使用。
 */

//单例模式-懒加载模式
public class SingletonLazy {
    public static SingletonLazy singletonLazy = null;
    //单例模式默认—构造器要私有化
    private SingletonLazy(){
    }

    public static SingletonLazy getInstance() {
        if (singletonLazy == null){
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }
}
