package com.example.stageOne.dto;

import java.util.List;

public class NumberResponse {
    private int number;
    private boolean is_prime;
    private boolean is_perfect;
    private List<String> properties;
    private int digit_sum;
    private String fun_fact;

    public NumberResponse(int number, boolean is_prime, boolean is_perfect, List<String> properties, int digit_sum, String fun_fact){
        this.number = number;
        this.is_prime = is_prime;
        this.is_perfect = is_perfect;
        this.properties = properties;
        this.digit_sum = digit_sum;
        this.fun_fact = fun_fact;
    }

    public int getNumber() {return number;}
    public boolean getis_prime() {return is_prime;}
    public boolean getis_perfect() {return is_perfect;}
    public List<String> getProperties() {return properties;}
    public int getdigit_Sum() {return digit_sum;}
    public String getfun_Fact() {return fun_fact;}
}
