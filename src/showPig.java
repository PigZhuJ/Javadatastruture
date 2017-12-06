public class showPig{
    public static void main(String[] args) {
    }
}
class Pig implements Runnable{
    private Boolean flag=false;
    @Override
    public void run() {
        for (int j=0;j<100000;j++){
            try {
                print1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                print2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {

            }
        }
    }

    private void print1() throws InterruptedException {
        if(flag==false) {
            for (int i = 0; i < 10; i++) {
                System.out.println("陈佳怡是猪！");
                flag=true;
                notifyAll();}
            }else{
                wait();
            }
        }


    private void print2() throws InterruptedException {
        if(flag==true) {
            for (int i = 0; i < 10; i++) {
                System.out.println("陈佳怡！");
                flag=false;
                notifyAll();
            }}else{
                wait();
            }
        }
    }


