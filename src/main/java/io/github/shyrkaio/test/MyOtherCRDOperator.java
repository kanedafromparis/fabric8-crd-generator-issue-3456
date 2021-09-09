package io.github.shyrkaio.test;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.javaoperatorsdk.operator.Operator;
import io.javaoperatorsdk.operator.config.runtime.DefaultConfigurationService;
import org.takes.facets.fork.FkRegex;
import org.takes.facets.fork.TkFork;
import org.takes.http.Exit;
import org.takes.http.FtBasic;

import java.io.IOException;

public class MyOtherCRDOperator {

    public static void main(String[] args) throws IOException {

        Config config = new ConfigBuilder().withNamespace(null).build();
        KubernetesClient client = new DefaultKubernetesClient(config);
        Operator operator = new Operator(client, DefaultConfigurationService.instance());

        MyOtherCRDController myothercrdController = new MyOtherCRDController(client);
        operator.register(myothercrdController);

        new FtBasic(new TkFork(new FkRegex("/health", "ALL GOOD.")), 8080).start(Exit.NEVER);
    }
}