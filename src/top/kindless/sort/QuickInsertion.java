package top.kindless.sort;

import top.kindless.sort.utils.SortUtil;

import java.util.Arrays;
import java.util.Collections;

public class QuickInsertion {

    public static void sort(Comparable[] a){
        sort(a,0,a.length - 1);
    }

    private static void sort(Comparable[] a,int lo,int hi){
        if (lo + 10 >= hi) {
            Insertion.sort(a,lo,hi);
            return;
        }
//        if (lo >= hi){
//            return;
//        }
        int pivot = partition(a,lo,hi);
        sort(a,lo,pivot - 1);
        sort(a,pivot + 1,hi);
    }

    private static int partition(Comparable[] a,int lo,int hi){
        int i = lo ,j = hi + 1;
        Comparable v = a[lo];
        while (true){
            while (SortUtil.less(a[++i],v)) {
                if (i == hi)
                    break;
            }
            while (SortUtil.less(v,a[--j])){
//                if (j == lo)
//                    break;
            }
            if (i >= j)
                break;
            SortUtil.exch(a,i,j);
        }
        SortUtil.exch(a,lo,j);
        return j;
    }
    public static void main(String[] args) {
        Integer[] a = SortUtil.randomIntegerArray(1000000,0,50000000);
//        SortUtil.show(a);
        long millis = System.currentTimeMillis();
        sort(a);
        System.out.println("快速排序耗时："+(System.currentTimeMillis() - millis)+"毫秒");
//        SortUtil.show(a);
        System.out.println(SortUtil.isSorted(a));
    }
}
