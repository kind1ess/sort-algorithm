package top.kindless.sort;

import top.kindless.sort.utils.SortUtil;

public class Insertion {
    public static void sort(Comparable[] a){
        int length = a.length;
        for (int i = 1; i < length; i++) {
            Comparable tmp = a[i];
            int j;
            for (j = i - 1; j >= 0 && SortUtil.less(tmp,a[j]); j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = tmp;
        }
    }

    public static void sort(Comparable[] a,int lo, int hi){
        for (int i = lo; i <= hi; i++) {
            Comparable tmp = a[i];
            int j;
            for (j = i - 1; j >= lo && SortUtil.less(tmp,a[j]); j--) {
                a[j + 1] = a[j];
            }
            a[j + 1] = tmp;
        }
    }

    public static void main(String[] args) {
        Integer[] a = SortUtil.randomIntegerArray(10,0,10000);
        long millis = System.currentTimeMillis();
        sort(a);
        System.out.println("插入排序耗时："+(System.currentTimeMillis() - millis)+"毫秒");
        System.out.println(SortUtil.isSorted(a));
    }
}
