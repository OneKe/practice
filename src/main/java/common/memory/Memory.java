package common.memory;

import java.util.concurrent.locks.StampedLock;

/**
 * 内存屏障
 * StampedLock 提供的乐观读锁不阻塞写线程获取读锁
 * 使用规则：
 * 1.获取乐观锁
 * 2.copy变量到工作内存
 * 3.检验锁状态，判断是否数据不一致，不一致则执行4，5，6，7；否则直接执行7
 * 4.获取悲观读锁
 * 5.copy变量到工作内存
 * 6.释放悲观读锁
 * 7.线程本地计算
 */
public class Memory {
    private double x, y;
    private final StampedLock sl = new StampedLock();

    /**
     * 直接写操作：获取悲观写锁，本地操作，释放写锁；
     */
    void move(double deltaX, double deltaY) {
        long stamp = sl.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            sl.unlockWrite(stamp);
        }
    }

    /**
     * 先读后写
     */
    double distanceFromOrigin() {
        //1首先，通过tryOptimisticRead 方法获取乐观读标记
        long stamp = sl.tryOptimisticRead();
        //2然后从主内存中加载点的坐标值 (x,y)；
        double currentX = x, currentY = y;
        //3而后通过StampedLock 的validate 方法校验锁状态，判断坐标点(x,y) 从主内存加载到线程工作内存过程中，主内存的值是否已被其他线程通过move 方法修改，
        // 如果validate 返回值为true，证明(x, y) 的值未被修改，可参与后续计算；
        //StampedLock.validate 方法的源码实现，通过锁标记与相关常量进行位运算、比较来校验锁状态，在校验逻辑之前，会通过Unsafe 的loadFence 方法加入一个load 内存屏障，
        // 目的是避免步骤2和StampedLock.validate 中锁状态校验运算发生重排序导致锁状态校验不准确的问题。
        if (!sl.validate(stamp)) {
            //4否则，需加悲观读锁，再次从主内存加载(x,y) 的最新值，然后再进行距离计算。
            stamp = sl.readLock();
            try {
                currentX = x;//5
                currentY = y;
            } finally {
                sl.unlockRead(stamp);//6
            }
        }
        return Math.sqrt(currentX * currentX + currentY * currentY);//7
    }
}
