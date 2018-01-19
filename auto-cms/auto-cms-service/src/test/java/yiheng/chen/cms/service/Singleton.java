package yiheng.chen.cms.service;

/**
 * @Author: Yiheng Chen
 * @Description:
 * @Date: Created in 16:19 2018/1/12
 * @Modified by:
 */
public class Singleton {

    private static final Singleton singleton = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return singleton;
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2;
        try {
            instance2=(Singleton)instance.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new RuntimeException("無法克隆");
        }
        System.out.println(instance.equals(instance2));

    }
}
