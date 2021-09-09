package io.github.shyrkaio.test;

import io.fabric8.kubernetes.api.model.Namespaced;
import io.fabric8.kubernetes.client.CustomResource;
import io.fabric8.kubernetes.model.annotation.Group;
import io.fabric8.kubernetes.model.annotation.Kind;
import io.fabric8.kubernetes.model.annotation.Plural;
import io.fabric8.kubernetes.model.annotation.Version;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Group("io.github.shyrkaio.test")
@Version("v1")
@Kind("MyOtherCRD")
@Plural("MyOtherCRDs")
@JsonInclude(Include.NON_NULL)

public class MyOtherCRD extends CustomResource<MyOtherCRDSpec, MyOtherCRDStatus> implements Namespaced {
        private String sample;

        public String getSample() {
                return sample;
        }

        public void setSample(String sample) {
                this.sample = sample;
        }

}