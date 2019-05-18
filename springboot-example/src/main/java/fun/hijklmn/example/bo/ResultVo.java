package fun.hijklmn.example.bo;

import java.util.ArrayList;
import java.util.List;

public class ResultVo {

	private Integer code = 1;
	
	private String message = "success";
	
	private Object result;
	
	private List<Object> items = new ArrayList<>();

	public void setCustomerReason(Integer code, String message) {
		setCode(code == null ? -1 : code);
		setMessage(message);
	}
	
	public void setSysErr() {
		this.code = -1;
		this.message = "error";
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public List<Object> getItems() {
		return items;
	}

	public void setItems(List<Object> items) {
		this.items = items;
	}
	
}
