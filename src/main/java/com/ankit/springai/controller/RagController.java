package com.ankit.springai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ankit.springai.controller.request.QueryRequest;
import com.ankit.springai.controller.response.RagResponse;
import com.ankit.springai.controller.service.RagService;

@RestController
@RequestMapping("/api/rag")
public class RagController {

  @Autowired
  private RagService ragService;

  public RagResponse getAnswer(@RequestBody QueryRequest queryRequest) {
    return ragService.queryRag(queryRequest.getQuery());

  }
}
