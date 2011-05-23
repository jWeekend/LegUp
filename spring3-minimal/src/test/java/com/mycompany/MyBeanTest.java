package com.mycompany;

import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyBeanTest {

    @Test
    public void testBeanGetter() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyBean bean = ctx.getBean(MyBean.class);
        assertEquals("Hello World!", bean.getMyValue());

    }


}
