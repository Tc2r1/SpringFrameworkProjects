package tc2r.springframework.springmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tc2r.springframework.springmvc.domain.Customer;
import tc2r.springframework.springmvc.services.CustomerService;

@Controller
public class CustomerController {
  private CustomerService customerService;

  @Autowired
  public void setCustomerService(CustomerService customerService) {
    this.customerService = customerService;
  }

  @RequestMapping("/customer/list")
  public String listCustomers(Model model){
    model.addAttribute("customers", customerService.listAll());
    return "customer/list";
  }

  @RequestMapping("/customer/show/{id}")
  public String getCustomer(@PathVariable Integer id, Model model){

    model.addAttribute("customer", customerService.getById(id));

    return "customer/show";
  }

  @RequestMapping("/customer/new")
  public String newCustomer(Model model){
    model.addAttribute("customer", new Customer());
    return "customer/customerform";
  }

  @RequestMapping("/customer/edit/{id}")
  public String editCustomer(@PathVariable Integer id, Model model){
    model.addAttribute("customer", customerService.getById(id));
    return "customer/customerform";
  }

  @RequestMapping(value = "/customer", method = RequestMethod.POST)
  public String saveOrUpdateCustomer(Customer customer){
    Customer savedCustomer = customerService.saveOrUpdate(customer);
    return "redirect:/customer/show/" + savedCustomer.getId();
  }

  @RequestMapping("/customer/delete/{id}")
  public String deleteCustomer(@PathVariable Integer id){
    customerService.delete(id);
    return "redirect:/customer/list";

  }
}
