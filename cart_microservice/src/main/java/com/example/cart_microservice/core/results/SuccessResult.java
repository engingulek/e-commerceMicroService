package com.example.cart_microservice.core.results;


public class SuccessResult extends  Result{
    public  SuccessResult(){
        super(true);

    }

    public  SuccessResult(String message){
        super(true,message);

    }

}
