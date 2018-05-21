package com.peteriscaurs.graphqlserver.graphqlserver.services;

import com.peteriscaurs.graphqlserver.graphqlserver.exceptions.EmailAlreadyTakenException;
import com.peteriscaurs.graphqlserver.graphqlserver.exceptions.InvalidCredentialsException;
import com.peteriscaurs.graphqlserver.graphqlserver.repositories.UsersRepository;
import com.peteriscaurs.graphqlserver.graphqlserver.repositories.WordsRepository;
import com.peteriscaurs.graphqlserver.graphqlserver.types.user.*;
import com.peteriscaurs.graphqlserver.graphqlserver.types.word.Word;
import com.peteriscaurs.graphqlserver.graphqlserver.utilities.MD5Encryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
        final Optional<User> user = Optional.ofNullable(usersRepository.findByEmail(input.getEmail()));
        if (user.isPresent()) {
            throw new EmailAlreadyTakenException("Email already taken", input.getEmail());
        } else {
            return usersRepository.save(new User(
                    input.getName(),
                    input.getEmail(),
                    MD5Encryptor.encrypt(input.getPassword()),
                    LocalDate.now().toString()
            ));
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

    public User addWordToFavorites(UpdateFavoritesInput input) {
        User user = usersRepository.findOne(input.getUserId());
        Word favoriteWord = wordsRepository.findOne(input.getWordId());
        user.getFavorites().add(favoriteWord);
        return usersRepository.save(user);
    }

    public User removeWordFromFavorites(UpdateFavoritesInput input) {
        User user = usersRepository.findOne(input.getUserId());
        user.getFavorites().removeIf(word -> word.getId().equals(input.getWordId()));
        return usersRepository.save(user);
    }

}
