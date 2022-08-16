package com.skopos.SkoposAPI.dto;

import javax.validation.constraints.NotBlank;

public class FeedbackDto {
	@NotBlank
	String feedback;

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
}
