package com.nitron.ollamaEmbeddingService;

import org.apache.http.HttpHost;
import org.opensearch.client.json.jackson.JacksonJsonpMapper;
import org.opensearch.client.opensearch.OpenSearchClient;
import org.opensearch.client.transport.rest_client.RestClientTransport;
import org.opensearch.client.RestClient;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.embedding.TokenCountBatchingStrategy;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.ai.vectorstore.opensearch.OpenSearchVectorStore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.URISyntaxException;

@SpringBootApplication
@Configuration
public class OllamaEmbeddingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OllamaEmbeddingServiceApplication.class, args);
	}
/*	@Bean
	public OpenSearchClient openSearchClient() throws URISyntaxException {
		RestClient restClient = RestClient.builder(HttpHost.create("http://localhost:9200"))
				.build();

		return new OpenSearchClient(new RestClientTransport(
				restClient, new JacksonJsonpMapper()));
	}
	@Bean
	public VectorStore vectorStore(OpenSearchClient openSearchClient, EmbeddingModel embeddingModel) {
		return OpenSearchVectorStore.builder(openSearchClient, embeddingModel)
				.index("custom-index")                // Optional: defaults to "spring-ai-document-index"
				.similarityFunction("l2")             // Optional: defaults to "cosinesimil"
				.initializeSchema(true)               // Optional: defaults to false
				.batchingStrategy(new TokenCountBatchingStrategy()) // Optional: defaults to TokenCountBatchingStrategy
				.build();
	}*/


}
