import java.util.Scanner;


public class GradeCalculator{
    public static void main(String args[]){
        Scanner scanner =new Scanner(System.in);


        System.out.println("Welcome to the Student Grade Calculator! ");

        // Collect grade for different components
        double assignmentScore=collectScore("assignments", scanner);
        double quizzesScore=collectScore("quizzes",scanner);
         double midtermExamScore=collectScore("midterm exam",scanner);
          double finalExamScore=collectScore("final exam",scanner);

          //define the grading scale
          double[] gradeThresholds={90,80,70,60};
          String[] letterGrades={"A","B","C","D","F"};

          //calculate the overall course grade
          double totalScore=calculateTotalScore(assignmentScore,quizzesScore,midtermExamScore,finalExamScore);
          String courseGrade=calculateCourseGrade(totalScore,gradeThresholds,letterGrades);


          //display the result
          System.out.println("Total Score: "+totalScore);
          System.out.println("Course Grade: "+courseGrade);
          scanner.close();
    }


    //Implement a function to collect grades
    public static double collectScore(String temp,Scanner scanner){
        double grade;
        do{
            System.out.println("Enter your score for "+temp+"(out of 100)");
            grade=scanner.nextDouble();
            if(grade<0||grade>100){
                System.out.println("Invalid input! please enter a score between 0 and 100.");
            }
        }while(grade<0||grade>100);
        return grade;
    }


    //implement a function to calculate the total score
    public static double calculateTotalScore(double assignment,double quizzes,double midterm,double finalterm){
       return assignment+quizzes+midterm+finalterm;
    }

    
    //implement a function to calculate course grade
    public static String calculateCourseGrade(double totalScore,double[] threshold,String[] grades){
        for(int i=0;i<threshold.length;i++){
            if(totalScore/4>=threshold[i]){
                return grades[i];
            }
        }
        return grades[grades.length-1];
    }
}