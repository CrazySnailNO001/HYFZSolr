package com.jc519.search.config;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;

@Configuration
@EnableSolrRepositories(basePackages = { "com.jc519.search" }, multicoreSupport = true)
public class SolrConfig {

	@Value("${spring.data.solr.host}")
	private String SOLR_HOST;
	
	@Bean
	public SolrClient solrClient() {
		return new HttpSolrClient(SOLR_HOST);
	}

/*	@Bean
	public SolrTemplate solrTemplate() throws Exception {
		SolrTemplate solrTemplate =  new SolrTemplate(solrClient());
		return solrTemplate;
	}*/

}
