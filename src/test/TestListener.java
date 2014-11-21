package test;

import com.google.common.eventbus.Subscribe;

/**
 * User: Adam Chlupacek
 * Date: 30/05/14
 * Time: 10:53
 * Package: test
 */
public class TestListener {

    private String listenerName;

    public TestListener(String listenerName) {
        this.listenerName = listenerName;
    }

    @Subscribe
    public void test(TestEvent event){
        System.out.println("-----------");
        System.out.println("Listener name: " + listenerName);
        System.out.println("\033[31;1mHello\033[0m, \033[32;1;2mworld!\033[0m" + "Event name: " + event.id);
        System.out.println("LastAccessName: " + event.testline);
        System.out.println("Thread: " + Thread.currentThread().getName());
        event.testline = listenerName;

    }
}
