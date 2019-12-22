package tc2r.springframework.springmvc.bootstrap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import tc2r.springframework.springmvc.domain.Customer;
import tc2r.springframework.springmvc.domain.Product;
import tc2r.springframework.springmvc.services.CustomerService;
import tc2r.springframework.springmvc.services.ProductService;

@Component
public class SpringJPABootstrap implements ApplicationListener<ContextRefreshedEvent>
{

  private ProductService productService;
  private CustomerService customerService;

  @Autowired
  public void setProductService(ProductService productService)
  {

    this.productService = productService;
  }

  @Autowired
  public void setCustomerService(CustomerService customerService)
  {

    this.customerService = customerService;
  }

  @Override
  public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent)
  {

    loadProducts();
    loadCustomers();
  }

  public void loadCustomers()
  {
    Customer customer1 = new Customer();
    customer1.setFirstName("John");
    customer1.setLastName("Smith");
    customer1.setAddressLineOne("somewhere street");
    customer1.setAddressLineTwo("apt 2");
    customer1.setCity("Chicago");
    customer1.setState("IL");
    customer1.setZipCode("60626");
    customer1.setPhoneNumber("31211111111");
    customer1.setEmail("JohnSmith@gmail.com");

    customerService.saveOrUpdate(customer1);

    Customer customer2 = new Customer();
    customer2.setFirstName("Sarah");
    customer2.setLastName("Times");
    customer2.setAddressLineOne("neverland ave");
    customer2.setAddressLineTwo("clock tower");
    customer2.setCity("pittsburg");
    customer2.setState("New England");
    customer2.setZipCode("78944");
    customer2.setPhoneNumber("4812222222");
    customer2.setEmail("SarahTimes@gmail.com");

    customerService.saveOrUpdate(customer2);

    Customer customer3 = new Customer();
    customer3.setFirstName("Berry");
    customer3.setLastName("Allen");
    customer3.setAddressLineOne("Fast st.");
    customer3.setAddressLineTwo("Apt 1s");
    customer3.setCity("Zoomcity");
    customer3.setState("NY");
    customer3.setZipCode("97596");
    customer3.setPhoneNumber("8073333333");
    customer3.setEmail("TheFlash@gmail.com");

    customerService.saveOrUpdate(customer3);
  }


  public void loadProducts()
  {

    Product product1 = new Product();
    product1.setDescription("Product 1");
    product1.setPrice(new BigDecimal("12.99"));
    product1.setImageUrl("http://example.com/product1");
    productService.saveOrUpdate(product1);

    Product product2 = new Product();
    product2.setDescription("Product 2");
    product2.setPrice(new BigDecimal("14.99"));
    product2.setImageUrl("http://example.com/product2");
    productService.saveOrUpdate(product2);

    Product product3 = new Product();
    product3.setDescription("Product 3");
    product3.setPrice(new BigDecimal("34.99"));
    product3.setImageUrl("http://example.com/product3");
    productService.saveOrUpdate(product3);

    Product product4 = new Product();
    product4.setDescription("Product 4");
    product4.setPrice(new BigDecimal("44.99"));
    product4.setImageUrl("http://example.com/product4");
    productService.saveOrUpdate(product4);

    Product product5 = new Product();
    product5.setDescription("Product 5");
    product5.setPrice(new BigDecimal("25.99"));
    product5.setImageUrl("http://example.com/product5");
    productService.saveOrUpdate(product5);
  }
}
