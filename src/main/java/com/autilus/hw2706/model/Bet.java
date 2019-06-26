package com.autilus.hw2706.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Bet implements Serializable {
    private int value;
    private double risk;
}
