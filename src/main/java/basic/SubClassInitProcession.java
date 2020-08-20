package basic;

public class SubClassInitProcession {
    class Super{
        int f = 1;
        Super(){
            test();
        }
        public void test(){
            System.out.println("super.test：f=" + f);
        }
    }

    class Sub extends Super{
        Sub(int i){
            f = i;
            System.out.println("sub: f = " + f);
        }
        public void test(){
            System.out.println("sub.test：f=" + f);
        }
    }

    public static void main(String[] args) {
        new SubClassInitProcession().new Sub(5);
    }

}
