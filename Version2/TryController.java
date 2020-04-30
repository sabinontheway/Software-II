package com.example.demo.controller;

import com.example.demo.object.Account;
import com.example.demo.object.BankCustomer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@RestController
public class TryController {

@PostMapping("/createsavingaccount")
    public String createNewCustomer(@RequestBody Map<String, String> params){
    String accNo = params.get("account_no");
    String accBal = params.get("account_balance");
    String bankId = params.get("bank_id");
     String firstName = params.get("first_name");
     String lastName = params.get("last_name");
    String userName = params.get("username");
     String password = params.get("password");
     String address = params.get("address");
    Account account = new Account(accNo,Float.parseFloat(accBal));
    BankCustomer bankCustomer = new BankCustomer(bankId,firstName,lastName,userName,password,address);
    boolean newAccountCreated = addSavingAccount(account,bankCustomer);
    if(newAccountCreated){
        return "Created Account Sucessfully";
    }else {
        return "Failed To Create account";
    }
}

    private boolean addSavingAccount(Account account, BankCustomer bankCustomer){
        boolean added = false;
        try {
            // create a list of objects
            List<List> records = Arrays.asList(
                    Arrays.asList(account.getNumber(), Float.toString(account.getBalance()), bankCustomer.getId(),bankCustomer.getUserName(),bankCustomer.getFirstName(),bankCustomer.getLastName(),bankCustomer.getAddress(),bankCustomer.getPassword())
            );

            // create a writer
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("C:\\Users\\pokha\\Downloads\\javaapp\\webservices-java-master\\restdemo-1\\src\\bankCustomer.csv"));

            // write all records
            for (List record : records) {
                writer.append(String.join(",", record));
                writer.newLine();
            }

            //close the writer
            writer.close();
            added = true;


        } catch (IOException ex) {


        }
        return  added;

    }
