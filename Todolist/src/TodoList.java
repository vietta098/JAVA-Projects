
import java.util.*;


public class TodoList implements App {
	private String task;
	private String time;
	private int id;
	
	private static ArrayList<TodoList> list = new ArrayList<TodoList>();
	
	public TodoList() {}


	public void addTask(String task) {
		// TODO Auto-generated method stub
		this.task = task;
	}


	public void addTime(String time) {
		// TODO Auto-generated method stub
		this.time = time;
		list.add(this);
		id = list.size();
	}
	
	public void addATask(String task, String time) {
		this.task = task;
		this.time = time;
		list.add(this);
		id = list.size();
	}


	public String returnTask(String time) {
		// TODO Auto-generated method stub
		String toReturn = "";
		for(int i = 0; i < list.size(); i++) {
			if(time.equalsIgnoreCase(list.get(i).time)) {
				toReturn = list.get(i).task;
			}
		}
		
		return toReturn;
	}
	
	// return entire list
	public static ArrayList<TodoList> returnAll() {
					
		return list;
	}
	public String toString() {
		return "\t" + time + "\t" + task + "\n";
	}
	
	
}
