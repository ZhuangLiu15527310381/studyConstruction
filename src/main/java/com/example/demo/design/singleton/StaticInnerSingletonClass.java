package com.example.demo.design.singleton;


/**
 * 静态内部类实现单例的优点是：外部类加载时不需要立即加载内部类，内部类不被加载则不去初始化Instance,故而不占内存。
 * 即当SingleTon第一次被加载时，并不需要加载SingletonHolder,只有当getInstance()方法第一次被调用时，才会去初始化INSTANCE，
 * 第一次调用getInstance()方法会导致虚拟机加载SingletonHolder类，这种方法不仅能确保线程安全，也能保证单例的唯一性，同时也延迟了单例的实例化。
 *
 * 所以说静态内部类形式的单例可保证线程安全，也能保证单例的唯一性，同时也延迟了单例的实例化。
 */
public class StaticInnerSingletonClass {

    private static class SingletonHolder {
        private static Singleton INSTACE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTACE;
    }




}
