package com.test;

import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author cj
 * @date 2019/10/23
 */
public class SpringResourceTest {

    private Resource resource;
    private Resource[] resources;

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) throws IOException {

        System.out.println("-----debug: aResource = " + resource.getClass());
        System.out.println("-----debug: aResource.getInputStream() = " + resource.getInputStream());
        this.resource = resource;
    }

    public Resource[] getResources() {
        return resources;
    }

    public void setResources(Resource[] resources) throws IOException {
        System.out.println("-----debug: resources[0].getClass() = " + resources[0].getClass());
        System.out.println("-----debug: resources[0].getInputStream() = " + resources[0].getInputStream());
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "A{" +
                "resource=" + resource +
                ", resources=" + Arrays.toString(resources) +
                '}';
    }
}
