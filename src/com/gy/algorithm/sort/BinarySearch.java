package com.gy.algorithm.sort;

/**
 * ClassName: BinarySearch
 * Description:（前提必须时有序数组）
 * date: 2019/3/11 9:36
 *
 * @author 郭宇
 * @since JDK 1.8
 */
public class BinarySearch {

    /*
    时间复杂度
    最坏的情况下两种方式时间复杂度一样：O(log2 N)
    二分查找就是一种折半的查找，每次把数组的长度缩小一半，那么最坏的情况就是缩小到不能再缩才找到所需要查找的值。
    假设这时查找了x次，那么2^x=n，所以x=log(n)。
    最坏情况要执行log(n)次，那么需要的时间就是k*log(n)。  注意：描述时间复杂度时log函数的默认底是2不是10。
    空间复杂度
    算法的空间复杂度并不是计算实际占用的空间，而是计算整个算法的辅助空间单元的个数
    非递归方式：
    由于辅助空间是常数级别的所以：
    空间复杂度是O(1);
    递归方式：
    递归的次数和深度都是log2 N,每次所需要的辅助空间都是常数级别的：
    空间复杂度：O(log2N )
     */
    public static int binarySearch(int[] a, int target) {
        int result = -1;
        if (Utils.isEmptyArray(a) || target > a[a.length - 1] || target < a[0]) return result;//临界条件判断
        int start = 0;
        int end = a.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (a[mid] == target) {
                result = mid;
                break;
            } else if (a[mid] < target) start = mid + 1;
            else if (a[mid] > target) end = mid - 1;
        }
        return result;
    }

    /*
    递归方式
     */
    public static int binarySearch1(int[] a, int target, int start, int end) {
        if (Utils.isEmptyArray(a) || target > a[end] || target < a[start]) return -1;//临界条件判断,避免造成不必要的循环
        int mid = (start + end) / 2;
        if (a[mid] < target) {
            return binarySearch1(a, target, mid + 1, end);
        } else if (a[mid] > target) {
            return binarySearch1(a, target, start, mid - 1);
        } else {
            return mid;
        }
    }


    public static void main(String[] args) {
        int[] source = new int[]{0, 1, 2, 2, 4, 5, 8, 10};
        int target = 1020;
//        int result = binarySearch(source, target);
        int result = binarySearch1(source, target, 0, source.length - 1);
        if (result == -1) {
            System.out.println("查找的是" + target + ",序列中没有该数！");
        } else {
            System.out.println("查找的是" + target + ",数组下标为：" + result);
        }
    }
}
