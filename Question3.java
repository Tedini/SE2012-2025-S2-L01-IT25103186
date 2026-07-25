import java.util.Scanner;

public class Question3 {

    static Scanner input = new Scanner(System.in);

    static String subs[] = {"Mathematics", "Chemistry", "Physics"};
    static int scores[][];
    static int tot_s[];
    static String grades[][];
    public static void main(String[] args) {

        System.out.println("_".repeat(40));
        System.out.println(" ".repeat(15) + "QUESTION 3");
        System.out.println("_".repeat(40));

        System.out.print("Enter the number of students: ");
        int n = input.nextInt();

        int s = subs.length;
        scores = new int[n][s];
        tot_s = new int[n];
        grades = new String[n][s];
        int in;

        do {

            menu();

            System.out.print("Enter your option: ");
            in = input.nextInt();

            switch (in) {

                case 1:
                    addMarks(n);
                    break;

                case 2:
                    updateMarks();
                    break;

                case 3:
                    System.out.println("Average of each student");

                    totStu();

                    for (int i = 0; i < n; i++) {
                        System.out.printf("Student %d: %.2f%n", i + 1, avgStu(i));
                    }

                    break;

                case 4:
                    System.out.println("Average of each subject");
                    avgSub(n);
                    break;

                case 5:
                    System.out.println("Total marks of each student");

                    totStu();

                    for (int i = 0; i < n; i++) {
                        System.out.printf("Student %d: %d%n", i + 1,tot_s[i]);
                    }

                    break;

                case 6:
                    display();
                    break;
                case 7:
                    System.out.println("____________GRADES__________");
                    gradSummary();
                    break;

                case 8:
                    System.out.println("EXITED");
                    break;

                default:
                    System.out.println("INVALID");
            }

        } while (in != 8);
    }

    public static void menu() {

        System.out.println("\n" + "___".repeat(20));
        System.out.println(" ".repeat(17) + "MENU");
        System.out.println("___".repeat(20));

        System.out.println("Press a number from 1-8 to choose an option.\n");
        System.out.println("1.) Enter marks for subjects");
        System.out.println("2.) Update a student's mark");
        System.out.println("3.) View AVERAGE of each student");
        System.out.println("4.) View AVERAGE of each subject");
        System.out.println("5.) View TOTAL marks of each student");
        System.out.println("6.) Display Table");
        System.out.println("7.) Get SUMMARY of GRADES");
        System.out.println("8.) EXIT");

        System.out.println("___".repeat(20));
    }

    public static void addMarks(int num) {

        for (int n = 0; n < num; n++) {

            System.out.printf("________ Student %d ________%n",n + 1);

            for (int s = 0; s < subs.length; s++) {
                int mark;
                do {
                    System.out.printf("%s: ", subs[s]);
                    mark = input.nextInt();
                    if (mark < 0 || mark > 100) {
                        System.out.println("INVALID! Marks must be between 0 and 100.");
                    }
                } while (mark < 0 || mark > 100);
                scores[n][s] = mark;
            }

            System.out.println();
        }
    }

    public static void updateMarks() {

        System.out.print("Enter the student ID: ");
        int s_ID = input.nextInt();

        System.out.print("Enter the Subject ID (Math: 1, Chemistry: 2, Physics: 3): ");
        int sub_ID = input.nextInt();

        if (s_ID < 1 || s_ID > scores.length) {
            System.out.println("INVALID student ID.");
        } else if (sub_ID < 1 || sub_ID > subs.length) {
            System.out.println("INVALID subject ID.");
        } else {
            int newMark;
            do {
                System.out.print("Enter the NEW mark: ");
                newMark = input.nextInt();
                if (newMark < 0 || newMark > 100) {
                    System.out.println("INVALID! Marks must be between 0 and 100.");
                }
            } while (newMark < 0 || newMark > 100);

            scores[s_ID - 1][sub_ID - 1] = newMark;
            System.out.println("UPDATED");
        }
    }
    public static void display() {

        System.out.printf("%-12s", "");

        for (int s = 0; s < subs.length; s++) {
            System.out.printf("%15s", subs[s]);
        }

        System.out.println();

        for (int n = 0; n < scores.length; n++) {

            System.out.printf("%-12s","Student " + (n + 1));

            for (int s = 0; s < subs.length; s++) {
                System.out.printf("%15d", scores[n][s]);
            }

            System.out.println();
        }
    }

    public static void totStu() {

        for (int n = 0; n < scores.length; n++) {

            int tot = 0;

            for (int s = 0; s < subs.length; s++) {
                tot += scores[n][s];
            }
            tot_s[n] = tot;
        }
    }

    public static double avgStu(int n) {

        double avg_s = (double) tot_s[n] / subs.length;

        return avg_s;
    }

    public static void avgSub(int num) {

        for (int s = 0; s < subs.length; s++) {

            int tot_sub_marks = 0;

            for (int n = 0; n < scores.length; n++) {
                tot_sub_marks += scores[n][s];
            }

            double avg_sub = (double) tot_sub_marks / num;

            System.out.printf("%s: %.2f%n",subs[s],avg_sub);
        }
    }

    public static void gradSummary(){

        if (scores.length == 0) {
            System.out.println("NO student data");
            return;
        }
        if (subs.length == 0) {
            System.out.println("NO subject data");
            return;
        }

        for(int n = 0; n < scores.length; n++) {            
            for (int s = 0; s < subs.length; s++) {
                if (scores[n][s] < 0 || scores[n][s] > 100) {
                    System.out.println("INVALID SCORE");
                    return;
                }
                else if (scores[n][s] >= 90) {
                    grades[n][s] = "A";
                } else if (scores[n][s] >= 80) {
                    grades[n][s] = "B";
                } else if (scores[n][s] >= 70) {
                    grades[n][s] = "C";
                } else if (scores[n][s] >= 60) {
                    grades[n][s] = "D";
                } else {
                    grades[n][s] = "FAIL";
                }
            }
        }    
        System.out.printf("%-12s", "");

        for (int s = 0; s < subs.length; s++) {
            System.out.printf("%15s", subs[s]);
        }

        System.out.println();

        for (int n = 0; n < grades.length; n++) {

            System.out.printf("%-12s","Student " + (n + 1));

            for (int s = 0; s < subs.length; s++) {
                System.out.printf("%15s", grades[n][s]);
            }
            System.out.println();
        }
    }
}