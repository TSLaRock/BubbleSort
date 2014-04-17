import java.util.*;
public class Main
{
  public static void main(String args[])
  {   
    // This class is designed to test my
    // BubbleSort method, implemented in LinkedList.
    // The list testList is created and given a certain amount
    // of pseudorandom numbers using the java utility
    // library. The list is printed, then sorted, then
    // the sorted list is printed. 
    
    final int size = 30;
    LinkedList testList = new LinkedList();
    Random rand = new Random();
    for(int i = 0; i < size; i ++)
    {
      testList.addNode(rand.nextInt(1000));
    }

    // print the unsroted list
    testList.printList();
    System.out.println("");
    
    // run BubbleSort on the list
    testList.BubbleSort();
    
    // print the sorted list
    testList.printList();
    
    
    /*
     // my test data, because random numbers
     // are silly to use for testing
     LinkedList testList = new LinkedList();
     testList.addNode(650);
     testList.addNode(500);
     testList.addNode(700);
     testList.addNode(200);
     testList.addNode(220);
     testList.addNode(190);
     testList.addNode(150);
     testList.addNode(780);
     testList.addNode(400);
     testList.addNode(900);
     testList.addNode(10);
     */
    
  }// end main
  
  
}// end class