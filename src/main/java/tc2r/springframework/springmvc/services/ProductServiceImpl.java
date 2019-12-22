package tc2r.springframework.springmvc.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

import tc2r.springframework.springmvc.domain.DomainObject;
import tc2r.springframework.springmvc.domain.Product;

@Profile("map")
@Service
public class ProductServiceImpl extends AbstractMapService implements ProductService
{

  @Override
  public List<DomainObject> listAll()
  {

    return super.listAll();
  }

  @Override
  public Product getById(Integer id)
  {

    return (Product) super.getById(id);
  }

  @Override
  public Product saveOrUpdate(Product domainObject)
  {

    return (Product) super.saveOrUpdate(domainObject);
  }

  @Override
  public void delete(Integer id)
  {

    super.delete(id);
  }

}
