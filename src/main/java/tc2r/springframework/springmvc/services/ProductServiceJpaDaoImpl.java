package tc2r.springframework.springmvc.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import tc2r.springframework.springmvc.domain.Product;

@Service
@Profile("jpadao")
public class ProductServiceJpaDaoImpl implements ProductService
{

  private EntityManagerFactory emf;

  @PersistenceUnit
  public void setEmf(EntityManagerFactory emf)
  {

    this.emf = emf;
  }

  @Override
  public List<Product> listAll()
  {

    EntityManager em = emf.createEntityManager();
    List<Product> productList = em.createQuery("from Product", Product.class).getResultList();
    em.close();
    return productList;

  }

  @Override
  public Product getById(Integer id)
  {

    EntityManager em = emf.createEntityManager();
    Product savedProduct = em.find(Product.class, id);
    em.close();
    return savedProduct;
  }

  @Override
  public Product saveOrUpdate(Product domainObject)
  {

    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    Product savedProduct = em.merge(domainObject);
    em.getTransaction().commit();
    em.close();
    return savedProduct;
  }

  @Override
  public void delete(Integer id)
  {

    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    em.remove(em.find(Product.class, id));
    em.getTransaction().commit();
    em.close();
  }
}