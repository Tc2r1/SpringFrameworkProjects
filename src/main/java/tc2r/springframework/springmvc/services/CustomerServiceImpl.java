package tc2r.springframework.springmvc.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

import tc2r.springframework.springmvc.domain.Customer;
import tc2r.springframework.springmvc.domain.DomainObject;

@Service
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {

  @Override
  public List<DomainObject> listAll() {
    return super.listAll();
  }

  @Override
  public Customer getById(Integer id) {
    return (Customer) super.getById(id);
  }

  @Override
  public Customer saveOrUpdate(Customer domainObject) {
    return (Customer) super.saveOrUpdate(domainObject);
  }

  @Override
  public void delete(Integer id) {
    super.delete(id);
  }

  @Override
  protected void loadDomainObjects() {
    domainMap = new HashMap<>();

    Customer customer1 = new Customer();
    customer1.setId(1);
    customer1.setFirstName("John");
    customer1.setLastName("Smith");
    customer1.setAddressLineOne("somewhere street");
    customer1.setAddressLineTwo("apt 2");
    customer1.setCity("Chicago");
    customer1.setState("IL");
    customer1.setZipCode("60626");
    customer1.setPhoneNumber("31211111111");
    customer1.setEmail("JohnSmith@gmail.com");

    domainMap.put(1, customer1);

    Customer customer2 = new Customer();
    customer2.setId(2);
    customer2.setFirstName("Sarah");
    customer2.setLastName("Times");
    customer2.setAddressLineOne("neverland ave");
    customer2.setAddressLineTwo("clock tower");
    customer2.setCity("pittsburg");
    customer2.setState("New England");
    customer2.setZipCode("78944");
    customer2.setPhoneNumber("4812222222");
    customer2.setEmail("SarahTimes@gmail.com");

    domainMap.put(2, customer2);

    Customer customer3 = new Customer();
    customer3.setId(3);
    customer3.setFirstName("Berry");
    customer3.setLastName("Allen");
    customer3.setAddressLineOne("Fast st.");
    customer3.setAddressLineTwo("Apt 1s");
    customer3.setCity("Zoomcity");
    customer3.setState("NY");
    customer3.setZipCode("97596");
    customer3.setPhoneNumber("8073333333");
    customer3.setEmail("TheFlash@gmail.com");

    domainMap.put(3, customer3);
  }
}
