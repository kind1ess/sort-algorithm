package top.kindless.sort;

import top.kindless.sort.utils.SortUtil;

import java.util.Arrays;

public class Shell {

    public static void sort(Comparable[] a){
        int length = a.length;
        int h = 1;
        while (h < length / 3)
            h = 3 * h + 1;
        while (h >= 1){
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && SortUtil.less(a[j],a[j-h]); j -= h) {
                    SortUtil.exch(a,j,j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main(String[] args) {
        Integer[] a = SortUtil.randomIntegerArray(10000,0,10000);
        System.out.println(Arrays.toString(a));
        long millis = System.currentTimeMillis();
        sort(a);
        System.out.println("希尔排序耗时："+(System.currentTimeMillis() - millis)+"毫秒");
        System.out.println(Arrays.toString(a));
        System.out.println(SortUtil.isSorted(a));
    }
}
