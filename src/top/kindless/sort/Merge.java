package top.kindless.sort;

import top.kindless.sort.utils.SortUtil;


public class Merge {

    private static Comparable[] aux;

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo,j = mid + 1;
        if (hi + 1 - lo >= 0) System.arraycopy(a, lo, aux, lo, hi + 1 - lo);
        for (int k = lo;k <= hi;k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (SortUtil.less(aux[i],aux[j]))
                a[k] = aux[i++];
            else a[k] = aux[j++];
        }
    }

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a,0,a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo)
            return;
        int mid = lo + (hi - lo) / 2;
        sort(a,lo,mid);
        sort(a,mid + 1,hi);
        if (SortUtil.less(a[mid + 1],a[mid]))
            merge(a,lo,mid,hi);
    }

    public static void main(String[] args) {
        Integer[] a = SortUtil.randomIntegerArray(10000000,0,1000000);
//        SortUtil.show(a);
        long millis = System.currentTimeMillis();
        sort(a);
        System.out.println("归并排序耗时："+(System.currentTimeMillis() - millis)+"毫秒");
//        SortUtil.show(a);
        System.out.println(SortUtil.isSorted(a));
    }
}
