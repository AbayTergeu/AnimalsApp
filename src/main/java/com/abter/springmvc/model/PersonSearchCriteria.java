package com.abter.springmvc.model;

public class PersonSearchCriteria {

	String username;
	String password;
	String passwConf;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getPasswConf() {
		return passwConf;
	}

	public void setPasswConf(String passwConf) {
		this.passwConf = passwConf;
	}

	@Override
	public String toString() {
		return "PersonSearchCriteria [username=" + username + ", password=" + password + "]";
	}

}
