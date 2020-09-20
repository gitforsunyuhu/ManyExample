package basic;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {1,3,2,4,3,56,7};
        quickSort(a, 0,a.length-1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    public static void quickSort(int[] arr, int i, int j){
        if(i < j){
            int position = getPosition(arr, i , j);
            quickSort(arr, i, position -1);
            quickSort(arr , position + 1, j);
        }
    }

    public static int getPosition(int[] arr, int i, int j){
        int left = i;
        int right = j;
        int temp = arr[i];
        while(left < right){
            while(left < right && arr[left] < arr[right]){
                right --;
            }
            arr[left] = arr[right];
            while(left < right && arr[left] <= arr[right]){
                left ++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }
}
