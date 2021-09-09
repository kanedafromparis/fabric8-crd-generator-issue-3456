package io.github.shyrkaio.test;

import io.fabric8.kubernetes.client.*;
import io.javaoperatorsdk.operator.Operator;
import io.javaoperatorsdk.operator.config.runtime.DefaultConfigurationService;
import org.junit.*;


public class MyOtherCRDIT {


    final static String TEST_NS = "MyOtherCRD-test";

    @Test
    public void test() {

        Config config = new ConfigBuilder().withNamespace(TEST_NS).build();
        KubernetesClient client = new DefaultKubernetesClient(config);

        Operator operator = new Operator(client, DefaultConfigurationService.instance());
        operator.register(new MyOtherCRDController(client));
        
        Assert.assertSame("foo","foo");
    }

}