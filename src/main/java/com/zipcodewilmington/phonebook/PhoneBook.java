package com.zipcodewilmington.phonebook;

import java.util.*;


/**
 * Created by leon on 1/23/18.
 */
public class PhoneBook {

    private LinkedHashMap<String, List<String>> phoneBook;
    private String name;
    private String phoneNumber;
    private List<String> numList = new ArrayList<>();


    public PhoneBook(LinkedHashMap<String, List<String>> map) {
        this.phoneBook = map;
    }

    public PhoneBook() {
        this.phoneBook = new LinkedHashMap<String, List<String>>(0);
    }

    public void add(String name, String phoneNumber) {
        numList.add(phoneNumber);
        phoneBook.put(name, numList);
    }

    public void addAll(String name, String... phoneNumbers) {
        for (String num : phoneNumbers) {
            numList.add(num);
        }
        phoneBook.put(name, numList);

    }

    public void remove(String name) {
        phoneBook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phoneBook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phoneBook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for(String key : phoneBook.keySet()){
            for (String num : phoneBook.get(key)){
                if (num.equals(phoneNumber)){
                    return key;
                }
            }
        }
        return "Not in phone book";
    }

    public List<String> getAllContactNames() {
        List<String> listOfNames = new ArrayList<>();
        for(String name : phoneBook.keySet()){
            listOfNames.add(name);
        }
        return listOfNames;
    }

    public Map<String, List<String>> getMap() {
        return phoneBook;
    }
}
