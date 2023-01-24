package org.example.exceptions;

public class LaptopNotFoundException extends RuntimeException {
    public LaptopNotFoundException(){
        super();
    }
    public LaptopNotFoundException(String messaage){

        super(messaage);
    }

}
