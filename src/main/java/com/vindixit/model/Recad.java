package com.vindixit.model;

public class Recad {
	private String id;
	private String content;

	public String getId() {
		// https://docs.google.com/spreadsheets/d/1SAi1_8aEkZJja0tgNAscyN4dhOxJuoV9fLmRXNGlMb4/edit#gid=1645154011
		if(null != id && id.startsWith("http")){
			id = id.substring(id.indexOf("/d/")+3, id.lastIndexOf("/"));
		}
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
