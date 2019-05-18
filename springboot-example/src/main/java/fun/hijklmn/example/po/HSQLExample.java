package fun.hijklmn.example.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class HSQLExample {

	@Id 
	@GeneratedValue
	private Long id;
	
	private String name;
	
	private String content;
	
	private String nonceStr;
	
	private String timeStamp;

	public HSQLExample() {
		super();
	}

	public HSQLExample(Long id, String name, String content, String nonceStr, String timeStamp) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.nonceStr = nonceStr;
		this.timeStamp = timeStamp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getNonceStr() {
		return nonceStr;
	}

	public void setNonceStr(String nonceStr) {
		this.nonceStr = nonceStr;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	@Override
	public String toString() {
		return "HSQLExample [id=" + id + ", name=" + name + ", content=" + content + ", nonceStr=" + nonceStr
				+ ", timeStamp=" + timeStamp + "]";
	}
	
}
