package DemoSpringMVC.Entity;

public class Slides { 
	private int id; 
	private String content; 
	private String img; 
	private String caption;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	public Slides() {
		super();
	}
	public Slides(int id, String content, String img, String caption) {
		super();
		this.id = id;
		this.content = content;
		this.img = img;
		this.caption = caption;
	} 
	 
	
	

}
