package MongoDB.boletin2.modelo;

public class Scores {
	private String type;
	private double score;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public Scores(String type, double score) {
		super();
		this.type = type;
		this.score = score;
	}
	public Scores() {
		super();
	}
	@Override
	public String toString() {
		return "Scores [type=" + type + ", score=" + score + "]";
	}
	
	
}
