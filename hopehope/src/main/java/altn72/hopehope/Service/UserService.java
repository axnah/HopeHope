package altn72.hopehope.Service;

import altn72.hopehope.Model.User;
import altn72.hopehope.Repository.UserRepository;
import altn72.hopehope.Dto.UserDTO;
import altn72.hopehope.Mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<UserDTO> getUserById(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::toDTO);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<UserDTO> getUsersByRole(String role) {
        return userRepository.findByRole(role)
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }
}
