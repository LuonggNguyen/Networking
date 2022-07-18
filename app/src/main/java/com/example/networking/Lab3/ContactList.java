package com.example.networking.Lab3;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ContactList {
    @SerializedName("contacts")
    @Expose
    private ArrayList<Contact1> contacts = new ArrayList<>();

    public ArrayList<Contact1> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact1> contacts) {
        this.contacts = contacts;
    }
}
