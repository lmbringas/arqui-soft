package ar.edu.ucc.arqsoft.test.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponseDto {

	@JsonProperty("codigo")
	private String code;

	@JsonProperty("estado")
	private String status;

	@JsonProperty("autorizacion")
	private String auth;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}
	
}
