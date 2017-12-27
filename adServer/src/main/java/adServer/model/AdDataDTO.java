package adServer.model;

import java.util.Date;

public class AdDataDTO {
	
	private String partnerId;
	private Integer durationInSeconds;
	private String dispalyContent;
	private String error;
	private Date expiryDate;
	private String formattedExpirtyDate;
	
	
	

	
	public String getFormattedExpirtyDate() {
		return formattedExpirtyDate;
	}
	public void setFormattedExpirtyDate(String formattedExpirtyDate) {
		this.formattedExpirtyDate = formattedExpirtyDate;
	}
	public Date getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}
	
	public Integer getDurationInSeconds() {
		return durationInSeconds;
	}
	public void setDurationInSeconds(Integer durationInSeconds) {
		this.durationInSeconds = durationInSeconds;
	}
	public String getDispalyContent() {
		return dispalyContent;
	}
	public void setDispalyContent(String dispalyContent) {
		this.dispalyContent = dispalyContent;
	}

	
	
	

}
