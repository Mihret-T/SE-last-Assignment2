package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        //accepts the user email and pass word
        String userName = JOptionPane.showInputDialog("Enter your user name or password ");
        String pass = JOptionPane.showInputDialog("Enter you account password");

        notify(userName,pass);


    }
    public static void notify(String userEmail, String userPassword){
        String userName =  userEmail;
        String pass = userPassword;

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //instantiate WebDriver
        WebDriver driver = new ChromeDriver();

        //get specified Url
        driver .get("https://facebook.com");

        //create WebElement instance for email Input textbox
        WebElement email = driver .findElement(By.id("email"));

        email.sendKeys(userName);

        //create WebElement instance for password Input textbox
        WebElement password = driver .findElement(By.id("pass"));

        password.sendKeys(pass);

        //get the login button
        WebElement login = driver .findElement(By.id("u_0_2"));
        login.click();

        WebElement notification1 = driver .findElement(By.id("u_0_5"));
        String notificationMessage = notification1.getText();

        WebElement notification2 = driver .findElement(By.id("notificationsCountValue"));
        String notificationNum = notification2.getText();

        System.out.print(notificationNum +" new notifications");

        String result = "you have got " + notificationNum +" new notifications";
        JOptionPane.showMessageDialog(null,result);

        //exit
        driver.close();

    }
}

