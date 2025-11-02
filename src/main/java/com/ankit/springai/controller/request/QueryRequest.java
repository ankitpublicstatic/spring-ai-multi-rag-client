package com.ankit.springai.controller.request;

public class QueryRequest {
  private String query;

  public QueryRequest() {
    super();
  }


  public QueryRequest(String query) {
    super();
    this.query = query;
  }

  public String getQuery() {
    return query;
  }

  public void setQuery(String query) {
    this.query = query;
  }
}
