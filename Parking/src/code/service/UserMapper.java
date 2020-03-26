<<<<<<< HEAD
package code.service;

import code.dao.UserEntity;
import code.domain.User;

public class UserMapper {

    public User mapToUser(UserEntity userEntity) throws Exception {
        String username = userEntity.getUsername();
        String password = userEntity.getPassword();
        boolean isAdmin = userEntity.isAdmin();
        return new User(username, password, isAdmin);
    }
}
=======
package code.service;

import code.dao.UserEntity;
import code.domain.User;

public class UserMapper {

    public User mapToUser(UserEntity userEntity) throws Exception {
        String username = userEntity.getUsername();
        String password = userEntity.getPassword();
        boolean isAdmin = userEntity.isAdmin();
        return new User(username, password, isAdmin);
    }
}
>>>>>>> d305a227df5d2b5b2393570a095528e85b9c0d3d
