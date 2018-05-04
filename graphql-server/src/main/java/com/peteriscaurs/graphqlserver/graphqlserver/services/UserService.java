package com.peteriscaurs.graphqlserver.graphqlserver.services;

import com.peteriscaurs.graphqlserver.graphqlserver.domain.*;
import com.peteriscaurs.graphqlserver.graphqlserver.exceptions.EmailAlreadyTakenException;
import com.peteriscaurs.graphqlserver.graphqlserver.exceptions.InvalidCredentialsException;
import com.peteriscaurs.graphqlserver.graphqlserver.repositories.UsersRepository;
import com.peteriscaurs.graphqlserver.graphqlserver.repositories.WordsRepository;
import com.peteriscaurs.graphqlserver.graphqlserver.utilities.MD5Encryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author peteris-caurs
 */
@Component
public class UserService {

    private final UsersRepository usersRepository;
    private final WordsRepository wordsRepository;

    @Autowired
    public UserService(UsersRepository usersRepository, WordsRepository wordsRepository) {
        this.usersRepository = usersRepository;
        this.wordsRepository = wordsRepository;
    }

    public List<User> getUsers() {
        return usersRepository.findAll();
    }

    public User signUpUser(SignUpInput input) {
        // TODO: name not empty, validate email with REGEX, min password length 8
        Optional<User> existingUser = Optional.ofNullable(usersRepository.findByEmail(input.getEmail()));
        if (existingUser.isPresent()) {
            throw new EmailAlreadyTakenException("Email already taken", input.getEmail());
        } else {
            User user = new User(
                    input.getName(),
                    input.getEmail(),
                    MD5Encryptor.encrypt(input.getPassword())
            );
            return usersRepository.save(user);
        }
    }

    public SignInPayload signInUser(SignInInput input) {
        Optional<User> existingUser = Optional.ofNullable(usersRepository.findByEmail(input.getEmail()));
        if (existingUser.isPresent()) {
            final User user = existingUser.get();
            final String inputPassword = MD5Encryptor.encrypt(input.getPassword());
            if (user.getPassword().equals(inputPassword)) {
                return new SignInPayload(user.getId(), user);
            } else {
                throw new InvalidCredentialsException("Incorrect email or password");
            }
        } else {
            throw new InvalidCredentialsException("Incorrect email or password");
        }
    }

    public User addWordToFavorites(AddWordToFavoritesInput input) {
        User user = usersRepository.findOne(input.getUserId());
        Word favoriteWord = wordsRepository.findOne(input.getWordId());
        user.getFavorites().add(favoriteWord);
        return usersRepository.save(user);
    }

}
