package ua.upsite.nso.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

/**
 *  Created by gregory on 11/9/15.
 */
//@Service
public class TestServiceImpl implements TestService {

    @Override
    public String sayHello() {
        return "Hello huy!";
    }
}
