package chapter2;
/**
 * VM Args：-Xss2M （这时候栈内存不妨设大些）,多线程导致内存溢出,容易导致系统假死
 * @author Agnostic
 */
public class JavaVMStackOOM {
 
       private void dontStop() {
              while (true) {
              }
       }
 
       public void stackLeakByThread() {
              while (true) {
                     Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                   dontStop();
                            }
                     });
                     thread.start();
              }
       }
 
       public static void main(String[] args) throws Throwable {
              JavaVMStackOOM oom = new JavaVMStackOOM();
              oom.stackLeakByThread();
       }
}

