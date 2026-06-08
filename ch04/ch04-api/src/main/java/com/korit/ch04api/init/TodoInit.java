package com.korit.ch04api.init;

import com.korit.ch04api.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TodoInit implements CommandLineRunner {
    private final TodoMapper todoMapper;

    @Override
    public void run(String... args) throws Exception {
        // Initialize todos table if it doesn't exist
        todoMapper.createTableIfNotExists();
        System.out.println("Todos table initialization check completed.");
    }
}
