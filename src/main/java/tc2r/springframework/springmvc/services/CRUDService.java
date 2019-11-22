package tc2r.springframework.springmvc.services;

import java.util.List;

import tc2r.springframework.springmvc.domain.Customer;

public interface CRUDService<T> {
  List<?> listAll();

  T getById(Integer id);

  T saveOrUpdate( T domainObject);

  void delete(Integer id);
}
