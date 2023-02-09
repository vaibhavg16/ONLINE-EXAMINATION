import java.util.Scanner;
import java.util.*;
public class ExamSystem 
{
    private static final 
    Scanner sc = new Scanner(System.in);
    private static String[][] mcqs = {
        {"What is the capital of France?", "Paris", "Rome", "London", "A"},
        {"What is the largest country in the world by area?", "Russia", "China", "USA", "A"},
        {"Who is the founder of Microsoft?", "Steve Jobs", "Bill Gates", "Elon Musk", "B"},
        {"What is the currency of Japan?", "Yen", "Dollar", "Euro", "A"},
        {"What is the name of the first man on the moon?", "Neil Armstrong", "Buzz Aldrin", "Michael Collins", "A"}
    };
    private static String[] answers = new String[mcqs.length];
    private static int sessionDuration = 60 * 1000; // 1 minute in milliseconds
    private static long endTime;

    public static void main(String[] args) 
    {
        System.out.println("Welcome to the exam system");

        while (true) {
            System.out.println("\n1. Login");
            System.out.println("2. Update Profile");
            System.out.println("3. Update Password");
            System.out.println("4. Take Exam");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) 
            {
                case 1:
                    login();
                    break;
                case 2:
                    updateProfile();
                    break;
                case 3:
                    updatePassword();
                    break;
                case 4:
                    takeExam();
                    break;
                case 5:
                    Logout();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void login() 
    {
        System.out.print("\nEnter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        System.out.println("\nLogin successful.");
    }

    private static void updateProfile() {
        System.out.println("\nUpdating profile...");
        
        System.out.println("Profile updated.");
    }  
    public static void updatePassword() 
    {
    	 
    	    Scanner sc = new Scanner(System.in);
    	    System.out.print("Enter current password: ");
    	    String password = sc.nextLine();
    	    System.out.print("Enter new password: ");
    	    String newPassword = sc.nextLine();

    	    if(newPassword==password)
    	    {
    	    	System.out.print("Password cannot be same as before: ");
    	    }
    	    else
    	    {
    	    	System.out.print("password changed ");
    	    	login();
    	    }	    
    }
    
    private static void takeExam() 
    {
        System.out.println("\nStarting exam...");
        endTime = System.currentTimeMillis() + sessionDuration;

        while (System.currentTimeMillis() < endTime) {
            int score = 0;
            for (int i = 0; i < mcqs.length; i++) 
            {
                String question = mcqs[i][0];
                String optionA = mcqs[i][1];
                String optionB = mcqs[i][2];                             
                String optionC = mcqs[i][3];
                String correctOption = mcqs[i][4];

                System.out.println("\nQuestion " + (i + 1) + ": " + question);
                System.out.println("A. " + optionA);
                System.out.println("B. " + optionB);
                System.out.println("C. " + optionC);
                System.out.print("Enter your answer: ");
                answers[i] = sc.nextLine();

                if (answers[i].equals(correctOption)) 
                {
                    score++;
                }
            }

            System.out.println("\nExam finished.");
            System.out.println("Your score is: " + score + " out of " + mcqs.length);
            Logout();
            
        }

        if (System.currentTimeMillis() >= endTime) 
        {
            System.out.println("Time's up. Your answers will be submitted automatically.");
        }
    }

    private static void Logout() 
    {
        System.out.println("\nLogging out...");
        System.out.println("Session closed. Goodbye!");
        System.exit(0);
    
    }
}
