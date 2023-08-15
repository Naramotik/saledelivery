package ru.murza.saledelivery.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.murza.saledelivery.models.Client;
import ru.murza.saledelivery.repository.ClientRepository;

import java.util.Optional;

@Service
public class ClientDetailsService implements UserDetailsService {
    @Autowired
    private ClientRepository repository;

    @Override
    public UserDetails loadUserByUsername(String number) throws UsernameNotFoundException {
        Optional<Client> student = repository.findByNumber(number);

        return student.map(ClientDetails::new)
                .orElseThrow(()->new UsernameNotFoundException("user not found"));
    }
}

