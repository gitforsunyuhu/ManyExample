package algorithm.sougou;

public class Main_1 {

    public static long ans = 0;

    public static String inputnum = null;
    public long getPasswordCount (String password) {
        if(password == null || password.length() == 0){
            return 0;
        }

        if(password.length() == 1){
            return 9;
        }
        inputnum = password;
        String mynum = null;
        for (long i = 0; i < 10; i++) {
            mynum = "" + i;
            getAns(password.substring(1), i, mynum);
            mynum = null;
        }
        return ans - 2 ;
    }

    public static void getAns(String pass, long number, String mynum){
        if(pass.length() == 1){
            long sum = pass.charAt(0) -'0' + number;
            if(sum % 2 == 0){
                ans ++;
                mynum = mynum + (sum/2);
                if(mynum.equals(inputnum)){
                    ans --;
                }
            }else{
                ans += 2;
                if( (mynum + (sum/2)).equals(inputnum) ||  (mynum + (sum/2 +1)).equals(inputnum)){
                    ans --;
                }
            }
            return;
        }
        long sum = pass.charAt(0) -'0' + number;
        if(sum % 2 == 0){
            //ans ++;
            getAns(pass.substring(1), sum/2 , mynum + (sum/2));
        }else{
            //ans += 2;
            getAns(pass.substring(1), sum/2 +1,mynum + (sum/2 +1));
            getAns(pass.substring(1), sum/2 ,mynum + (sum/2));
        }
    }


    public static void main(String[] args) {
        Main_1 main_1  = new Main_1();
        main_1.getPasswordCount("3");
        System.out.println(ans);
//
//        System.out.println("1234".substring(1));;
    }
}
