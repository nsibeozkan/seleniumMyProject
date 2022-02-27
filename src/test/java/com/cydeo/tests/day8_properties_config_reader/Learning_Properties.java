package com.cydeo.tests.day8_properties_config_reader;

import org.testng.annotations.Test;

public class Learning_Properties {

    @Test
    public void java_properties_reading_test(){
        //key ===>returns value
        //os.name=Mac OS X
        //user.name=nesibe
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));

    }

}


