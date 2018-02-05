package BinarySearch;


import java.util.Arrays;

import StdMethods.In;
import StdMethods.StdIn;
import StdMethods.StdOut;

//	二分查找
public class BinarySearch {
	public static int rank(int key, int[] a){
		//	数组必须是有序的
		int lo = 0;
		int hi = a.length - 1;
		while (lo<=hi){
			//	被查找的键要么不存在，要么必然存在于a[lo...hi]之中
			int mid = lo + (hi - lo) / 2;
			if (key < a[mid]) hi = mid - 1;
			else if (key > a[mid]) lo = mid + 1;
			else return mid;
		}
		return -1;
	}
	
	public static void main(String[] args){
		//	会从命令行指定文件中读取多个整数，并会打印出标准输入中所有不存在于该文件中的整数
		In in = new In("largeT.txt");
		int[] whitelist = in.readAllInts();
		Arrays.sort(whitelist);
		while (!StdIn.isEmpty()){
			//	读取键值，如果不存在于白名单中则将其打印
			int key = StdIn.readInt();
			if(rank(key,whitelist)<0)
				StdOut.println(key);
		}
	}
}
