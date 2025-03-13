public class ExamQuestion implements Comparable<ExamQuestion>{
	protected String Nickname;
	protected int Difficulty;

	public ExamQuestion (String Nickname, int Difficulty){
		this.Nickname = Nickname;
		this.Difficulty = Difficulty;

	}

	@Override
	public int compareTo(ExamQuestion otherQuestion) {
		if(this.Difficulty > otherQuestion.Difficulty){
			return 1;
		}
		if( this.Difficulty == otherQuestion.Difficulty){
			return 0;
		}
		return -1;

	}
	@Override
	public String toString(){
		return Nickname + " " + Difficulty;
	}
}

