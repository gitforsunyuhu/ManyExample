package lambda;

/**
 * lambda表达式的演变
 * 使用最后一种方式的前提是方法中之后一个函数
 */
public class LambdaEx1 {

    //2、静态内部类
    static class Like2 implements ILike {
        @Override
        public void like() {
            System.out.println("like 2");
        }
    }

    public static void main(String[] args) {
        Like like = new Like();
        like.like();

        Like2 like2 = new Like2();
        like2.like();

        //3、局部内部类
        class Like3 implements ILike{
            @Override
            public void like() {
                System.out.println("like 3");
            }
        }

        Like3 like3 = new Like3();
        like3.like();
        //4、匿名内部类
        ILike like4 = new ILike() {
            @Override
            public void like() {
                System.out.println("like 4");
            }
        };

        //5、lambda表达式
        ILike like5 = ()-> System.out.print("like 5") ;
    }
}


interface ILike{
    public abstract void like();
}

//1、外部类
class Like implements ILike{

    @Override
    public void like() {
        System.out.println("like 1");
    }
}