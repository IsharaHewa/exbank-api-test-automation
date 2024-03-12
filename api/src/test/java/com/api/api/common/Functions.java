package com.api.api.common;

import com.api.api.model.*;
import io.restassured.specification.RequestSpecification;
import static com.api.api.common.Constants.*;
public class Functions {
    //Create new user
    public static User createUser(int statusCode, String jsonBody){
        RequestSpecification specification = SpecBuilder
                .postRequestSpecificationBuilder(CREATE_USER, jsonBody).log().all();
        return CommonApi.post(specification)
                .then()
                .statusCode(statusCode).log().all()
                .extract()
                .response()
                .as(User.class);
    }
    //Deposit amount
    public static Deposit deposit(int statusCode, String jsonBody){
        RequestSpecification specification = SpecBuilder
                .postRequestSpecificationBuilder(DEPOSIT, jsonBody).log().all();
        return CommonApi.post(specification)
                .then()
                .statusCode(statusCode).log().all()
                .extract()
                .response()
                .as(Deposit.class);
    }
    //Withdraw amount
    public static Withdraw withdraw (int statusCode, String jsonBody){
        RequestSpecification specification = SpecBuilder
                .postRequestSpecificationBuilder(WITHDRAW, jsonBody).log().all();
        return CommonApi.post(specification)
                .then()
                .statusCode(statusCode).log().all()
                .extract()
                .response()
                .as(Withdraw.class);
    }

//Get balance of an existing account
    public static GetBalance getBalance (int statusCode){
        RequestSpecification specification = SpecBuilder
                .getRequestSpecificationBuilder(GET_BALANCE).log().all();
        return CommonApi.get(specification)
                .then()
                .statusCode(statusCode).log().all()
                .extract()
                .response()
                .as(GetBalance.class);
    }

    //send money from one account to another
    public static Send send (int statusCode, String jsonBody){
        RequestSpecification specification = SpecBuilder
                .postRequestSpecificationBuilder(SEND, jsonBody).log().all();
        return CommonApi.post(specification)
                .then()
                .statusCode(statusCode).log().all()
                .extract()
                .response()
                .as(Send.class);
    }

}
