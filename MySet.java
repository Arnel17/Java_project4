public class MySet extends LinkedList{

 //add method add()without duplication
   public void add(int item){
      if(!isFound(item))
         addLast(item);
   }
 
   public MySet union(MySet set){
   
      MySet union = new MySet();
      Node p = this.head;
      while(p != null)
      {
         union.add(p.getItem());
         p = p.getNext();
      }
   //proceed to argument object
      Node p2 = set.head;
      while(p2 != null){
         union.add(p2.getItem());
         p2 = p2.getNext();
      }
      return union;
   }

 
   public MySet intersection(MySet set){
      MySet inter = new MySet();
      Node p = this.head;
      Node p2  = set.head;
      while(p != null) {
         while(p2 != null) {
            if(p.getItem() == p2.getItem())
               inter.add(p.getItem());
            p2 = p2.getNext();
         }
         p = p.getNext();
         p2 = set.head;
      }
      return inter;
   }
   public MySet difference(MySet set){
      MySet diff = new MySet();
      Node p = this.head;
      Node p2 = set.head;
      while(p != null) {
         while(p2 != null) {
            if(!set.isFound(p.getItem()))
               diff.add(p.getItem());
            p2 = p2.getNext();
         }
         p = p.getNext();
         p2 = set.head;
      }
      return diff;
   }
   
   public boolean isSubset(MySet set){
      Node p = this.head;
      Node p2 = set.head;
      boolean check = false;
      while(p != null) {
         while(p2 != null) {
            if(!set.isFound(p.getItem())== (set.isFound(p2.getItem())))
               return check;
            p2 = p2.getNext();
         }
         p = p.getNext();
         p2 = set.head; 
      }
      return check = true; 
   }
   
   public int cardinality(){
      return count;
   } 
 
   public static void main(String []args){
      MySet setA = new MySet();
      MySet setB = new MySet();
      setA.add(5);
      setA.add(6);
      setA.add(1);
      setA.add(2);
      setA.add(3);
      
      setB.add(7);
      setB.add(5);
      setB.add(9);
      setB.add(8);
      setB.add(6);
      setB.add(2);
      setB.add(4);
      setB.add(1);
      setB.add(3);
      setB.add(10);
      
      System.out.println("setA contains : " + setA);
      System.out.println("setB contains : " + setB);
      System.out.println("setA.union(setB) : " + (setA.union(setB)));
      System.out.println("setA intersection(setB) :" + setA.intersection(setB));
      System.out.println("setA.Difference(setB): " + setA.difference(setB));
      System.out.println("setB.Difference(setA): " + setB.difference(setA));
      System.out.println("setA subSet(setB) : " + setA.isSubset(setB));
      System.out.println("setB subSet(setA) : " + setB.isSubset(setA));
      System.out.println("setA.cardinality: " + setA.cardinality());
      System.out.println("setB.cardinality: " + setB.cardinality());  
   }
}