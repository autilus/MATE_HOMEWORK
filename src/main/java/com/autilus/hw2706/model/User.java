package com.autilus.hw2706.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String firstName;
    private String lastName;
}
