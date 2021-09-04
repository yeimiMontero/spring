package com.udemy.backendninja.component;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Component;

//Esto hara que spring lo guarde en memoria cuando arranque la app
@Component("exampleComponent")
public class ExampleComponent {

    private static final Log LOG= LogFactory.getLog(ExampleComponent.class);

    public void sayHello(){
        LOG.info("HELLO FROM EXAMPLE COMPONENT");
    }
}
