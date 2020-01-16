package day12_wait_notify;

public class Cookie {
    private boolean empty = true;
    // 吃餅乾
    public synchronized void eat(int n) {
        while(empty) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        System.out.printf("小白狗吃了第 %d 片餅乾\n", n);
        empty = true;
        notifyAll();
    }
    
    // 放餅乾
    public synchronized void put(int n) {
        while(!empty) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        System.out.printf("男主人放了第 %d 片餅乾\n", n);
        empty = false;
        notifyAll();
    }
    
}
