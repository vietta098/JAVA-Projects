import java.util.*;
public class drive {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		TodoList myToDoList = new TodoList();
		
		String input = "";
		
		
		do{
			System.out.println("Add (a), Retrieve (r) a task or quit (q)? ");
			input = sc.nextLine();
			if(input.equalsIgnoreCase("a")){
				System.out.println("Enter task's name --> ");
				String name = sc.nextLine();
				System.out.println("Enter time --> ");
				String time = sc.nextLine();
				myToDoList.addATask(name, time);
				
			}
			else if(input.equalsIgnoreCase("r")){
				System.out.println("Enter time --> ");
				input = sc.nextLine();				
				System.out.println(myToDoList.returnTask(input));
			}
			else {
				break; 
			}
		}while(true);	
	}
}
