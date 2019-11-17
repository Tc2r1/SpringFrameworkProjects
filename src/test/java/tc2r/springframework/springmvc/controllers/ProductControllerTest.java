package tc2r.springframework.springmvc.controllers;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import tc2r.springframework.springmvc.domain.Product;
import tc2r.springframework.springmvc.services.ProductService;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
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

public class ProductControllerTest{

  @Mock // Mockito Mock Object{
  private ProductService productService;

  @InjectMocks // Setup controller and injects mock objects into it.
  private ProductController productController;

  private MockMvc mockMvc;

  @Before
  public void setup(){
    MockitoAnnotations.initMocks(this); // Initializes controller and mocks

    mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
  }

  @Test
  public void testList() throws Exception{

    List<Product> productList = new ArrayList<>();
    productList.add(new Product());
    productList.add(new Product());
    productList.add(new Product());

    // specific Mockito interaction, tell stub to return list of Products.
    when(productService.listAll()).thenReturn((List) productList); // need to strip generics to keep Mockito happy.

    mockMvc.perform(get("/product/list"))
            .andExpect(status().isOk())
            .andExpect(view().name("product/list"))
            .andExpect(model().attribute("products", hasSize(3)));
  }

  @Test
  public void testShow() throws Exception {
    Integer id = 1;

    // Tell Mockito stub to return new product for id 1
    when(productService.getById(id)).thenReturn(new Product());

    mockMvc.perform(get("/product/show/1"))
            .andExpect(status().isOk())
            .andExpect(view().name("product/show"))
            .andExpect(model().attribute("product", instanceOf(Product.class)));
  }

  @Test
  public void testEdit() throws Exception {

    Integer id = 1;


    // Tell Mockito stub to return new product for ID 1
    when(productService.getById(id)).thenReturn(new Product());

    mockMvc.perform(get("/product/edit/1"))
            .andExpect(status().isOk())
            .andExpect(view().name("product/productform"))
            .andExpect(model().attribute("product", instanceOf(Product.class)));
  }

  @Test
  public void testNewProduct() throws Exception {
    Integer id = 1;

    // Should not call service
    verifyNoInteractions(productService);

    mockMvc.perform(get("/product/new"))
            .andExpect(status().isOk())
            .andExpect(view().name("product/productform"))
            .andExpect(model().attribute("product", instanceOf(Product.class)));
  }

  @Test
  public void testDelete() throws Exception {
    Integer id = 1;

    mockMvc.perform(get("/product/delete/1"))
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/product/list"));
  }

  @Test
  public void testSaveOrUpdate() throws Exception {
    Integer id = 1;
    String description = "Test Description goes here";
    BigDecimal price = new BigDecimal("9.99");
    String imageUrl = "TestURL.COM";

    Product testProduct = new Product();
    testProduct.setId(id);
    testProduct.setDescription(description);
    testProduct.setPrice(price);
    testProduct.setImageUrl(imageUrl);
    testProduct.setImageUrl(imageUrl);

    when(productService.saveOrUpdate(isA(Product.class))).thenReturn(testProduct);

    mockMvc.perform(post("/product")
            .param("id", "1")
            .param("description", description)
            .param("price", "9.99")
            .param("imageUrl", "TestURL.COM"))
            .andExpect(status().is3xxRedirection())
            .andExpect(view().name("redirect:/product/show/1"))
            .andExpect(model().attribute("product", instanceOf(Product.class)))
            .andExpect(model().attribute("product", Matchers.hasProperty("id", is(id))))
            .andExpect(model().attribute("product", Matchers.hasProperty("description", is(description))))
            .andExpect(model().attribute("product", Matchers.hasProperty("price", is(price))))
            .andExpect(model().attribute("product", Matchers.hasProperty("imageUrl", is(imageUrl))));

    // Verify properties of bound Object
    ArgumentCaptor<Product> boundProduct = ArgumentCaptor.forClass(Product.class);
    verify(productService).saveOrUpdate(boundProduct.capture());

    assertEquals(id, boundProduct.getValue().getId());
    assertEquals(description, boundProduct.getValue().getDescription());
    assertEquals(price, boundProduct.getValue().getPrice());
    assertEquals(imageUrl, boundProduct.getValue().getImageUrl());

  }



}
