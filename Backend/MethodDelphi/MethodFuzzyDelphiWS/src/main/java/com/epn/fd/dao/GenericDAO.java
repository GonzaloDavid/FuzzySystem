package com.epn.fd.dao;

import com.epn.dtos.ListAndCountContainer;
import static com.epn.entities.FilterTypes.EQUAL;
import static com.epn.entities.FilterTypes.LIKE;
import static com.epn.entities.FilterTypes.LIKE_LEFT;
import static com.epn.entities.FilterTypes.LIKE_RIGHT;
import com.epn.entities.OrderByProperty;
import com.epn.entities.Property;
import com.epn.entities.SearchObject;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.lang3.tuple.MutablePair;



public class GenericDAO<T> {

    @PersistenceContext(unitName = "com.epn.fuzzydelphi_MethodFuzzyDelphiWS_war_1.0PU")
    protected EntityManager em;

    private Class<T> instance;

    public GenericDAO(Class<T> instance) {
        this.instance = instance;
    }

    public void insert(T instance) {
        em.persist(instance);
        em.flush();
    }

    public void insertList(List<T> instanceList) {
        instanceList.forEach(item -> {
            em.persist(item);
        });
        em.flush();
    }

    public void remove(T instance) {
        em.remove(em.merge(instance));
        em.flush();
    }

    public void update(T instance) {
        em.merge(instance);
        em.flush();
    }

    public void updateList(List<T> instanceList) {
        instanceList.forEach(item -> {
            em.merge(item);
        });
        em.flush();
    }

    public void deleteList(List<T> instanceList) {
        instanceList.forEach(item -> {
            em.remove(em.merge(item));
        });
        em.flush();
    }

    public void flush() {
        em.flush();
    }


    //TODO: development
    public List<T> searchAndJoin(SearchObject searchObject, Class<?> cls){
        //Se crea una consulta base
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<T> cq = cb.createQuery(instance);
        //FROM - Entidad
        Root<?> providerRoot = cq.from(cls);
        Root<T> rotRoot = cq.from(instance);
        Join< ? , T  > join = providerRoot.join("persons");
        cq.select(join);

        CriteriaQuery q = filter(cq, cb, rotRoot, searchObject);

        

        //Se obtiene el resultado de la consulta con paginado
        List resultList;
        if (searchObject.getFrom() != null && searchObject.getTo() != null) {
            resultList = findByRange(q, searchObject.getFrom(), searchObject.getTo());
        } else {
            resultList = findAll(q);
        }
        return resultList;
        

    }

    public List<T> search(SearchObject searchObject) {

        //Se crea una consulta base
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(instance);
        //FROM - Entidad
        Root providerRoot = cq.from(instance);
        cq.select(providerRoot);

        CriteriaQuery q = filter(cq, cb, providerRoot, searchObject);
        //Se obtiene el resultado de la consulta con paginado
        List resultList;
        if (searchObject.getFrom() != null && searchObject.getTo() != null) {
            resultList = findByRange(q, searchObject.getFrom(), searchObject.getTo());
        } else {
            resultList = findAll(q);
        }

        // Long count = count(providerRoot, cq);

        //Se devuelven los resultados
        return resultList;

    }


    public ListAndCountContainer searchAndCount(SearchObject searchObject) {

        //Se crea una consulta base
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(instance);
        //FROM - Entidad
        Root providerRoot = cq.from(instance);
        cq.select(providerRoot);

        CriteriaQuery q = filter(cq, cb, providerRoot, searchObject);
        //Se obtiene el resultado de la consulta con paginado
        List<T> resultList;
        if (searchObject.getFrom() != null && searchObject.getTo() != null) {
            resultList = findByRange(q, searchObject.getFrom(), searchObject.getTo());
        } else {
            resultList = findAll(q);
        }

        Long count = count(providerRoot, q);

        ListAndCountContainer result = new ListAndCountContainer(count, resultList);

        //Se retorna el count y la lista
        return result;

    }

    public MutablePair<Long, List<T>> searchAndCountPair(SearchObject searchObject) {

        //Se crea una consulta base
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(instance);
        //FROM - Entidad
        Root providerRoot = cq.from(instance);
        cq.select(providerRoot);

        CriteriaQuery q = filter(cq, cb, providerRoot, searchObject);
        //Se obtiene el resultado de la consulta con paginado
        List<T> resultList;
        if (searchObject.getFrom() != null && searchObject.getTo() != null) {
            resultList = findByRange(q, searchObject.getFrom(), searchObject.getTo());
        } else {
            resultList = findAll(q);
        }

        Long count = count(providerRoot, q);

        //Se retorna el count y la lista
        return new MutablePair(count, resultList);

    }

    private CriteriaQuery filter(CriteriaQuery<T> cq, CriteriaBuilder cb, Root providerRoot,
            SearchObject searchObject) {

        List<Predicate> predicates = new ArrayList<>();

        // Se aplican los filtros ingresados por el usuario
        predicates.addAll(applyFilters(cb, providerRoot, searchObject));
        // Se elimina cualquier filtro null
        predicates.removeAll(Collections.singleton(null));

        // Se aplica ordenado por una propiedad
        applyOrderByProperty(providerRoot, cq, searchObject.getOrderPropertyName(), searchObject.isIsAscending());

        if(searchObject.getOrderByProperties().size() > 0) {
            applyOrderByProperty(providerRoot, cq, searchObject.getOrderByProperties());
        } else {
            applyOrderByProperty(providerRoot, cq, searchObject.getOrderPropertyName(), searchObject.isIsAscending());
        }

        cq.where(predicates.toArray(new Predicate[predicates.size()]));
        return cq;
    }

    public Long queryCount(SearchObject searchObject) {
        //Se crea una consulta base
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(instance);
        //FROM - Entidad
        Root providerRoot = cq.from(instance);
        cq.select(providerRoot);

        CriteriaQuery q = filter(cq, cb, providerRoot, searchObject);

        return count(providerRoot, cq);
    }

    private List<Predicate> applyFilters(CriteriaBuilder cb, Root root, SearchObject searchObject) {

        List<Predicate> predicates = new ArrayList<>();

        for (Property prop : searchObject.getProperties()) {

            String property = prop.getNameParameter();
            Object value = prop.getValue();

            if (value != null) {
                switch (prop.getType()) {
                case EQUAL:
                    predicates.add(addFilterEqual(cb, root, property, value));
                    break;
                case LIKE:
                    predicates.add(addFilterLike(cb, root, property, value));
                    break;
                case LIKE_LEFT:
                    predicates.add(addFilterLikeLeft(cb, root, property, value));
                    break;
                case LIKE_RIGHT:
                    predicates.add(addFilterLikeRight(cb, root, property, value));
                    break;
                case GREATER_THAN:
                    if (value instanceof Long) {
                        predicates.add(addFilterGreaterThan(cb, root, property, (Long) value));
                    }
                    if (value instanceof Integer) {
                        predicates.add(addFilterGreaterThan(cb, root, property, (Integer) value));
                    }
                    if (value instanceof Date) {
                        predicates.add(addFilterGreaterThan(cb, root, property, (Date) value));
                    }
                    if (value instanceof BigDecimal) {
                        predicates.add(addFilterGreaterThan(cb, root, property, (BigDecimal) value));
                    }
                    if (value instanceof Double) {
                        predicates.add(addFilterGreaterThan(cb, root, property, (Double) value));
                    }
                    break;
                case LESS_THAN:
                    if (value instanceof Long) {
                        predicates.add(addFilterLessThan(cb, root, property, (Long) value));
                    }
                    if (value instanceof Integer) {
                        predicates.add(addFilterLessThan(cb, root, property, (Integer) value));
                    }
                    if (value instanceof Date) {
                        predicates.add(addFilterLessThan(cb, root, property, (Date) value));
                    }
                    if (value instanceof BigDecimal) {
                        predicates.add(addFilterLessThan(cb, root, property, (BigDecimal) value));
                    }
                    if (value instanceof Double) {
                        predicates.add(addFilterLessThan(cb, root, property, (Double) value));
                    }
                    break;
                case GREATER_OR_EQUAL_THAN:
                    if (value instanceof Long) {
                        predicates.add(addFilterGreaterOrEqualThan(cb, root, property, (Long) value));
                    }
                    if (value instanceof Integer) {
                        predicates.add(addFilterGreaterOrEqualThan(cb, root, property, (Integer) value));
                    }
                    if (value instanceof Date) {
                        predicates.add(addFilterGreaterOrEqualThan(cb, root, property, (Date) value));
                    }
                    if (value instanceof BigDecimal) {
                        predicates.add(addFilterGreaterOrEqualThan(cb, root, property, (BigDecimal) value));
                    }
                    if (value instanceof Double) {
                        predicates.add(addFilterGreaterOrEqualThan(cb, root, property, (Double) value));
                    }
                    break;
                case LESS_OR_EQUAL_THAN:
                    if (value instanceof Long) {
                        predicates.add(addFilterLessOrEqualThan(cb, root, property, (Long) value));
                    }
                    if (value instanceof Integer) {
                        predicates.add(addFilterLessOrEqualThan(cb, root, property, (Integer) value));
                    }
                    if (value instanceof Date) {
                        predicates.add(addFilterLessOrEqualThan(cb, root, property, (Date) value));
                    }
                    if (value instanceof BigDecimal) {
                        predicates.add(addFilterLessOrEqualThan(cb, root, property, (BigDecimal) value));
                    }
                    if (value instanceof Double) {
                        predicates.add(addFilterLessOrEqualThan(cb, root, property, (Double) value));
                    }
                    break;
                case IS_NULL:
                    predicates.add(addFilterIsNull(cb, root, property));
                    break;
                case NOT_EQUAL:
                    predicates.add(addFilterNotEqual(cb, root, property, value));
                    break;
                case IS_NOT_NULL:
                    predicates.add(addFilterIsNotNull(cb, root, property));
                    break;
                }
            }
        }

        return predicates;

    }

    private Predicate addFilterIsNull(CriteriaBuilder cb, Root root, String queryPropertyName) {
        Predicate filterPredicate = null;
        if (queryPropertyName != null && !queryPropertyName.isEmpty()) {
            Path<String> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.isNull(filterPropertyPath);
        }
        return filterPredicate;
    }
    
    private Predicate addFilterIsNotNull(CriteriaBuilder cb, Root root, String queryPropertyName) {
        Predicate filterPredicate = null;
        if (queryPropertyName != null && !queryPropertyName.isEmpty()) {
            Path<String> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.isNotNull(filterPropertyPath);
        }
        return filterPredicate;
    }

    private Predicate addFilterLike(CriteriaBuilder cb, Root root, String queryPropertyName, Object value) {
        Predicate filterPredicate = null;
        if (value instanceof String) {
            if (((String) value).isEmpty()) {
                return null;
            }
        }
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<String> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.like(filterPropertyPath, "%" + value + "%");
        }
        return filterPredicate;
    }
    
    private Predicate addFilterLikeLeft(CriteriaBuilder cb, Root root, String queryPropertyName, Object value) {
        Predicate filterPredicate = null;
        if (value instanceof String) {
            if (((String) value).isEmpty()) {
                return null;
            }
        }
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<String> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.like(filterPropertyPath, "%" + value);
        }
        return filterPredicate;
    }
    private Predicate addFilterLikeRight(CriteriaBuilder cb, Root root, String queryPropertyName, Object value) {
        Predicate filterPredicate = null;
        if (value instanceof String) {
            if (((String) value).isEmpty()) {
                return null;
            }
        }
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<String> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.like(filterPropertyPath, value + "%");
        }
        return filterPredicate;
    }

    private Predicate addFilterEqual(CriteriaBuilder cb, Root root, String queryPropertyName, Object value) {
        Predicate filterPredicate = null;
        if (value instanceof String) {
            if (((String) value).isEmpty()) {
                return null;
            }
        }
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<Object> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.equal(filterPropertyPath, value);
        }
        return filterPredicate;
    }
    
    private Predicate addFilterNotEqual(CriteriaBuilder cb, Root root, String queryPropertyName, Object value) {
        Predicate filterPredicate = null;
        if (value instanceof String) {
            if (((String) value).isEmpty()) {
                return null;
            }
        }
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<Object> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.notEqual(filterPropertyPath, value);
        }
        return filterPredicate;
    }

    private Predicate addFilterGreaterThan(CriteriaBuilder cb, Root root, String queryPropertyName, Long value) {
        Predicate filterPredicate = null;
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<Long> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.greaterThan(filterPropertyPath, value);
        }
        return filterPredicate;
    }

    private Predicate addFilterGreaterThan(CriteriaBuilder cb, Root root, String queryPropertyName, Integer value) {
        Predicate filterPredicate = null;
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<Integer> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.greaterThan(filterPropertyPath, value);
        }
        return filterPredicate;
    }

    private Predicate addFilterGreaterThan(CriteriaBuilder cb, Root root, String queryPropertyName, Date value) {
        Predicate filterPredicate = null;
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<Date> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.greaterThan(filterPropertyPath, value);
        }
        return filterPredicate;
    }

    private Predicate addFilterGreaterThan(CriteriaBuilder cb, Root root, String queryPropertyName, BigDecimal value) {
        Predicate filterPredicate = null;
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<Date> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.greaterThan(filterPropertyPath.as(BigDecimal.class), value);
        }
        return filterPredicate;
    }

    private Predicate addFilterGreaterThan(CriteriaBuilder cb, Root root, String queryPropertyName, Double value) {
        Predicate filterPredicate = null;
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<Date> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.greaterThan(filterPropertyPath.as(Double.class), value);
        }
        return filterPredicate;
    }

    private Predicate addFilterLessThan(CriteriaBuilder cb, Root root, String queryPropertyName, Long value) {
        Predicate filterPredicate = null;
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<Long> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.lessThan(filterPropertyPath, value);
        }
        return filterPredicate;
    }

    private Predicate addFilterLessThan(CriteriaBuilder cb, Root root, String queryPropertyName, Integer value) {
        Predicate filterPredicate = null;
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<Integer> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.lessThan(filterPropertyPath, value);
        }
        return filterPredicate;
    }

    private Predicate addFilterLessThan(CriteriaBuilder cb, Root root, String queryPropertyName, Date value) {
        Predicate filterPredicate = null;
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<Date> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.lessThan(filterPropertyPath, value);
        }
        return filterPredicate;
    }

    private Predicate addFilterLessThan(CriteriaBuilder cb, Root root, String queryPropertyName, BigDecimal value) {
        Predicate filterPredicate = null;
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<Date> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.lessThan(filterPropertyPath.as(BigDecimal.class), value);
        }
        return filterPredicate;
    }

    private Predicate addFilterLessThan(CriteriaBuilder cb, Root root, String queryPropertyName, Double value) {
        Predicate filterPredicate = null;
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<Date> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.lessThan(filterPropertyPath.as(Double.class), value);
        }
        return filterPredicate;
    }

    private Predicate addFilterGreaterOrEqualThan(CriteriaBuilder cb, Root root, String queryPropertyName, Long value) {
        Predicate filterPredicate = null;
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<Long> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.greaterThanOrEqualTo(filterPropertyPath, value);
        }
        return filterPredicate;
    }

    private Predicate addFilterGreaterOrEqualThan(CriteriaBuilder cb, Root root, String queryPropertyName,
            Integer value) {
        Predicate filterPredicate = null;
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<Integer> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.greaterThanOrEqualTo(filterPropertyPath, value);
        }
        return filterPredicate;
    }

    private Predicate addFilterGreaterOrEqualThan(CriteriaBuilder cb, Root root, String queryPropertyName, Date value) {
        Predicate filterPredicate = null;
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<Date> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.greaterThanOrEqualTo(filterPropertyPath, value);
        }
        return filterPredicate;
    }

    private Predicate addFilterGreaterOrEqualThan(CriteriaBuilder cb, Root root, String queryPropertyName,
            BigDecimal value) {
        Predicate filterPredicate = null;
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<Date> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.greaterThanOrEqualTo(filterPropertyPath.as(BigDecimal.class), value);
        }
        return filterPredicate;
    }

    private Predicate addFilterGreaterOrEqualThan(CriteriaBuilder cb, Root root, String queryPropertyName,
            Double value) {
        Predicate filterPredicate = null;
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<Date> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.greaterThanOrEqualTo(filterPropertyPath.as(Double.class), value);
        }
        return filterPredicate;
    }

    private Predicate addFilterLessOrEqualThan(CriteriaBuilder cb, Root root, String queryPropertyName, Long value) {
        Predicate filterPredicate = null;
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<Long> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.lessThanOrEqualTo(filterPropertyPath, value);
        }
        return filterPredicate;
    }

    private Predicate addFilterLessOrEqualThan(CriteriaBuilder cb, Root root, String queryPropertyName, Integer value) {
        Predicate filterPredicate = null;
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<Integer> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.lessThanOrEqualTo(filterPropertyPath, value);
        }
        return filterPredicate;
    }

    private Predicate addFilterLessOrEqualThan(CriteriaBuilder cb, Root root, String queryPropertyName, Date value) {
        Predicate filterPredicate = null;
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<Date> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.lessThanOrEqualTo(filterPropertyPath, value);
        }
        return filterPredicate;
    }

    private Predicate addFilterLessOrEqualThan(CriteriaBuilder cb, Root root, String queryPropertyName,
            BigDecimal value) {
        Predicate filterPredicate = null;
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<Date> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.lessThanOrEqualTo(filterPropertyPath.as(BigDecimal.class), value);
        }
        return filterPredicate;
    }

    private Predicate addFilterLessOrEqualThan(CriteriaBuilder cb, Root root, String queryPropertyName, Double value) {
        Predicate filterPredicate = null;
        if (queryPropertyName != null && !queryPropertyName.isEmpty() && value != null) {
            Path<Date> filterPropertyPath = getParamsExpressionForString(root, queryPropertyName);
            filterPredicate = cb.lessThanOrEqualTo(filterPropertyPath.as(Double.class), value);
        }
        return filterPredicate;
    }

    public void applyOrderByProperty(Root<T> root, CriteriaQuery<T> cq, String property, Boolean isAscending) {
        if (property == null || property.isEmpty()) {
            return;
        }

        CriteriaBuilder cb = em.getCriteriaBuilder();
        //Obteniendo path para el ordenamiento, soporta anidacion de entidades ej. persons.name; persons.identify, etc
        Path<T> path = getParamsExpression(root, property);
        //ORDER BY -Consulta para ordenamiento
        Order queryOrder = (isAscending) ? cb.asc(path) : cb.desc(path);
        cq.orderBy(queryOrder);
    }

    public void applyOrderByProperty(Root<T> root, CriteriaQuery<T> cq, List<OrderByProperty> orderByList) {

        CriteriaBuilder cb = em.getCriteriaBuilder();

        List<Order> orderList = new ArrayList();

        orderByList.stream().forEachOrdered(i -> {
            if (i.getNameParameter() == null || i.getNameParameter().isEmpty()) {
                return;
            }

            Path<T> path = getParamsExpression(root, i.getNameParameter());
            //ORDER BY -Consulta para ordenamiento
            Order queryOrder = (i.getAsc()) ? cb.asc(path) : cb.desc(path);
            orderList.add(queryOrder);
        });

        cq.orderBy(orderList);
    }

    public Path<T> getParamsExpression(Root<T> root, String property) {
        if (property != null) {
            String[] innerProps = property.split(Pattern.quote("."));
            Path<T> path = null;
            if (innerProps.length == 0) {
                path = root.get(property);
            } else {
                for (String innerProp : innerProps) {
                    path = (path == null) ? root.get(innerProp) : path.get(innerProp);
                }
            }
            return path;
        }
        return null;
    }

    public Path<String> getParamsExpressionForString(Root<T> root, String property) {
        String[] innerProps = property.split(Pattern.quote("."));
        Path<String> path = null;
        if (innerProps.length == 0) {
            path = root.get(property);
        } else {
            for (String innerProp : innerProps) {
                path = (path == null) ? root.get(innerProp) : path.get(innerProp);
            }
        }
        return path;
    }

    public Path<Long> getParamsExpressionForLong(Root<T> root, String property) {
        String[] innerProps = property.split(Pattern.quote("."));
        Path<Long> path = null;
        if (innerProps.length == 0) {
            path = root.get(property);
        } else {
            for (String innerProp : innerProps) {
                path = (path == null) ? root.get(innerProp) : path.get(innerProp);
            }
        }
        return path;
    }

    public Path<Date> getParamsExpressionForDate(Root<T> root, String property) {
        String[] innerProps = property.split(Pattern.quote("."));
        Path<Date> path = null;
        if (innerProps.length == 0) {
            path = root.get(property);
        } else {
            for (String innerProp : innerProps) {
                path = (path == null) ? root.get(innerProp) : path.get(innerProp);
            }
        }
        return path;
    }

    public T find(Object id) {
        T ret = em.find(instance, id);
        em.flush();
        return ret; 
    }

    public List<T> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(instance));
        return em.createQuery(cq).getResultList();
    }

    public List<T> findByRange(int from, int to) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(instance));
        Query q = em.createQuery(cq);
        q.setMaxResults(to - from + 1);
        q.setFirstResult(from);
        return q.getResultList();
    }

    public List<T> findByRange(CriteriaQuery<T> cq, int from, int to) {
        return em.createQuery(cq).setMaxResults(to - from + 1).setFirstResult(from).getResultList();
    }

    public List<T> findAll(CriteriaQuery<T> cq) {
        return em.createQuery(cq).getResultList();
    }

    public List<T> findRangeSort(int from, int to, String orderBy, long order) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(instance));
        if (order == -1) {
            cq.orderBy(em.getCriteriaBuilder().desc(cq.from(instance).get(orderBy)));
        } else {
            cq.orderBy(em.getCriteriaBuilder().asc(cq.from(instance).get(orderBy)));
        }
        javax.persistence.Query q = em.createQuery(cq);
        q.setMaxResults(to - from + 1);
        q.setFirstResult(from);
        return q.getResultList();
    }

    public long count(Root<T> root, CriteriaQuery<T> cq) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        countQuery.select(cb.count(root));
        if (cq.getRestriction() != null) {
            countQuery.where(cq.getRestriction());
        }
        if (cq.getGroupRestriction() != null) {
            countQuery.where(cq.getGroupRestriction());
        }
        return em.createQuery(countQuery).getSingleResult();
    }
}
