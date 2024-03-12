package com.api.api.test;

import com.api.api.TestBase;
import com.api.api.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.List;
import static com.api.api.common.Functions.*;
import static com.api.api.utils.FileUtils.JSON_TEST_DATA;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class test_exbank extends TestBase {

    static ObjectMapper objectMapper = new ObjectMapper();
    static List<JSONObject> testUserDataList;

    public static List<JSONObject> readTestDataToList(String testDataObject) {
        JSONParser parser = new JSONParser();
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();
        try {
            Object obj = parser.parse(new FileReader(JSON_TEST_DATA));
            JSONObject jsonObject = (JSONObject) obj;
            for (Object key : jsonObject.keySet()) {
                String strKey = (String) key;
                Object value = jsonObject.get(strKey);
                linkedHashMap.put(strKey, value);
            }
            System.out.println(linkedHashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (List<JSONObject>) linkedHashMap.get(testDataObject);
    }

    @Test(priority = 1, description = "Validate create user with a valid request")
    public static void tc05_ValidateCreateUserWithValidRequest() throws JsonProcessingException {

        testUserDataList = readTestDataToList("TestUserData");
        for (JSONObject userData : testUserDataList) {
            String jsonBody = objectMapper.writeValueAsString(User.builder()
                    .id(Integer.parseInt((String) userData.get("id")))
                    .age(Integer.parseInt((String) userData.get("age")))
                    .name((String) userData.get("name"))
                    .email((String) userData.get("email"))
                    .accountNumber((String) userData.get("accountNumber"))
                    .accountStatus((String) userData.get("accountStatus"))
                    .accountType((String) userData.get("accountType"))
                    .currency((String) userData.get("currency")).build());

            User model = createUser(HttpStatus.SC_OK, jsonBody);
            Assert.assertNotNull(model, "Create user failed with valid request");
            Assert.assertEquals(model.getEmail(), (String) userData.get("email"), "Incorrect email adress for the created user");
            Assert.assertEquals(model.getName(), (String) userData.get("name"), "Incorrect name for the created user");
            Assert.assertEquals(model.getAge(), Integer.parseInt((String) userData.get("age")), "Incorrect age for the created user");
            Assert.assertEquals(model.getId(), Integer.parseInt((String) userData.get("id")), "Incorrect id for the created user");
            Assert.assertEquals(model.getAccountNumber(), (String) userData.get("accountNumber"), "Incorrect account number for the created user");
            Assert.assertEquals(model.getAccountStatus(), (String) userData.get("accountStatus"), "Incorrect account status for the created user");
            Assert.assertEquals(model.getAccountType(), (String) userData.get("accountType"), "Incorrect account type for the created user");
            Assert.assertEquals(model.getCurrency(), (String) userData.get("currency"), "Incorrect currency for the created user");
        }
    }

    @Test(priority = 1, description = "Validate create user with a invalid request")
    public static void tc06_ValidateCreateUserWithInvalidRequest() throws JsonProcessingException {

        testUserDataList = readTestDataToList("TestInvalidUserData");
        for (JSONObject userData : testUserDataList) {
            String jsonBody = objectMapper.writeValueAsString(User.builder()
                    .id(Integer.parseInt((String) userData.get("id")))
                    .age(Integer.parseInt((String) userData.get("age")))
                    .name((String) userData.get("name"))
                    .email((String) userData.get("email"))
                    .accountNumber((String) userData.get("accontNumber"))
                    .accountStatus((String) userData.get("accountStatus"))
                    .accountType((String) userData.get("accountType"))
                    .currency((String) userData.get("currency")).build());

            User model = createUser(HttpStatus.SC_BAD_REQUEST, jsonBody);
            Assert.assertNotNull(model, "Create user error with invalid request");
        }
    }

    @Test(priority = 1, description = "Validate deposit with a valid request")
    public static void tc07_ValidateDepositWithValidRequest() throws JsonProcessingException {

        testUserDataList = readTestDataToList("TestDepositData");
        for (JSONObject userData : testUserDataList) {
            String jsonBody = objectMapper.writeValueAsString(Deposit.builder()
                    .accountNumber((String) userData.get("accountNumber"))
                    .amount(Double.valueOf((String) userData.get("amount")))
                    .currency((String) userData.get("currency")).build());

            Deposit model = deposit(HttpStatus.SC_OK, jsonBody);
            Assert.assertNotNull(model, "Deposit failed with valid request");
            Assert.assertEquals(model.getAccountNumber(), (String) userData.get("accountNumber"), "Incorrect deposit account number");
            Assert.assertEquals(model.getAmount(), (String) userData.get("amount"), "Incorrect deposit amount");
            Assert.assertEquals(model.getCurrency(), (String) userData.get("currency"), "Incorrect deposit currency");
        }
    }

    @Test(priority = 1, description = "Validate deposit with an invalid request -partial")
    public static void tc11_ValidateDepositWithInvalidRequest() throws JsonProcessingException {

        testUserDataList = readTestDataToList("TestDepositInvalidData");
        for (JSONObject userData : testUserDataList) {
            String jsonBody = objectMapper.writeValueAsString(Deposit.builder()
                    .accountNumber((String) userData.get("accountNumber"))
                    .amount(Double.valueOf((String) userData.get("amount")))
                    .currency((String) userData.get("currency")).build());

            Deposit model = deposit(HttpStatus.SC_PARTIAL_CONTENT, jsonBody);
            Assert.assertNotNull(model, "Deposit partial content error failed");
        }
    }

    @Test(priority = 1, description = "Validate withdraw with a valid request")
    public static void tc12_ValidateWithdrawWithValidRequest() throws JsonProcessingException {

        testUserDataList = readTestDataToList("TestWithdrawData");
        for (JSONObject userData : testUserDataList) {
            String jsonBody = objectMapper.writeValueAsString(Withdraw.builder()
                    .accountNumber((String) userData.get("accountNumber"))
                    .amount(Double.valueOf((String) userData.get("amount")))
                    .currency((String) userData.get("currency")).build());

            Deposit model = deposit(HttpStatus.SC_CREATED, jsonBody);
            Assert.assertNotNull(model, "Withdraw failed with valid request");
            Assert.assertEquals(model.getAccountNumber(), (String) userData.get("accountNumber"), "Incorrect withdraw account number");
            Assert.assertEquals(model.getAmount(), (String) userData.get("amount"), "Incorrect withdraw amount");
            Assert.assertEquals(model.getCurrency(), (String) userData.get("currency"), "Incorrect withdraw currency");
        }
    }

    @Test(priority = 1, description = "Validate withdraw with an unauthorized request")
    public static void tc16_ValidateWithdrawWithInvalidRequest() throws JsonProcessingException {

        testUserDataList = readTestDataToList("TestWithdrawInvalidData");
        for (JSONObject userData : testUserDataList) {
            String jsonBody = objectMapper.writeValueAsString(Withdraw.builder()
                    .accountNumber((String) userData.get("accountNumber"))
                    .amount(Double.valueOf((String) userData.get("amount")))
                    .currency((String) userData.get("currency")).build());

            Deposit model = deposit(HttpStatus.SC_CREATED, jsonBody);
            Assert.assertNotNull(model, "Withdraw with unauthorized error failed");
        }
    }

    @Test(priority = 1, description = "Validate get balance with a valid request")
    public static void tc17_ValidateGetBalanceWithValidRequest() throws JsonProcessingException {

        testUserDataList = readTestDataToList("TestBalanceData");
        for (JSONObject userData : testUserDataList) {
            String jsonBody = objectMapper.writeValueAsString(GetBalance.builder()
                    .accountNumber((String) userData.get("accountNumber"))
                    .balance(Double.valueOf((String) userData.get("balance")))
                    .limit(Double.valueOf(((String) userData.get("limit"))))
                    .currency((String) userData.get("currency")).build());

            GetBalance model = getBalance(HttpStatus.SC_OK);
            Assert.assertNotNull(model, "Get balance failed with valid request");
            Assert.assertEquals(model.getAccountNumber(), ((String) userData.get("accountNumber")), "Incorrect account number to check balance");
            Assert.assertEquals(model.getBalance(), (String) userData.get("balance"), "Incorrect balance amount");
            Assert.assertEquals(model.getLimit(), (String) userData.get("limit"), "Incorrect limit amount");
            Assert.assertEquals(model.getCurrency(), (String) userData.get("currency"), "Incorrect balance currency");
        }
    }

    @Test(priority = 1, description = "Validate get balance with a invalid request - no content")
    public static void tc22_ValidateGetBalanceWithInValidRequest() throws JsonProcessingException {

        testUserDataList = readTestDataToList("TestBalanceInvalidData");
        for (JSONObject userData : testUserDataList) {
            String jsonBody = objectMapper.writeValueAsString(GetBalance.builder()
                    .accountNumber((String) userData.get("accountNumber"))
                    .balance(Double.valueOf((String) userData.get("balance")))
                    .limit(Double.valueOf(((String) userData.get("limit"))))
                    .currency((String) userData.get("currency")).build());

            GetBalance model = getBalance(HttpStatus.SC_NO_CONTENT);
            Assert.assertNotNull(model, "Get balance with no content error failed");
            Assert.assertEquals(model.getAccountNumber(), ((String) userData.get("accountNumber")), "Incorrect account number to check balance");
            Assert.assertEquals(model.getBalance(), (String) userData.get("balance"), "Incorrect balance amount");
            Assert.assertEquals(model.getLimit(), (String) userData.get("limit"), "Incorrect limit amount");
            Assert.assertEquals(model.getCurrency(), (String) userData.get("currency"), "Incorrect balance currency");
        }
    }

    @Test(priority = 1, description = "Validate send with a valid request")
    public static void tc23_ValidateSendWithValidRequest() throws JsonProcessingException {

        testUserDataList = readTestDataToList("TestSendData");
        for (JSONObject userData : testUserDataList) {
            String jsonBody = objectMapper.writeValueAsString(Send.builder()
                    .sendAccountNumber((String) userData.get("sendAccountNumber"))
                    .receiveAccountNumber((String) userData.get("receiveAccountNumber"))
                    .amount(Double.valueOf((String) userData.get("amount")))
                    .currency((String) userData.get("currency")).build());

            Send model = send(HttpStatus.SC_OK, jsonBody);
            Assert.assertNotNull(model, "Send failed with valid request");
            Assert.assertEquals(model.getSendAccountNumber(), (String) userData.get("sendAccountNumber"), "Incorrect sender account number");
            Assert.assertEquals(model.getReceiveAccountNumber(), (String) userData.get("receiveAccountNumber"), "Incorrect receiver account number");
            Assert.assertEquals(model.getAmount(), (String) userData.get("amount"), "Incorrect send amount");
            Assert.assertEquals(model.getCurrency(), (String) userData.get("currency"), "Incorrect send currency");

        }
    }

}
