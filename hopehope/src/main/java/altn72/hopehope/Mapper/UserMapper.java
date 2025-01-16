package altn72.hopehope.Mapper;

import altn72.hopehope.Model.User;
import altn72.hopehope.Dto.UserDTO;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getRole()
        );
    }
}
