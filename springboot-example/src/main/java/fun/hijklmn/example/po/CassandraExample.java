package fun.hijklmn.example.po;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("example")
public class CassandraExample {

	@PrimaryKey("example_id")
	private Long exampleId;
	
	@Column("name")
	private String name;
	
	@Column("content")
	private String content;
	
	@Column("noncestr")
	private String nonceStr;
	
	@Column("timestamp")
	private String timeStamp;

	public CassandraExample() {
		super();
	}

	public CassandraExample(Long exampleId, String name, String content, String nonceStr, String timeStamp) {
		super();
		this.exampleId = exampleId;
		this.name = name;
		this.content = content;
		this.nonceStr = nonceStr;
		this.timeStamp = timeStamp;
	}

	public Long getExampleId() {
		return exampleId;
	}

	public void setExampleId(Long exampleId) {
		this.exampleId = exampleId;
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
		return "CassandraExample [exampleId=" + exampleId + ", name=" + name + ", content=" + content + ", nonceStr="
				+ nonceStr + ", timeStamp=" + timeStamp + "]";
	}
	
}
