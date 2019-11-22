package tc2r.springframework.springmvc.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import tc2r.springframework.springmvc.domain.Customer;
import tc2r.springframework.springmvc.services.CustomerService;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class CustomerControllerTest {

  @Mock
  private CustomerService customerService;

  @InjectMocks
  private CustomerController customerController;

  private MockMvc mockMvc;

  @Before
  public void Setup(){

    MockitoAnnotations.initMocks(this);

    mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
  }

  @Test
  public void testList() throws Exception {

    List<Customer> customerList = new ArrayList<>();
    customerList.add(new Customer());
    customerList.add(new Customer());
    customerList.add(new Customer());
    customerList.add(new Customer());

    when(customerService.listAll()).thenReturn((List)customerList);

    mockMvc.perform(get("/customer/list"))
            .andExpect(status().isOk())
            .andExpect(view().name("customer/list"))
            .andExpect(model().attribute("customers", hasSize(4)));
  }

  @Test
  public void testShow() throws Exception {
    Integer id = 1;

    when(customerService.getById(id)).thenReturn(new Customer());

    mockMvc.perform(get("/customer/show/1"))
            .andExpect(status().isOk())
            .andExpect(view().name("customer/show"))
            .andExpect(model().attribute("customer", instanceOf(Customer.class)));
  }

  @Test
  public void testEdit() throws Exception {
    Integer id = 1;

    when(customerService.getById(id)).thenReturn(new Customer());

    mockMvc.perform(get("/customer/edit/1"))
            .andExpect(status().isOk())
            .andExpect(view().name("customer/customerform"))
            .andExpect(model().attribute("customer", instanceOf(Customer.class)));
  }

  @Test
  public void testNewCustomer() throws Exception {
    Integer id = 1;

    verifyNoInteractions(customerService);


    mockMvc.perform(get("/customer/new"))
            .andExpect(status().isOk())
            .andExpect(view().name("customer/customerform"))
            .andExpect(model().attribute("customer", instanceOf(Customer.class)));
  }

  @Test
  public void testDelete() throws Exception {
    Integer id = 1;

    mockMvc.perform(get("/customer/delete/1"))
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/customer/list"));

  }

  @Test
  public void testSaveOrUpdate()throws Exception{

    Integer id = 1;
    String firstName = "Test";
    String lastName = "Unit";
    String addressLineOne = "123 test st.";
    String addressLineTwo = "apt 2Test";
    String city = "Las Test";
    String state = "TT";
    String zipCode = "12345";
    String phoneNumber = "8001234567";
    String email = "test@test.com";

    Customer testCustomer = new Customer();
    testCustomer.setId(id);
    testCustomer.setFirstName(firstName);
    testCustomer.setLastName(lastName);
    testCustomer.setAddressLineOne(addressLineOne);
    testCustomer.setAddressLineTwo(addressLineTwo);
    testCustomer.setCity(city);
    testCustomer.setState(state);
    testCustomer.setZipCode(zipCode);
    testCustomer.setPhoneNumber(phoneNumber);
    testCustomer.setEmail(email);

    when(customerService.saveOrUpdate(isA(Customer.class))).thenReturn(testCustomer);

    mockMvc.perform(post("/customer")
            .param("id", "1")
            .param("firstName", firstName)
            .param("lastName", lastName)
            .param("addressLineOne", addressLineOne)
            .param("addressLineTwo", addressLineTwo)
            .param("city", city)
            .param("state", state)
            .param("zipCode", "12345")
            .param("phoneNumber", "8001234567")
            .param("email", "test@test.com"))
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/customer/show/1"))
            .andExpect(model().attribute("customer", instanceOf(Customer.class)))
            .andExpect(model().attribute("customer", hasProperty("id", is(id))))
            .andExpect(model().attribute("customer", hasProperty("firstName", is(firstName))))
            .andExpect(model().attribute("customer", hasProperty("lastName", is(lastName))))
            .andExpect(model().attribute("customer", hasProperty("addressLineOne", is(addressLineOne))))
            .andExpect(model().attribute("customer", hasProperty("addressLineTwo", is(addressLineTwo))))
            .andExpect(model().attribute("customer", hasProperty("city", is(city))))
            .andExpect(model().attribute("customer", hasProperty("state", is(state))))
            .andExpect(model().attribute("customer", hasProperty("zipCode", is(zipCode))))
            .andExpect(model().attribute("customer", hasProperty("phoneNumber", is(phoneNumber))))
            .andExpect(model().attribute("customer", hasProperty("email", is(email))));

    // Verify properties of bound object.

    ArgumentCaptor<Customer> boundCustomer = ArgumentCaptor.forClass(Customer.class);
    verify(customerService).saveOrUpdate(boundCustomer.capture());

    assertEquals(id, boundCustomer.getValue().getId());
    assertEquals(firstName, boundCustomer.getValue().getFirstName());
    assertEquals(lastName, boundCustomer.getValue().getLastName());
    assertEquals(addressLineOne, boundCustomer.getValue().getAddressLineOne());
    assertEquals(addressLineTwo, boundCustomer.getValue().getAddressLineTwo());
    assertEquals(city, boundCustomer.getValue().getCity());
    assertEquals(state, boundCustomer.getValue().getState());
    assertEquals(zipCode, boundCustomer.getValue().getZipCode());
    assertEquals(phoneNumber, boundCustomer.getValue().getPhoneNumber());
    assertEquals(email, boundCustomer.getValue().getEmail());
  }

}
