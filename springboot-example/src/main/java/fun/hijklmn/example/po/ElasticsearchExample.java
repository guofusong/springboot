package fun.hijklmn.example.po;

import javax.persistence.Id;

// @Document(indexName = "example", type = "elasticsearch")
public class ElasticsearchExample {

	@Id
	private Long id;
	
	private String name;
	
	private String content;
	
	private String nonceStr;
	
	private String timestamp;
	
	private String description;

	public ElasticsearchExample(Long id, String name, String content, String nonceStr, String timestamp,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.nonceStr = nonceStr;
		this.timestamp = timestamp;
		this.description = description;
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

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ElasticsearchExample [id=" + id + ", name=" + name + ", content=" + content + ", nonceStr=" + nonceStr
				+ ", timestamp=" + timestamp + ", description=" + description + "]";
	}
	
}
