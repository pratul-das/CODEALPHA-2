import java.util.*;

public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> scores = new ArrayList<>();

        System.out.println("🎓 Student Grade Tracker");
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        // Input students
        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter score for " + name + ": ");
            int score = sc.nextInt();
            sc.nextLine(); 
            names.add(name);
            scores.add(score);
        }

        // Calculate average, highest, lowest
        int total = 0, highest = Integer.MIN_VALUE, lowest = Integer.MAX_VALUE;
        String topStudent = "", lowStudent = "";

        for (int i = 0; i < scores.size(); i++) {
            int score = scores.get(i);
            total += score;

            if (score > highest) {
                highest = score;
                topStudent = names.get(i);
            }
            if (score < lowest) {
                lowest = score;
                lowStudent = names.get(i);
            }
        }

        double average = (double) total / n;

        // Summary
        System.out.println("\n📊 Summary Report:");
        for (int i = 0; i < n; i++) {
            System.out.println(names.get(i) + " → " + scores.get(i));
        }
        System.out.println("\nAverage Score: " + average);
        System.out.println("Highest Score: " + highest + " (" + topStudent + ")");
        System.out.println("Lowest Score: " + lowest + " (" + lowStudent + ")");

        sc.close();
    }
}