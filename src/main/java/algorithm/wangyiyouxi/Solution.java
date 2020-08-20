package algorithm.wangyiyouxi;

import java.util.*;


public class Solution {

    static int[][] nodelist;
    /**
     *
     * @param node_data_list int整型二维数组 
     * @return int整型二维数组
     */
    public int[][] invert_tree (int[][] node_data_list) {
        // write code here
        if (node_data_list == null || node_data_list.length == 0 || node_data_list[0].length == 0) {
            return node_data_list;
        }

        int len = node_data_list.length;
        nodelist = new int[len][2];
        return node_data_list;
    }


    public void swap(int[][] a, int i, int j){
        int temp1 = a[i][0];
        int temp2 = a[i][1];
        a[i][0] = a[j][0];
        a[i][1] = a[j][1];
        a[j][0] = temp1;
        a[j][1] = temp2;
    }

    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j]= temp;
    }



    /** 第三题
     * 根据给定的数据，确定病毒的类型
     * @param size int整型 基因片段数量，取值范围: 2 到 1e6
     * @param swap_indexes int整型二维数组 酶处理时，交换的基因片段的位置。swap_indexes[n][0] != swap_indexes[n][1] 一定成立。行数取值范围：[1, 1e6], 列数衡为2
     * @return int整型
     */
    public static int determine_virus_type (int size, int[][] swap_indexes) {
        // write code here
        Set<String> hashSet = new HashSet<>();
        String str1 = null;
        String str2 = null;
        int[] map = new int[size];
        for(int i=size; i>0; i--){
            map[size -i] = i;
        }

        //预处理
        for(int i=0; i< swap_indexes.length; i++){
            str1 = swap_indexes[i][0] + "," + swap_indexes[i][1];
            str2 = swap_indexes[i][1] + "," + swap_indexes[i][0];
            if(hashSet.contains(str1) || hashSet.contains(str2)){
                hashSet.remove(str1);
            }else{
                hashSet.add(str1);
            }
        }

        for (String s : hashSet) {
            int i = Integer.parseInt(s.split(",")[0]);
            int j = Integer.parseInt(s.split(",")[1]);
            swap(map, i, j);
        }
        int count = 0;
        for(int i=0;i< size -1; i++){
            for(int j = i+1; j < size; j++){
                if(map[i] < map[j]){
                    count ++;
                }
            }
        }

        return count % 2 == 0? 2: 1;
    }


    /**
     * 第四题
     * @param filenames string字符串一维数组 所有文件名
     * @param relations string字符串二维数组 文件依赖关系
     * @return int整型
     */
    public static int split_package (String[] filenames, String[][] relations) {
        // write code here]
        if(filenames == null || filenames.length == 0){
            return 0;
        }
        int ans = 0;
        Set<String> hashSet = new HashSet<String>();
        List<Set> list = new ArrayList<Set>();
        for(int i=0; i < relations.length; i++){
            if(i == 0){
                for(int j =0; j < relations[i].length; j++){
                    hashSet.add(relations[i][j]);
                }
                list.add(hashSet);
            }else {
                boolean flag = false;
                Set<String> set = null;
                for(int j = 0; j < relations[i].length; j++){
                    //判断原来的list中是否含有
                    for(int index=0; index< list.size(); index++){
                        set = list.get(index);
                        if(set.contains(relations[i][j])){
                            flag = true;
                            break;
                        }
                    }
                    if(flag){
                        break;
                    }
                }
                // 如果包含把所有元素都加进来
                if(flag){
                    for(int j = 0; j< relations[i].length; j++){
                        set.add(relations[i][j]);
                    }
                }else {
                    Set<String> newset = new HashSet<String>();
                    for (int j = 0; j < relations[i].length; j++) {
                        newset.add(relations[i][j]);
                    }
                    list.add(newset);
                }
            }
        }
        return list.size();
    }

    public static void main(String[] args) {
        String[] filenames = {"fileA", "fileB", "fileC", "fileD", "fileE"};
        String[][] rela = {{"fileA", "fileB"}, {"fileB", "fileC"}, {"fileD", "fileE"}};
        System.out.println(split_package(filenames, rela));
    }

}