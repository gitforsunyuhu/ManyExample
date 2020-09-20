package algorithm.sougou;

public class Main_3 {

    public int getHouses (int t, int[] xa) {
        // write code here
        int i = 0;
        int count = 0;

        int left = Integer.MIN_VALUE;
        while(i < xa.length - 1){
            int a = xa[i+1];
            xa[i]  = xa[i]-a;
            xa[i+1] = xa[i] +a;
            if(xa[i] -left >= t){
                count += 1;
            }
            if(i +2 < xa.length && xa[i +2] - xa[i +1] > t){
                count ++;
            }
            left = xa[i+1];
            i += 2;

        }
        return count +1;
    }

//    public int getHouses (int t, int[] xa) {
//        // write code here
//        int i = 0;
//        int count = 0;
//
//        int left = Integer.MIN_VALUE;
//        while(i < xa.length - 1){
//            int a = xa[i+1];
//            xa[i]  = xa[i]-a;
//            xa[i+1] = xa[i] +a;
//            i = i+2;
//            int j = 0;
//            while(j < xa.length - 1){
//                if(xa[j] -left >= t){
//                    count += 1;
//                }
//                if(j +2 < xa.length && xa[i +2] - xa[i +1] > t){
//                    count ++;
//                }
//                left = xa[i+1];
//                i += 2;
//            }
//        }
//        i = 0;
//        while(i < xa.length - 1){
//            if(xa[i] -left >= t){
//                count += 1;
//            }
//            if(i +2 < xa.length && xa[i +2] - xa[i +1] > t){
//                count ++;
//            }
//            left = xa[i+1];
//            i += 2;
//        }
//        return count +1;
//    }
}