package com.demoqa.tests;

import org.junit.jupiter.api.*;

import java.lang.module.Configuration;

public class ExampleJUnit5Test {

    @BeforeAll // выполняется перед всеми методам
    static void configure(){
        System.out.println("This is BeforeAll");
    }
    @AfterAll // выполняется после всех методов
    static void tearDown(){
        System.out.println("It is afterall");
    }
    @AfterEach // выполняется после каждого теста
    void afterTest(){
        System.out.println("  This is the AfterEach");
    }
    @BeforeEach // выполняется после каждого теста
    void beforeTest(){
        System.out.println("     This is the BeforeEach");
    }

    @Test // ну тест
    void firstTest(){
        System.out.println("   TEst 1");
    }
    @Test // и это
    void secondTest(){
        System.out.println("    TEst 2");    }

}
