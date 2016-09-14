public Country getCountryByName(EntityManager em, String name) {
   TypedQuery
javax.persistence.TypedQuery
JPA interface
Interface used to control the execution of typed queries.
See JavaDoc Reference Page...
<Country> query = em.createQuery(
       "SELECT c FROM Country c WHERE c.name = ?1", Country.class);
   return query.setParameter(1, name).getSingleResult();
 }