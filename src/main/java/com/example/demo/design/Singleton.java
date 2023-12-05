package com.example.demo.design;


/**
 * 单例模式——及时加载/懒加载
 *
 * 优点：1.在单例模式中，只有一个实例对象，对单例的所有实例化得到的都是相同的一个实例，确保了所有的对象都访问一个实例；
 *      2.提供了对唯一实例的受控访问；
 *      3.由于系统内存中只存在一个对象，因此可以节约系统资源，当需要频繁创建和销毁的对象使用单例模式无疑可以提高系统的性能；
 *      4.允许可变数目的实例；
 *      5.避免对共享资源的多重占用；
 * 缺点：1.不适用于变化的对象，如果同一类型的对象总是要在不同的用例场景发生变化，单例就会引起数据的错误，不能保存彼此的状态；
 *      2.由于单例模式中没有抽象层，因此单例类的扩展有很大的困难；
 *      3.单例类的职责过重，在一定程度上违背了“单一职责原则”；
 *      4.滥用单例将带来一些负面问题，如为了节省资源将数据库连接池对象设计为的单例类，可能会导致共享连接池对象的程序过多而出现连接池溢出；
 *        如果实例化的对象长时间不被利用，系统会认为是垃圾而被回收，这样绘制对象状态的丢失；
 * 单例模式适用的场景：
 *       .单例模式只允许创建一个对象，因此节省内存，加快对象访问速度，因此对象需要被公用的场合使用，如多个模块使用一个数据源连接对象等等。
 *      1.需要频繁实例化然后销毁的对象；
 *      2.创建对象时好事过多，或者消耗资源过多，但又经常用到的对象；
 *      3.有状态的工具类对象；
 *      4.频繁访问数据库或文件的对象；
 *
 * 具体的应用场景：
 *      1.应用程序的日志打印，共享的日志文件一直处于打开状态，因为只能有一个实例去操作，否则内容不好追加；
 *      2.Web应用的配置对象的读取，一般也应用单例模式，这个是由于配置文件是共享的资源；
 *      3.数据库连接池的设计一般也是采用单例模式，因为数据库连接是一种数据库资源。
 *      4.线程池的设计一般也是采用的单例模式；
 *
 */

public class Singleton {
    //即时加载模式
    public Singleton() {
    }

    private static final Singleton single = new Singleton();

    public static Singleton getInstance(){
        return single;
    }

}