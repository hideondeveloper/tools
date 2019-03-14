package test;

import java.util.UUID;

public class ThreadLocalTest {

    private static final ThreadLocal<String> M_THREAD_LOCAL = new ThreadLocal<String>();
    
    public static void setTrackerId(String id) {
        M_THREAD_LOCAL.set(id);
    }
    public static String getTrackerId() {
        return M_THREAD_LOCAL.get();
    }
    
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                M_THREAD_LOCAL.set("t1");
                System.out.println("t1");
            }
        });
        t1.start();
        Thread.sleep(1000);
        System.out.println(M_THREAD_LOCAL.get());
        System.out.println(UUID.randomUUID().toString().replace("-", ""));
    }
}
