package com.sprint.otms.models;

import java.io.Serializable;



public class JwtResponse implements Serializable {

 

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private Long id;
    

 

    public JwtResponse(String jwttoken,Long id) {
        this.jwttoken = jwttoken;
        this.id=id;
    }

 

    public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getToken() {
        return this.jwttoken;
    }
}