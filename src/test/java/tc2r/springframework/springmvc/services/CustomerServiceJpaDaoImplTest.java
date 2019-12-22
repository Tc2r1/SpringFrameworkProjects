package tc2r.springframework.springmvc.services;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import tc2r.springframework.springmvc.config.JpaIntegrationConfig;
import tc2r.springframework.springmvc.domain.Customer;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = JpaIntegrationConfig.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("jpadao")
public class CustomerServiceJpaDaoImplTest
{

  private CustomerService customerService;

  @Autowired
  public void setCustomerService(CustomerService customerService)
  {

    this.customerService = customerService;
  }


  @Test
  public void testListMethod() throws Exception
  {

    List<Customer> customers = (List<Customer>) customerService.listAll();

    assert customers.size() == 3;

  }

  @Test
  public void testGetByIdMethod() throws Exception{
    Integer testId = 6;
    Customer testCustomer = customerService.getById(testId);
    assert testCustomer.getId() == 6;
  }

  @Test
  public void testDeleteMethod() throws Exception
  {

    Integer id = 6;

    Customer testCustomer = customerService.getById(id);
    customerService.delete(id);

    assert customerService.getById(id) == null;
  }
}
