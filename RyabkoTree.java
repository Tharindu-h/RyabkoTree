package comp2402a4;

import java.util.Iterator;
import java.util.*;

public class RyabkoTree implements PrefixStack {
  int n;
  int totalSize;
  private int[] arr;
  private long[] fenwick;

  public RyabkoTree() {
    n = 0;
    totalSize = 10;
    arr = new int [10];
    fenwick = new long[11];
    fenwick[0] = 0;
  }

  public void push(int x) {
    arr[n] = x;
    update(x,n);
    resize();
    n++;
  }

  public int pop() {
    int val = arr[n-1];
    arr[n-1] = 0;
    int negVal = -val;
    update(negVal,n-1);
    n--;
    return val;
  }


  public int get(int i) {
    return arr[i];
  }

  public int set(int i, int x) {
    int ori = arr[i];
    arr[i] = x;
    int diff = x-ori;
    update(diff,i);
    return ori;
  }

  public long prefixSum(int i) {
    long sum = 0;
    i += 1;
    while(i > 0){
      sum += fenwick[i];
      i -= i & (-i);
    }
    return sum;
  }

	public int size() {
	  return n;
	}

	public Iterator<Integer> iterator() {
	  return null;
	}


  public void update(int data, int index){
    index += 1;
    while(index <= totalSize){
      fenwick[index] += data;
      index += index & (-index); 
    }
  }

  public void resize(){
    if(n >= totalSize -1){
      int[] temparr = new int[totalSize * 2];
      long[] tempfen = new long[(totalSize*2) + 1];
      fenwick = tempfen;
      int x = totalSize;
      totalSize = totalSize * 2;
      for (int i = 0; i < x; i++){
        temparr[i] = arr[i];
        update(arr[i],i);
      }
      arr = temparr; 
    }
  }

}
