package tc2r.springframework.springmvc.services;


import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

import tc2r.springframework.springmvc.domain.Customer;
import tc2r.springframework.springmvc.domain.DomainObject;

@Service
@Profile("map")
public class CustomerServiceImpl extends AbstractMapService implements CustomerService
{

  @Override
  public List<DomainObject> listAll()
  {

    return super.listAll();
  }

  @Override
  public Customer getById(Integer id)
  {

    return (Customer) super.getById(id);
  }

  @Override
  public Customer saveOrUpdate(Customer domainObject)
  {

    return (Customer) super.saveOrUpdate(domainObject);
  }

  @Override
  public void delete(Integer id)
  {

    super.delete(id);
  }

}
