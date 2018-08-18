class PrimeCheck {
    public static void main(String[] args) {
        int upperLimit = 100;
        int lowerLimit = 90;
        
        boolean[] sieve = new boolean[upperLimit+1];

        // initialize sieve
        for (int i=2; i<sieve.length; ++i)
            sieve[i] = true;

        // neither 0 or 1 are primes
        sieve[0] = sieve[1] = false;

        for (int i=2; i*i<sieve.length; ++i) {
            // if prime!
            if (sieve[i])
                // mark multiples as non primes
                for (int j=i*i; j<sieve.length; j+=i)
                    sieve[j] = false;
        }

        for (int i=lowerLimit; i<sieve.length; i++){
            if (!sieve[i])
                System.out.println(i);
        }
    }
}
