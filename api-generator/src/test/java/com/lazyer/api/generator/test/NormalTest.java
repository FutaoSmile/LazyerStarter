package com.lazyer.api.generator.test;

import com.lazyer.api.generator.model.ApiInfo;
import com.lazyer.api.generator.service.ApiGenerator;
import org.junit.Test;

/**
 * @author futao
 * Created on 2019-05-22.
 */
public class NormalTest {

    @Test
    public void test() {
        ApiInfo gen = ApiGenerator.SwaggerGenerator.gen("./666.md", "http://localhost:8887/v2/api-docs", "admin", "admin");
        System.out.println(gen);
    }
}
