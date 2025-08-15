import java.util.Scanner;

public class miniproject {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int mynumber =(int)(Math.random()*100);
        int usernumber=0;
        do{
            System.out.println("guess my number(1-100):");
            usernumber= sc.nextInt();
            if(usernumber==mynumber){
                System.out.println("WOOHOOO...CORRECT NUMBER");
                break;
            }
            else if(usernumber>mynumber){
                System.out.println("YOUR NUMBER IS LARGE");

            }
            else{
                System.out.println("YOUR NUMBER IS SMALLER");
            }
        }while (usernumber>=0);
        System.out.println("my number was :");
        System.out.println(mynumber);

    }


}

