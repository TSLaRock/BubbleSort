public class LinkedList
{
  // -- DATA -- \\
  private Node node;
  private Node head;
  private Node currentNode;
  private int size = 0;
  
  // -- CONSTRUCTOR -- \\
  
  // constructor for empty object
  public LinkedList()
  {
    head = null;
    currentNode = head;
    size = 0;
    
  }
  
  // constructor with head node given
  public LinkedList(Node newNode)
  {
    this.head = node;
    this.currentNode = head;
    this.size = 1;
  }
  
  
  // -- METHODS -- \\
  
  //isEmpty
  public boolean isEmpty()
  {
    return(head == null);
  }
  
  public Node getHead()
  {
    return head;
  }
  
  public void addNode(int key)
  {
    node = new Node(key);
    // if the list is empty, make 
    // node the head of the list
    if(size == 0) 
    {
      head = node;
      currentNode = head;
      head.setPreviousNode(null);
      head.setNextNode(null);
      head.setIndex(0);
      size++;
    }
    else if(size == 1)
    {
      head.setNextNode(node);
      node.setIndex(1);
      node.setNextNode(null);
      node.setPreviousNode(head);
      size++;
    }
    else
    {
      findNode(size - 1);
      currentNode.setNextNode(node);
      node.setPreviousNode(currentNode);
      size++;
      node.setIndex(size);
    } 
    // reset currentNode and previousNode
    currentNode = head;
    
  }
  
  // Remove student from the menu selection
  public void removeNode(int key)
  {
    currentNode = head;
    findNode(key);
    System.out.println(currentNode.getKey());
    // Change the references of the next and previous student
    
    if(currentNode.getNextNode() == null) 
    {
      currentNode = null; 
    }
    else{
      currentNode.getPreviousNode().setNextNode(currentNode.getNextNode());
      // set the previous and next student to null
      currentNode.getPreviousNode().setNextNode(currentNode.getNextNode());
      currentNode.getNextNode().setPreviousNode(currentNode.getPreviousNode());
    }
    size--;
    currentNode = head;
    
  }
  
  // remove student for internal use  
  public void removeNode()
  {
    // Change the references of the next and previous student
    currentNode.getNextNode().setPreviousNode(currentNode.getPreviousNode());
    currentNode.getPreviousNode().setNextNode(currentNode.getNextNode());
    // set the previous and next student to null
    currentNode.setPreviousNode(null);
    currentNode.setNextNode(null);
  }
  
  // DeleteAll method
  public void deleteAll()
  {
    currentNode = head;
    currentNode = null;
    head = null;
    size = 0;
  }
  
  // getSize
  public int getSize()
  { return (size); }  
  
  //findNode for internal use
  public void findNode(int index)
  {     
    for(int i = 0; i < index; i++)
    {
      currentNode = currentNode.getNextNode();
    }
  }
  
  // method to test whether the list is in order or not
  public boolean inOrder()
  {
    currentNode = head;
    // traverse the list from head to tail
    for(int i = 0; i < size; i++)
    {
      // if the currentNode's next exists
      if(currentNode.getNextNode() != null)
      {
        // if the currentNode's key is greater than its nextNode's key
        if(currentNode.getKey() > currentNode.getNextNode().getKey())
        {
          // the list isn't in order,
          // change currentNode to head and
          // return false
          currentNode = head;
          return false;
        }
      }
      // move currentNode to the nextNode if it 
      // isn't null
      if(currentNode.getNextNode() != null)
        currentNode = currentNode.getNextNode();
    }
    
    // if the list is in order
    // change currentNode to head
    // and return true
    currentNode = head;
    return true;
  }
  
  // method swaps two nodes in this list
  public void swap(Node firstNode)
  { 
    // create a reference to the node to be swapped with
    Node secondNode = firstNode.getNextNode();
    // special case for the head of the list
    if(firstNode.getPreviousNode() == null)
    {
      // set the firstNode's next to the secondNode's next
      firstNode.setNextNode(secondNode.getNextNode());
      // set firstNode's previous to secondNode
      firstNode.setPreviousNode(secondNode);
      // set the secondNode's previous to null
      secondNode.setPreviousNode(null);
      // set the secondNode's next to the firstNode
      secondNode.setNextNode(firstNode);
      // set the secondNode's next node's previous to firstNode
      firstNode.getNextNode().setPreviousNode(firstNode);
      
      this.head = secondNode;
      // set head's index to 0
      head.setIndex(0);
      secondNode.setIndex(0);
      // set firstNode's index to 1
      firstNode.setIndex(1);
    }
    // if the node to be swapped with is the last in the list
    else if(secondNode.getNextNode() == null)
    {
      // change the references between the two nodes
      // set the secondNode's next to firstNode
      secondNode.setNextNode(firstNode);
      // set the secondNode's previous to firstNode's previous
      secondNode.setPreviousNode(firstNode.getPreviousNode());
      // set the firstNode's next to null (it's the tail)
      firstNode.setNextNode(null);
      // set the firstNode's previous to secondNode
      firstNode.setPreviousNode(secondNode);
      secondNode.getPreviousNode().setNextNode(secondNode);
      
      
      // change the index values
      // save one index in a temp variable
      int firstIndex = firstNode.getIndex();
      // change the index of the firstNode to that of the second
      firstNode.setIndex(secondNode.getIndex());
      // change the index of the secondNode to the first, saved in the temp variable
      secondNode.setIndex(firstIndex); 
    }
    // if the node to be swapped is in the middle of the list
    else
    { 
      // set the firstNode's next to the secondNode's next
      firstNode.setNextNode(secondNode.getNextNode());
      // set the secondNode's previous to the firstNode's previous
      secondNode.setPreviousNode(firstNode.getPreviousNode());
      //  set the firstNode's previous to the secondNode
      firstNode.setPreviousNode(secondNode);
      // set the secondNode's next to the first node
      secondNode.setNextNode(firstNode);
      //set the secondNode's new previous reference to reference it
      secondNode.getPreviousNode().setNextNode(secondNode);
      // opposite for first node
      firstNode.getNextNode().setPreviousNode(firstNode);
      
      
      
      // change the index values
      // save one index in a temp variable
      int firstIndex = firstNode.getIndex();
      // change the index of the firstNode to that of the second
      firstNode.setIndex(secondNode.getIndex());
      // change the index of the secondNode to the first, saved in the temp variable
      secondNode.setIndex(firstIndex); 
    }
  }
  
  
  // implementation of a BubbleSort
  public void BubbleSort()
  {
    // while the list isn't in order (inOrder() returns false)
    while(!inOrder())
    {
      // test all the nodes in the list
      for(int i = 0; i < size; i++)
      {
        // if the currentNode's next isn't null
        if(currentNode.getNextNode() != null)
          // if the nodes are out of order
          if(currentNode.getKey() > currentNode.getNextNode().getKey())
        {
          // swap the nodes
          swap(currentNode);
        }
        // if the current nodes next isn't null
        if (currentNode.getNextNode() != null)
          // traverse forward
          currentNode = currentNode.getNextNode();
      }
      // reset currentNode to head so inOrder/printList will
      // behave properly
      currentNode = head;
    }
    
  }
  
  
  //printList() method to print the list 
  // from head to tail
  public void printList()
  {
    
    if(this.isEmpty()) 
    {
      System.out.println("ERROR: EMPTY LIST.");
    }
    else
    {
      for(int i = 0; i < size; i++)
      {
        currentNode.printNode();
        if(currentNode.getNextNode() != null)
          currentNode = currentNode.getNextNode();
      }
      currentNode = head;
      
    }
  }
  
  
  // printBackwards() method to make sure the list
  // is actually doubly linked and print it backwards
  public void printBackwards()
  {
    while(currentNode.getNextNode() != null)
    {
      currentNode = currentNode.getNextNode();
    }
    for(int i = 0; size > i; i++)
    {
      currentNode.printNode();
      if(currentNode.getPreviousNode() != null)
        currentNode = currentNode.getPreviousNode();
    }
    currentNode = head; 
  }
}