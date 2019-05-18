package fun.hijklmn.example.po;

import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument
public class SolrExample {

	private Long exampleId;
	
	private String name;
	
	private String content;
	
	private String nonceStr;
	
	private String timeStamp;

	public SolrExample(Long exampleId, String name, String content, String nonceStr, String timeStamp) {
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
		return "SolrExample [exampleId=" + exampleId + ", name=" + name + ", content=" + content + ", nonceStr="
				+ nonceStr + ", timeStamp=" + timeStamp + "]";
	}

}
