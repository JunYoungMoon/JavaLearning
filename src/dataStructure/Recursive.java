package dataStructure;

class Recursive {

    //팩토리얼
    static int factorial(int n){
        if(n > 0){
            return n * factorial(n - 1);
        }else{
            return 1;
        }
    }
    //유클리드 호제법
    static int gcd(int x, int y){
        if(y == 0){
            return x;
        }else{
            return gcd(y, x % y);
        }
    }
}