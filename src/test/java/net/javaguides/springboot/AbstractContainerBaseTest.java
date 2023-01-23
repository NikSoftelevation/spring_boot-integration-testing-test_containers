package net.javaguides.springboot;

import org.testcontainers.containers.MySQLContainer;

/**
 * The type Abstract container base test.
 */
public class AbstractContainerBaseTest {

    /**
     * The My sql container.
     */
    static final MySQLContainer MY_SQL_CONTAINER;

    static{
        MY_SQL_CONTAINER=new MySQLContainer("mysql:latest");
        MY_SQL_CONTAINER.start();
    }
}
