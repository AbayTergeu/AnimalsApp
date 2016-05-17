package com.abter.springmvc.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.abter.springmvc.jsonview.Views;

import java.util.List;

public class AjaxResponseBody {

	@JsonView(Views.Public.class)
	String msg;
	@JsonView(Views.Public.class)
	String code;
	@JsonView(Views.Public.class)
	Person result;

	@JsonView(Views.Public.class)
	Animals resultAnimal;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Person getResult() {
		return result;
	}

	public void setResult(Person result) {
		this.result = result;
	}

	public Animals getResultAnimal() {
		return resultAnimal;
	}

	public void setResultAnimal(Animals resultAnimal) {
		this.resultAnimal = resultAnimal;
	}

	@Override
	public String toString() {
		return "AjaxResponseResult [msg=" + msg + ", code=" + code + ", result=" + result + ", resultAnimal="+resultAnimal+"]";
	}

}
