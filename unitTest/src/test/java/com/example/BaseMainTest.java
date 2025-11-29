package com.example;

import org.junit.jupiter.api.BeforeEach;

public abstract class BaseMainTest {

    protected Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }
}
