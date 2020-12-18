package comp2402a4;

import java.util.Iterator;
import java.util.Random;

public class Tester {

  static <T> void showContents(Iterable<T> ds) {
    System.out.print("[");
    Iterator<T> it = ds.iterator();
    while (it.hasNext()) {
      System.out.print(it.next());
      if (it.hasNext()) {
        System.out.print(",");
      }
    }
    System.out.println("]");
  }
  public static int[] dataSet = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
  //dataSet = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
  static void RyabkoTreeTest(RyabkoTree ms, int n) {
    System.out.println(ms.getClass().getName());

    Random rand = new Random();
    for (int i = 0; i < n; i++) {
      //int x = dataSet[i];
      //System.out.println("push(" + i + ")");
      ms.push(i);
      //showContents(ms);
      //System.out.println("min() = " + ms.min());
    }
    for(int i = 0; i < n; i++){
      long x = ms.prefixSum(i);
      System.out.println("prefixSum() = " +x);
    }
    while (ms.size() > 15) {
      //showContents(ms);
      //System.out.println("min() = " + ms.min());
      System.out.println("pop() = " + ms.pop());
    }
    for(int i = 0; i < n; i++){
      long x = ms.prefixSum(i);
      System.out.println("prefixSum() = " +x);
    }
  }
 
  static void SlowPrefixStackTest(SlowPrefixStack ms, int n) {
    System.out.println(ms.getClass().getName());

    Random rand = new Random();
    for (int i = 0; i < n; i++) {
      //int x = dataSet[i];
      //System.out.println("push(" + i + ")");
      ms.push(i);
     // showContents(ms);
    }
    for(int i = 0; i < n; i++){
      long x = ms.prefixSum(i);
      System.out.println("prefixSum() = " +x);
    }
    while (ms.size() > 15) {
      // showContents(ms);
      //System.out.println("min() = " + ms.min());
      System.out.println("pop() = " + ms.pop());
    }
    for(int i = 0; i < n; i++){
      long x = ms.prefixSum(i);
      System.out.println("prefixSum() = " +x);
    }
  } 


  public static void main(String[] args) {
    RyabkoTreeTest(new RyabkoTree(), 80);
    SlowPrefixStackTest(new SlowPrefixStack(), 80);/*
    minStackTest(new FastMinStack<>(), 20);
    minDequeTest(new FastMinDeque<>(), 20); */
  }







}
