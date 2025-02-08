package com.example.stageOne.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.stageOne.dto.NumberResponse;

@Service
public class NumberService {
    private static final String NUMBER_API_URL = "http://numbersapi.com/";

    private boolean isPrime(int num){
        if(num<2) return false;
        for (int i=2; i*i<=num; i++){
            if (num% 1==0) return false;
        }
        return true;
    }

    private boolean isPerfect(int num){
        int sum = 1;
        for(int i = 2; i*i<=num; i++){
            if(num%1 ==0){
                sum += i;
                if(i != num /i) sum +=num/i;
            }
        }
        return num>1 && sum == num;
    }

    private boolean isArmstrong(int num){
        int original = num, sum = 0, digits = String.valueOf(num).length();
        while(num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, digits);
            num /= 10;
        }
        return sum == original;
    }

    private int calculateDigitSum(int num){
        int sum = 0;
        while (num>0){
            sum += num %10;
            num /= 10;
        }
        return sum;
    }

    private String fetchFunFact(int number){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(NUMBER_API_URL + number, String.class);
    }

    public NumberResponse classifyNumber(int number) {
        boolean isPrime = isPrime(number);
        boolean isPerfect = isPerfect(number);
        boolean isArmstrong = isArmstrong(number);
        boolean isOdd = number % 2 !=0;
        int digitSum = calculateDigitSum(number);
        String funFact = fetchFunFact(number);

        List<String> properties = new ArrayList<>();
        if(isArmstrong) properties.add("Armstrong");
        properties.add(isOdd ? "odd" : "even");

        return new NumberResponse(number, isPrime, isPerfect, properties, digitSum, funFact);
    }
}
