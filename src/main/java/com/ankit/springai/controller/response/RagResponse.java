package com.ankit.springai.controller.response;

public class RagResponse {
  private String query;

  private String answer;

  public RagResponse() {
    super();

  }

  public RagResponse(String query, String answer) {
    super();
    this.query = query;
    this.answer = answer;
  }

  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }

  public String getAnswer() {
    return answer;
  }

  public void setAnswer(String answer) {
    this.answer = answer;
  }
}
