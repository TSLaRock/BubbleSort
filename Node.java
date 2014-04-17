public class Node{
  
  
  // -- DATA -- \\
  private int key;
  private int index;
  private Node nextNode;
  private Node previousNode;
  
  
  // -- CONSTRUCTOR -- \\
  
  public Node(int key)
  {
    this.setKey(key);
  }
  //this.letterGrade = getLetterGrade(key);
  
  // -- METHODS -- \\
 
  
  //getKey
  public int getKey()
  {return (this.key);}
  
  
  //setKey(float)
  public void setKey(int key)
  {
    this.key = key;
  }
  
  //setNextNode
  public void setNextNode(Node nextNode)
  {
    this.nextNode = nextNode;
  }
  
  //getNextNode
  public Node getNextNode()
  {
    return nextNode;
  }
  
  public void setIndex(int index)
  {
    this.index = index;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public void setPreviousNode(Node previousNode)
  {
    this.previousNode = previousNode;
  }
  
  public Node getPreviousNode()
  {
    return previousNode;
  }

  public void printNode()
  {
    System.out.println(key);
  }
  
}