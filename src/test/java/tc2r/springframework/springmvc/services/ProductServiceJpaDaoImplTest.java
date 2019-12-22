package tc2r.springframework.springmvc.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import tc2r.springframework.springmvc.config.JpaIntegrationConfig;
import tc2r.springframework.springmvc.domain.Product;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = JpaIntegrationConfig.class)
@ActiveProfiles("jpadao")
public class ProductServiceJpaDaoImplTest
{

  private ProductService productService;

  @Autowired
  public void setProductService(ProductService productService)
  {

    this.productService = productService;
  }

  @Test
  public void testListMethod() throws Exception
  {

    List<Product> products = (List<Product>) productService.listAll();

    System.out.println("Product Size: " + products.size());

    assert products.size() == 5;
  }

  @Test
  public void testGetByIdMethod() throws Exception
  {

    Integer testId = 1;

    Product testProduct = productService.getById(testId);

    assert testProduct.getId() == 1;
  }

  @Test
  public void testDeleteMethod() throws Exception
  {

    Integer id = 1;

    Product testProduct = productService.getById(id);
    productService.delete(id);

    assert productService.getById(id) == null;
  }
}
