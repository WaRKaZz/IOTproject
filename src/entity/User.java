package entity;

import javax.servlet.http.Cookie;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class User {

    private Cookie cookie = null;
    private String login = null;
    private String pass = null;

    {
        File file = new File("D:/Projects/IOTproject/resources/resources.properties");
        try(InputStream input = new FileInputStream(file)){
            Properties properties = new Properties();
            properties.load(input);
            properties.setProperty("1", "2");
            login = properties.getProperty("login");
            pass = properties.getProperty("pass");
            cookie = new Cookie("userInfo", properties.getProperty("userInfo"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("no such file");
        }
    }

    public void setPass(String pass) {
        try(InputStream input = new FileInputStream("/userConfig/config.properties")){
            Properties properties = new Properties();
            properties.load(input);
            properties.setProperty("pass", pass);
        }  catch (IOException e) {
            e.printStackTrace();
        }
        this.pass = pass;
    }

    public void setCookie(Cookie cookie) {
        this.cookie = cookie;
    }

    public void setLogin(String login) {
        try(InputStream input = new FileInputStream("/userConfig/config.properties")){
            Properties properties = new Properties();
            properties.load(input);
            properties.setProperty("login", login);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public String getLogin() {
        return login;
    }

    public Cookie getCookie() {
        return cookie;
    }
}
