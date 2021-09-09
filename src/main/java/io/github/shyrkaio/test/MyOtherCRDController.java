package io.github.shyrkaio.test;

import io.fabric8.kubernetes.client.KubernetesClient;
import io.javaoperatorsdk.operator.api.*;
import io.javaoperatorsdk.operator.processing.event.EventSourceManager;
import io.javaoperatorsdk.operator.processing.event.internal.CustomResourceEvent;

import java.util.Optional;


@Controller
public class MyOtherCRDController implements ResourceController<MyOtherCRD> {
    // add spec there
    private final KubernetesClient kubernetesClient;

    public MyOtherCRDController(KubernetesClient client) {
        this.kubernetesClient = client;
      }
    
      @Override
      public void init(EventSourceManager eventSourceManager) {
        //eventSourceManager.registerEventSource("deployment-event-source", ...);
      }
    
      @Override
      public UpdateControl<MyOtherCRD> createOrUpdateResource(MyOtherCRD myothercrd, Context<MyOtherCRD> context) {
        Optional<CustomResourceEvent> latestCREvent =
            context.getEvents().getLatestOfType(CustomResourceEvent.class);
    
        return UpdateControl.noUpdate();
      }
    
      @Override
      public DeleteControl deleteResource(MyOtherCRD myothercrd, Context<MyOtherCRD> context) {        
        return DeleteControl.DEFAULT_DELETE;
      }

}