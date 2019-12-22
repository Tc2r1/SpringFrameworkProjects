package tc2r.springframework.springmvc.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tc2r.springframework.springmvc.domain.DomainObject;

public abstract class AbstractMapService
{

  protected Map<Integer, DomainObject> domainMap;

  public AbstractMapService()
  {
    domainMap = new HashMap<>();
  }

  public List<DomainObject> listAll()
  {

    return new ArrayList<>(domainMap.values());
  }

  public DomainObject getById(Integer id)
  {

    return domainMap.get(id);
  }


  public DomainObject saveOrUpdate(DomainObject domainObject)
  {

    if (domainObject != null)
    {
      if (domainObject.getId() == null)
      {
        domainObject.setId(getNextKey());
      }
      domainMap.put(domainObject.getId(), domainObject);
      return domainObject;
    } else
    {
      throw new RuntimeException("Object Can't Be Null");
    }
  }

  public void delete(Integer id)
  {

    domainMap.remove(id);
  }

  private Integer getNextKey()
  {

    if (domainMap.size() == 0)
    {
      return 1;
    }
    return Collections.max(domainMap.keySet()) + 1;
  }

}
