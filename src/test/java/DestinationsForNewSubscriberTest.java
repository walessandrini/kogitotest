/*
 * Copyright 2021 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.cisco.KogitoTestApplication;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = KogitoTestApplication.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD) // reset spring context after each test method
public class DestinationsForNewSubscriberTest {

    @LocalServerPort
    private int port;

    @Test
    public void testDestinationsForNewSubscriber() {
        RestAssured.port = port;
        given()
               .body("{\n" +
                     "    \"CurrentDate\": \"2024-08-07\",\n" +
                     "    \"SubcriberAddedEvent\": {\n" +
                     "        \"createdOn\": 100,\n" +
                     "        \"newSubscriber\": {\n" +
                     "            \"brandId\": \"TF\",\n" +
                     "            \"mdn\": \"1234\",\n" +
                     "            \"baseOffer\": {\n" +
                     "                \"timeToLive\": \"2024-08-07\",\n" +
                     "                \"futureTimeToLive\": \"2024-08-07\",\n" +
                     "             }\n" +
                     "         }\n" +
                     "    }\n" +
                     "}")
               .contentType(ContentType.JSON)
          .when()
               .post("/DestinationsForNewSubscriber")
          .then()
             .statusCode(200)
               .body("'Should the driver be suspended?'", is("No"));
    }
}