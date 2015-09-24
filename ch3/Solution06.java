import java.util.LinkedList;
public class Solution06 {
abstract class Animal{
	private int age;
    public Animal(){
    	
    }
    public int getAge(){
    	return age;
    }
    public void setAge(int age){
    	this.age=age;
    }
    
    //compare age 
    public boolean isOlder(Animal a){
    	return this.age<a.getAge();
    }
}

public class Dog extends Animal{
	
}

public class Cat extends Animal{
	
}
    class AnimalQueue{
    	LinkedList<Cat> cats= new LinkedList<Cat>();
    	LinkedList<Dog> dogs= new LinkedList<Dog>();
    	private int position=0;//compare age 
    	
    	 public void enqueue(Animal a){
    		 a.setAge((position));
    		 position++;
    		 if(a instanceof Dog) {
    			 dogs.addLast((Dog) a);
    		 }else if(a instanceof Cat){
    			 cats.addLast((Cat) a);
    		 } 
    	 }
    	 
    	 public Animal dequeueAny(){
    		 //pop the earliest element
    		 if(dogs.size()==0){
    			 return dequeueCats();
    		 }else if(cats.size()==0){
    			 return dequeueDogs();
    		 }
    		 Dog dog=dogs.peek();
    		 Cat cat=cats.peek();
    		 if(dog.isOlder(cat)){
    			 return dequeueDogs();
    		 }else{
    			 return dequeueCats();
    		 }
    	 }
    	 
    	 public Dog dequeueDogs(){
    		 return dogs.poll();
    	 }
    	 
    	 public Cat dequeueCats(){
    		 return cats.poll();
    	 }
    }
	public static void main(String[] args) {
	}

}
