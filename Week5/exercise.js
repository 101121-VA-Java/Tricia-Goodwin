// Problem 1: Create a function "isWeekday" which takes a single argument and returns true if the argument is a day during the work week. It should return false if it is not.

function isWeekday(input) {
    let week = true;
    if (input =="Saturday" || input == "Sunday"){
        week = false;
    }
    return week;
}

// Problem 2: Create a function "isEven" which takes a single argument and returns true if the argument is an even integer. It should return false if it is not

function isEven(input) {
    let odd = input%2;
    return !odd;
}

// Problem 3: Write a JavaScript function which takes a single argument and returns the type

function findType(input) {
    return typeof input;
}

// Problem 4: Write a JavaScript function which takes a single argument and determines if it's prime. If it is, return true. If it's not return false.

function isPrime(input) {
    let prime = true;
    if(input == 1){
        prime = false;
    }
    for(let i = 2;i<input; i++){
        if(input%i == 0){
            prime = false;
        }
    
    }

    return prime;
}

// Problem 5: Write a JavaScript function which calculates the first number to the power of the second number. Do not do this recursively. Do not use the Math library.

function calculateExponent(base, exponent) {
    if(exponent==0){
        return 1;
    } else{
        let ans = 1;
        let i = 0;
        while(i<exponent){
            ans=ans*base;
            i++;
        }
        return ans;
    }
    
}