import java.util.ArrayList;
import java.util.HashMap;

public class Solution07 {
 public class Graph{
	 private ArrayList<Project> nodes=new ArrayList<Project>();
	 private HashMap<String,Project> hm=new HashMap<String,Project>();
	 
	 public ArrayList<Project> getNodes(){
		 return nodes;
	 }
	 
	 public Project getProject(String name){
		 if(!hm.containsKey(name)){
			 Project p=new Project(name);
			 nodes.add(p);
			 hm.put(name,p);
		 }
		 return hm.get(name);
	 }
	 
	 public void addDeps(String f,String s){
		 Project first=getProject(f);
		 Project second=getProject(s);
		 first.addChildren(second);
	 }
	 }
 public class Project{
	 private ArrayList<Project> children=new ArrayList<Project>();
	 private HashMap<String,Project> hm=new HashMap<String,Project>();
	 private String name;
	 private int deps=0;//dependencies
	 
	 public String getName(){
		 return name;}
	 public ArrayList<Project> getChildren(){
		 return children;
	 }
	 public int getNumofDeps(){
		 return deps;
	 }
	 
	 public void increDeps(){
		 deps++;
	 }
	 
	 public void decreDeps(){
		 deps--;
	 }
	 public Project(String n){ name=n;}
	 
	 public void addChildren(Project p){
		 if(!hm.containsKey(p.getName())){
			 children.add(p);
			 p.increDeps();
		 }
	 }
	 
 }
 
 /*find correct order*/
 Project[] findOrder(String[] projects,String[][] deps){
	 Graph g=createGraph(projects,deps);
	 return getOrderProjects(g.getNodes());
 }

 /*return a list of correct order projects */
private Project[] getOrderProjects(ArrayList<Project> projects) {
	Project[] order=new Project[projects.size()];
	/*if  project has no deps,then add it to the order*/
	int lastIndex=addNondeps(order,projects,0);
	int process=0;
	while(process<order.length){
		Project cur=order[process];
		
		if(cur==null){
			return null;
		}
		
		/*decrease dependencies of neighbor project*/
		ArrayList<Project> children=cur.getChildren();
		for(Project child:children){
			child.decreDeps();
		}
		
		/*if child has no dependencies,then add to order*/
		lastIndex=addNondeps(order, children, lastIndex);
		process++;
	}
	
	return order;
}

/*if child has no dependencies,then add to order at position of index*/
private int addNondeps(Project[] order, ArrayList<Project> projects, int index) {
	for(Project project:projects){
		if(project.getNumofDeps()==0){
			order[index]=project;
			index++;
		}
	}
	return index;
}

/*create the graph and add dependency(a,b)*/
private Graph createGraph(String[] projects, String[][] deps) {
	Graph graph= new Graph();
	for(String project:projects){
		graph.getProject(project);
	}
	
	for(String[] dep:deps){
		String start=dep[0];
		String end=dep[1];
		graph.addDeps(start, end);
	}
	return graph;
}
}
