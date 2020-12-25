package com.company;

import java.util.Arrays;

public class Eratosfen {
    private static boolean[] primes;

    public Eratosfen(int n) {
        primes=new boolean[n+1];
    }

    public boolean[] reshetoEratosfera(){
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i < primes.length; ++i) {
            if (primes[i]) {
                for (int j = 2; i * j < primes.length; ++j) {
                    primes[i * j] = false;
                }
            }
        }
        return primes;
    }
}
