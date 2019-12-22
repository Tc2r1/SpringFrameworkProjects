package tc2r.springframework.springmvc.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import tc2r.springframework.springmvc.domain.Customer;

@Service
@Profile("jpadao")
public class CustomerServiceJpaDaoImpl implements CustomerService
{

  private EntityManagerFactory emf;

  @PersistenceUnit
  public void setEmf(EntityManagerFactory emf)
  {

    this.emf = emf;
  }

  @Override
  public List<Customer> listAll()
  {

    EntityManager em = emf.createEntityManager();
    List<Customer> customerList = em.createQuery("from Customer", Customer.class).getResultList();
    em.close();
    return customerList;
  }

  @Override
  public Customer getById(Integer id)
  {

    EntityManager em = emf.createEntityManager();
    Customer savedCustomer = em.find(Customer.class, id);
    em.close();
    return savedCustomer;
  }

  @Override
  public Customer saveOrUpdate(Customer domainObject)
  {

    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    Customer savedCustomer = em.merge(domainObject);
    em.getTransaction().commit();
    return savedCustomer;
  }

  @Override
  public void delete(Integer id)
  {

    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
    em.remove(em.find(Customer.class, id));
    em.getTransaction().commit();
    em.close();
  }
}
