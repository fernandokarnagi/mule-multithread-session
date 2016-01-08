package asia.omron.bean;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SessionBean implements Serializable {

	private static final long serialVersionUID = 2865634233350041610L;
	private Map fields = new ConcurrentHashMap();
	private int totalSuccess = 0;
	private int totalFailed = 0;
	private int totalRecords = 0;
	private int totalOriginalRecords = 0;

	public void incrementSuccess() {
		totalSuccess++;
	}

	public void incrementFailed() {
		totalFailed++;
	}

	public void incrementRecords() {
		totalRecords++;
	}

	public void printTotal() {
		System.out.println("totalSuccess: " + totalSuccess + ", totalFailed: "
				+ totalFailed + ", totalRecords: " + totalRecords);
	}

	public SessionBean() {
		System.out.println("SessionBean is created [" + hashCode() + "]");
	}

	public Map getFields() {
		return fields;
	}

	public void setFields(Map fields) {
		this.fields = fields;
	}

	public int getTotalOriginalRecords() {
		return totalOriginalRecords;
	}

	public void setTotalOriginalRecords(int totalOriginalRecords) {
		this.totalOriginalRecords = totalOriginalRecords;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getTotalSuccess() {
		return totalSuccess;
	}

	public int getTotalFailed() {
		return totalFailed;
	}

	public int getTotalRecords() {
		return totalRecords;
	}
	
	
}
