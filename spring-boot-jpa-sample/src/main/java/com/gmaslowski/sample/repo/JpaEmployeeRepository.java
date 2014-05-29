package com.gmaslowski.sample.repo;

import com.gmaslowski.sample.entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface JpaEmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
}
