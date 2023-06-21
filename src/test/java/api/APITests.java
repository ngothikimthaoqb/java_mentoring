package api;

import api.core.BaseAPI;
import api.model.User;
import api.utils.Constant;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.hc.core5.http.HttpStatus;
import org.testng.Assert;

import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class APITests {
    @Test
    public void verifyHttpStatusCode() throws IOException, URISyntaxException {
        Response res = BaseAPI.get(Constant.GET_USER_PATH);
        Assert.assertEquals(res.statusCode(), HttpStatus.SC_SUCCESS);
    }

    @Test
    public void verifyHttpResponseHeader() throws IOException, URISyntaxException {
        Response res = BaseAPI.get(Constant.GET_USER_PATH);
        Headers allHeaders = res.headers();
        String contentType= "Content-Type";
        boolean isContentTypeExist = false;

        for(Header header : allHeaders) {
            if(header.getName().contains(contentType)) {
                isContentTypeExist= true;
            }
        }
        Assert.assertTrue(isContentTypeExist);
        Assert.assertEquals(res.header("Content-Type") , Constant.CONTENT_TYPE);
    }

    @Test
    public void verifyHttpResponseBody() throws IOException, URISyntaxException {
        //Deserialization convert string to object
        // Serialization convert object to string
        Response res = BaseAPI.get(Constant.GET_USER_PATH);
        ObjectMapper mapper = new ObjectMapper();
        List<User> actualUsers = mapper.readValue(res.getBody().asString(), mapper.getTypeFactory().constructCollectionType(List.class, User.class));
        URL testDataPath = getClass().getClassLoader().getResource("testdata.json");
        List<User> expectedUsers = mapper.readValue(new File(testDataPath.toURI()), mapper.getTypeFactory().constructCollectionType(List.class, User.class));

        for (int i=0; i < actualUsers.size(); i++) {
            Assert.assertEquals(expectedUsers.get(i).getid(), actualUsers.get(i).getid());
            Assert.assertEquals(expectedUsers.get(i).getname(), actualUsers.get(i).getname());
            Assert.assertEquals(expectedUsers.get(i).getemail(), actualUsers.get(i).getemail());
        }
    }
}
