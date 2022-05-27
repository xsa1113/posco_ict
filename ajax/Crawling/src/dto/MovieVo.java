package dto;

public class MovieVo {
	
	private String title;
	private double percent;
	
	public MovieVo() {

    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	public MovieVo(String title, double percent) {
		super();
		this.title = title;
		this.percent = percent;
	}

	@Override
	public String toString() {
		return "MovieVo [title=" + title + ", percent=" + percent + "]";
	}
	
	

}
