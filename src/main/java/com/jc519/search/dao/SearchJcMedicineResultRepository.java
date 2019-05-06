package com.jc519.search.dao;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.jc519.search.model.SearchJcMedicine;

public interface SearchJcMedicineResultRepository extends SolrCrudRepository<SearchJcMedicine, Integer>{

	List<SearchJcMedicine> findByGenericName(String name);

	Iterable<SearchJcMedicine> findAll(Sort sort);

}
