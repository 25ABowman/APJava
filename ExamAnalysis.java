import java.util.Arrays;

public class ExamAnalysis
{
    private String[] nicknames;
    private boolean [][] answered;
    //return percent of students who didnt answer correctll
    //read at kth for every student 
    public int getDifficulty(int k){
        boolean [] row = answered [k];
        int wrong = 0;
        for (int i= 0; i < row.length; i++ ){
            if( row[i] == false){
                wrong ++;
            }
        }
        return Math.round(row.length/ wrong);
    }
    //make a new object and return array of examquestions from nicknames 
    public ExamQuestion[] makeQuestionsList(){
        ExamQuestion[] questions = new ExamQuestion[nicknames.length];
        for (int i =0; i< nicknames.length; i++){
           //add nicknames and difficulty 
            String nickname = nicknames [i];
            int Difficulty = getDifficulty(i);  
            questions [i] = new ExamQuestion(nickname, Difficulty);
        }
        return questions;

    }
    public static void sort(ExamQuestion[] questions){
        int n = questions.length;
        for (int i = 0; i < n - 1; i++) {
          
            // Find the minimum element in unsorted array
            int min_idx = i;
            
            for (int j = i + 1; j < n; j++) {
                ExamQuestion temp = questions[j];
                if (questions[j].compareTo(questions[min_idx]) == -1)
                    min_idx = j;
            }

            // Swap the found minimum element with the first
            // element
            ExamQuestion temp = questions[min_idx];
            questions[min_idx] = questions[i];
            questions[i] = temp;
        }
    }
    public static void main(String[] args)
    {
      ExamAnalysis test = new ExamAnalysis();
      test.nicknames = new String[] {"Appaloosa", "Twister", "AP Scholar", "Exam Questions"};
      test.answered = new boolean[][] {{true, true, true, false},
                                     {false, true, true, false},
                                     {true, false, true, true},
                                     {false, true, false, false},
                                     {false, false, true, false}};
  
      ExamQuestion[] questions = test.makeQuestionsList();
      ExamAnalysis.sort(questions);
      System.out.println(Arrays.asList(questions));
  }
}

