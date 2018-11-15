package cn.com.srpingboot;

import java.util.Arrays;
import java.util.Objects;

public class test1 {

    static Integer fastSort(int[] a,int start ,int end,Integer aim){
        if(start>=end) return a[start];
        aim = aim -1;
        Objects.requireNonNull(a,"required not null object");
        int base= a[0];
        int j = start;
        int k = end;
        int tmp = 0;
        while (j!=k){
            while (a[k]<base && k > j){
                k--;
            }
            while (a[j]>base && k > j){
                j++;
            }
            tmp = a[j];
            a[j]=a[k];
            a[k]=tmp;
        }
        a[j]=tmp;
        if (j == aim){
            return a[j];
        }if (aim > j){
            return fastSort(Arrays.copyOfRange(a,j + 1,end+1),0,end - j - 1,aim -j);
        }if (aim < j){
            return fastSort(Arrays.copyOfRange(a,start,j),start,j-1,aim + 1);

        }
        return null;
    }

    public static void main(String[] args) {
        int[] a =  {11,9,13,14,6,17,2,20,1};
        System.out.println(fastSort(a,0,a.length-1,3));
        System.out.println(Arrays.toString(a));

    }

}
