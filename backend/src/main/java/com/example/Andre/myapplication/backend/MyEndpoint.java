/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.Andre.myapplication.backend;

import com.example.JokeTeller;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myapplication.Andre.example.com",
                ownerName = "backend.myapplication.Andre.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {
    @ApiMethod(name = "getJoke")
    public Joke getJoke() {
        Joke response = new Joke();
        response.setData(JokeTeller.tellJoke());
        return response;
    }

}
