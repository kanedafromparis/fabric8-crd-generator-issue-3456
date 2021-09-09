# fabric8-crd-generator-issue-3456
This is a simple sample that would help into the [kubernetes-client issue 3456](https://github.com/fabric8io/kubernetes-client/issues/3456)

## with 5.7.3

`mvn clean package` will produce BUILD FAILURE because Fatal error compiling: java.lang.NoClassDefFoundError: io/fabric8/kubernetes/client/utils/Pluralize

## with 5.2.0

`git checkout v5.2.0 && mvn clean package` will build and create `target/classes/META-INF/fabric8/myothercrds.io.github.shyrkaio.test-v1beta1.yml` and `target/classes/META-INF/fabric8/myothercrds.io.github.shyrkaio.test-v1.yml`

