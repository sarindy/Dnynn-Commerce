package com.dnynn.test;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestModelRepository extends CrudRepository<TestModel, Integer> {

}
