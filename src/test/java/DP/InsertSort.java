package DP;

import org.testng.annotations.Test;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2022/3/29 21:18
 */
public class InsertSort {

    public void insertSort(int[] a) {
        int n = a.length;

        int j = 0;

        for (int i = 1; i < n; i++) {

            int temp = a[i];

            for (j = i; j  > 0 && temp < a[j-1]  ; j--){
                    a[j] = a[j-1];
            }
            a[j] = temp;
        }

    }

    @Test
    public void testSort(){
        int[] a = {3,4,2,6};
        insertSort(a);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }
}
