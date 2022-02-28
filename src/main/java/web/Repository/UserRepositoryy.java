package web.Repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import web.model.User;

    @Repository
    public interface UserRepositoryy
            extends PagingAndSortingRepository<User, Long> {
}
