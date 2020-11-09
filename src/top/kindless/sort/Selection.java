package top.kindless.sort;

import top.kindless.sort.utils.SortUtil;

public class Selection {

    public static void sort(Comparable[] a){
        int length = a.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i + 1; j < length; j++) {
                if (SortUtil.less(a[j],a[min]))
                    min = j;
            }
            SortUtil.exch(a,i,min);
        }
    }

    public static void main(String[] args) {
        Integer[] a = SortUtil.randomIntegerArray(10000);
        long millis = System.currentTimeMillis();
        sort(a);
        System.out.println("选择排序耗时："+(System.currentTimeMillis() - millis)+"毫秒");
        System.out.println(SortUtil.isSorted(a));
    }
}
