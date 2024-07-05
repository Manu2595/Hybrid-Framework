package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties pro;

  public  ReadConfig(){

      try {
          File file = new File("./src/test/resources/config.properties");

          FileInputStream fis = new FileInputStream(file); // Read the file
          pro= new Properties();
          pro.load(fis); //load the file

      } catch (Exception e) {
          System.out.println("Exception is "+e.getMessage());
      }
  }

  public String getApplicationUrl(){
    String url=  pro.getProperty("baseUrl");
    return url;
  }
    public String getUsername(){
        String username=  pro.getProperty("username");
        return username;
    }
    public String getPassword(){
        String passWord=  pro.getProperty("password");
        return passWord;
    }
}
