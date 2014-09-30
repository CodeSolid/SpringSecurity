package com.codesolid.securecassandra.model.repository;

import com.codesolid.securecassandra.model.dto.User;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;



import org.springframework.data.cassandra.repository.TypedIdCassandraRepository;
import org.springframework.stereotype.Service;

/**
 * Created by john on 9/28/14.
 */



public class UserRepository /* extends SimpleCassandraRepository<User, String> */ {

    CassandraOperations template;

    public UserRepository(CassandraTemplate template) {
        this.template = template;

    }

    public void update(User user) {
        template.update(user);
    }

    public void insert(User user) {
        template.insert(user);
    }

    public User selectOne(String email) {
        // NOTE -- This assumes trusted caller!
        // Query should be parameterized
        String cql = "select * from users where email = '" + email + "'";
        User user = template.selectOne(cql, User.class);
        return user;
    }


}
