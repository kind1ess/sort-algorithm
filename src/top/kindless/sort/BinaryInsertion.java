package top.kindless.sort;

import top.kindless.sort.utils.SortUtil;

import java.util.Arrays;

public class BinaryInsertion {

    public static void sort(Comparable[] a){
        int length = a.length;
        for (int i = 1; i < length; i++) {
            Comparable tmp = a[i];
            int rank = rank(a, tmp, 0, i - 1);
            for (int j = i; j > rank; j--) {
                a[j] = a[j - 1];
            }
            a[rank] = tmp;
        }
    }

    private static int rank(Comparable[] a,Comparable num,int lo,int hi){
        while (lo <= hi){
            int mid = (lo + hi) / 2;
            Comparable comparable = a[mid];
            if (num.compareTo(comparable) == 0)
                return mid;
            if (num.compareTo(comparable) > 0)
                lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }

    public static void main(String[] args) {
        Integer[] a = SortUtil.randomIntegerArray(10);
        long millis = System.currentTimeMillis();
        sort(a);
        System.out.println("二分插入排序耗时："+(System.currentTimeMillis() - millis)+"毫秒");
        System.out.println(SortUtil.isSorted(a));
    }
}
