import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
public class ToDolist {
    private static final String FILE_NAME = "tasks.txt";

    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        loadtasks(tasks);
     while(true){
         System.out.println("===TO-DO LIST===");
         System.out.println("1:add task");
         System.out.println("2:delete task");
         System.out.println("3:edit task");
         System.out.println("4:view task");
         System.out.println("5:save and exit");
         System.out.println("enter your choice");
         int choice=sc.nextInt();
         sc.nextLine();

         switch (choice){
             case 1:
                 //add task
                 System.out.println("enter new task:");
                 String newtask =sc.nextLine().trim();
                 if (!newtask.isEmpty()) {
                     tasks.add(newtask);
                     System.out.println("task added successfully!");
                 } else {
                     System.out.println("Task cannot be empty.");
                 }
                 break;


             case 2:
                 //delete task
                 viewtasks(tasks);
                 if(!tasks.isEmpty()){
                     System.out.println("enter the task number to be deleted");
                     int deleteindex = sc.nextInt()-1;
                     sc.nextLine();
                     if(deleteindex>=0 && deleteindex< tasks.size()) {
                         tasks.remove(deleteindex);
                         System.out.println("tasks deleted successfully!");
                     }
                     else{
                         System.out.println("invalid task number!");
                     }

                 }
                 break;

             case 3:
                 //edit task
                 viewtasks(tasks);
                 if(!tasks.isEmpty()){
                     System.out.println("enter the task number to be updated:");
                     int Updateindex = sc.nextInt()-1;
                     sc.nextLine();
                     if(Updateindex>=0&& Updateindex <tasks.size()){
                         System.out.println("enter the new task :");
                         String Updatedtasks=sc.nextLine().trim();
                         tasks.set(Updateindex ,Updatedtasks);
                         System.out.println("tasks updated successfully!");
                     }
                     else{
                         System.out.println("invalid task number!");
                     }
                 }
                 break;

             case 4 :
                 viewtasks(tasks);
                 break;


             case 5:
                 //save and exit
                 Savetasks(tasks);
                 System.out.println("task save successfully!");
                 sc.close();
                 return;

             default:

                 System.out.println("inavalid choice try again");
                 break;
          }

       }
    }
    private static void viewtasks(ArrayList<String> tasks) {
        if (tasks.isEmpty()) {  // check if empty
            System.out.println("no tasks available!");
        } else {
            System.out.println("\nyour task:");
            for (int i = 0; i < tasks.size(); i++) {
                String task = tasks.get(i).trim();
                if (!task.isEmpty()) {
                    System.out.println((i + 1) + " . " + task);
                }
            }
        }
    }


    private static void loadtasks(ArrayList<String>tasks){
        try (BufferedReader rd = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = rd.readLine()) != null) {
                tasks.add(line);
            }
        }
        catch (IOException e){

            }
        }

    private static void Savetasks(ArrayList<String>tasks){
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(FILE_NAME))) {
        for(String task:tasks){
            wr.write(task);
            wr.newLine();
        }
    }
        catch (IOException e) {
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }


}