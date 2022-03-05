package web.config;

import com.sun.istack.Nullable;
import org.hibernate.Session;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.testng.annotations.Test;
import web.model.Shop;
import web.model.User;

import javax.persistence.*;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

@ControllerAdvice
public class Util {

//
//    @Nullable
//    public static <T> T singleResult(@Nullable Collection<T> results) throws IncorrectResultSizeDataAccessException {
//        if (CollectionUtils.isEmpty(results)) {
//            return null;
//        }
//        if (results.size() > 1) {
//            throw new IncorrectResultSizeDataAccessException(1, results.size());
//        }
//        return results.iterator().next();
//    }
//
//    s);
//
//
//
//
//
//    public static <T> T requiredSingleResult(Collection<T> results) throws IncorrectResultSizeDataAccessException {
//        int size = (results != null ? results.size() : 0);
//        if (size == 0) {
//            throw new EmptyResultDataAccessException(1);
//        }
//        if (results.size() > 1) {
//            throw new IncorrectResultSizeDataAccessException(1, size);
//        }
//        return results.iterator().next();
//    }
//
//
//
//
//
//
//    public Optional<Shop> findByUserName(String name) {
//        try {
//            return jdbcTemplate.queryForObject("SELECT * FROM USER WHERE USERNAME = ?", new Object[] { name },
//                    (rs, rowNum) -> Optional.of(mapUserResult(rs)));
//        } catch (EmptyResultDataAccessException e) {
//            log.debug("No record found in database for "+name, e);
//            return Optional.empty();
//        }
//    }
//    public Util(DataSource datasource){
//        this.datasource = datasource;
//
//    }
//
//    JdbcTokenStore jdbcTokenStore = new JdbcTokenStore(datesource);
//    jdbcTokenStore.setSelectAccessTokenFromAuthenticationSql("select token_id, token from oauth_access_token " +
//            "where authentication_id = ?" + " group by authentication_id");
//    jdbcTokenStore.setSelectAccessTokenAuthenticationSql("select token_id, authentication " +
//            "from oauth_access_token where token_id = ? group by token_id");
//    jdbcTokenStore.setSelectAccessTokenSql("select token_id, " +
//            "token from oauth_access_token where token_id = ? group by token_id");
//    jdbcTokenStore.setSelectRefreshTokenSql("select token_id, token from oauth_refresh_token " +
//            "where token_id = ? group by token_id");
//    jdbcTokenStore.setSelectRefreshTokenAuthenticationSql("select token_id, authentication " +
//            "from oauth_refresh_token where token_id = ? group by token_id");
//
//
//
//
//    @PersistenceContext
//    private EntityManager em;
//    @Override
//    public Optional<Shop> findUserByHisName(String name) {
//        return em.unwrap(Session.class).createQuery("select u from Shop u where u.name =:name", Shop.class)
//                .setParameter("name", name)
//                .setFirstResult(0)
//                .setMaxResults(1)
//                .uniqueResultOptional();
//    }
//
//    @Test(expected = IncorrectResultSizeDataAccessException.class)
//    public void whenRetrievingMultipleValues_thenIncorrectResultSizeException() {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(restDataSource);
//
//        jdbcTemplate.execute("insert into foo(name) values ('a')");
//        jdbcTemplate.execute("insert into foo(name) values ('a')");
//
//        jdbcTemplate.queryForObject("select id from foo where name='a'", Integer.class);
//    }
//
//    public List<R> extractData(ResultSet rs) throws SQLException, DataAccessException {
//        List<R> results = new ArrayList<R>();
//        int row = 0;
//        boolean more = rs.next();
//        if (more) {
//            row++;
//        }
//        while (more) {
//            R root = rootMapper.mapRow(rs, row);
//            K primaryKey = mapPrimaryKey(rs);
//            if (mapForeignKey(rs) != null) {
//                while (more && primaryKey.equals(mapForeignKey(rs))) {
//                    addChild(root, childMapper.mapRow(rs, row));
//                    more = rs.next();
//                    if (more) {
//                        row++;
//                    }
//                }
//            } else {
//                more = rs.next();
//                if (more) {
//                    row++;
//                }
//            }
//            results.add(root);
//        }
//        if ((expectedResults == ExpectedResults.ONE_AND_ONLY_ONE || expectedResults == ExpectedResults.ONE_OR_NONE)
//                && results.size() > 1) {
//            throw new IncorrectResultSizeDataAccessException(1, results.size());
//        }
//        if ((expectedResults == ExpectedResults.ONE_AND_ONLY_ONE || expectedResults == ExpectedResults.AT_LEAST_ONE)
//                && results.size() < 1) {
//            throw new IncorrectResultSizeDataAccessException(1, 0);
//        }
//        return results;
//    }
//
//
//
//
//    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
//    public static <T> T singleResult(Query query, Class<T> clazz) {
//        List<T> results = query.getResultList();
//        if (results.size() == 1) {
//            return results.get(0);
//        }
//        if (results.size() > 1) {
//            logger.error("The query {} returned more than one results : {} ", query, results);
//            return null;
//        }
//        logger.warn("No result for query : {}", query);
//        return null;
//    }
//
//
//
//    public static <L> L getSingleResultOrNull(TypedQuery<L> query) {
//        List<L> results = query.getResultList();
//        L foundEntity = null;
//        if(!results.isEmpty()) {
//            foundEntity = results.get(0);
//        }
//        if(results.size() > 1) {
//            for(L result : results) {
//                if(result != foundEntity) {
//                    throw new NonUniqueResultException();
//                }
//            }
//        }
//        return foundEntity;
//    }
//
//
//
//        public static Object getSingleResultOrNull(Query query){
//            List results = query.getResultList();
//            if (results.isEmpty()) return null;
//            else if (results.size() == 1) return results.get(0);
//            throw new NonUniqueResultException();
//        }

}
