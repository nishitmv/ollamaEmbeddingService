package com.nitron.ollamaEmbeddingService.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryRequest {
    String query;

    public String getQuery() {
        return query;
    }

}
