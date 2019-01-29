package com.demo.helloticket.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import com.demo.helloticket.skyscannerv2.Carrier;
import com.demo.helloticket.skyscanner.service.SkyscannerService;
import com.demo.helloticket.skyscannerv2.Quote;
import com.demo.helloticket.skyscannerv2.SkyscannerResponseV2;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.exceptions.UnirestException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import ai.active.fulfillment.webhook.WebhookUtil;
import ai.active.fulfillment.webhook.data.request.MorfeusWebhookRequest;
import ai.active.fulfillment.webhook.data.request.NlpV1;
import ai.active.fulfillment.webhook.data.response.Button;
import ai.active.fulfillment.webhook.data.response.CarouselMessage;
import ai.active.fulfillment.webhook.data.response.Content;
import ai.active.fulfillment.webhook.data.response.MorfeusWebhookResponse;
import ai.active.fulfillment.webhook.data.response.Status;
import ai.active.fulfillment.webhook.data.response.TextMessage;
import ai.active.fulfillment.webhook.data.response.WorkflowPipelineResponse;
import ai.active.fulfillment.webhook.data.response.WorkflowValidationResponse;
import ai.active.fulfillment.webhook.data.response.WorkflowValidationResponse.Builder;

@RestController
public class HelloTicketController {

  private static final String SECRET = "secret";
  private static final String SIG_MISMATCH = "Signature mismatch";
  private static final Logger LOGGER = LoggerFactory.getLogger(HelloTicketController.class);

  @Autowired
  private SkyscannerService skyscannerService;

  @PostMapping(path = "/profile", consumes = "application/json", produces = "application/json")
  public ProfileResponse profile(@RequestBody(required = true) String body,
      @RequestHeader(name = "X-Hub-Signature", required = true) String signature, HttpServletResponse response) throws Exception {
    LOGGER.debug(body);
    if (!WebhookUtil.generateSignature(body, SECRET).equals(signature)) {
      throw new Exception(SIG_MISMATCH);
    }
    return new ProfileResponse("dasd");
  }

  @PostMapping(path = "/default", consumes = "application/json", produces = "application/json")
  public MorfeusWebhookResponse defaultMapping(@RequestBody(required = true) String body,
      @RequestHeader(name = "X-Hub-Signature", required = true) String signature, HttpServletResponse response) throws Exception {
    LOGGER.debug(body);
    if (!WebhookUtil.generateSignature(body, SECRET).equals(signature)) {
      throw new Exception(SIG_MISMATCH);
    }
    MorfeusWebhookResponse messageWrapper = new MorfeusWebhookResponse();
    TextMessage textMessage = new TextMessage();
    textMessage.setContent("I am still learning. I can handle flight status and flight lookup!");
    textMessage.setType("text");
    messageWrapper.setMessages(Arrays.asList(textMessage));
    messageWrapper.setExpectedEntities(Arrays.asList("NONE"));
    return messageWrapper;
  }

  @PostMapping(path = "/checkstatus", consumes = "application/json", produces = "application/json")
  public MorfeusWebhookResponse handlecmm(@RequestBody(required = true) String body,
      @RequestHeader(name = "X-Hub-Signature", required = true) String signature, HttpServletResponse response) throws Exception {
    LOGGER.debug(body);
    if (!WebhookUtil.generateSignature(body, SECRET).equals(signature)) {
      throw new Exception(SIG_MISMATCH);
    }
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    MorfeusWebhookRequest request = objectMapper.readValue(body, MorfeusWebhookRequest.class);
    MorfeusWebhookResponse messageWrapper = new MorfeusWebhookResponse();
    TextMessage textMessage = new TextMessage();
    textMessage
        .setContent("Please check https://www.google.com/search?q=" + request.getWorkflowParams().getWorkflowVariables().get("flight_no"));
    textMessage.setType("text");
    messageWrapper.setMessages(Arrays.asList(textMessage));
    messageWrapper.setExpectedEntities(Arrays.asList("NONE"));
    return messageWrapper;
  }

  @PostMapping(path = "/flightoptions", consumes = "application/json", produces = "application/json")
  public MorfeusWebhookResponse flightoptions(@RequestBody(required = true) String body,
      @RequestHeader(name = "X-Hub-Signature", required = true) String signature, HttpServletResponse response) throws Exception {
    LOGGER.debug(body);
    if (!WebhookUtil.generateSignature(body, SECRET).equals(signature)) {
      throw new Exception(SIG_MISMATCH);
    }
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    MorfeusWebhookRequest request = objectMapper.readValue(body, MorfeusWebhookRequest.class);

    String source = request.getWorkflowParams().getWorkflowVariables().get("sourcePlaceId");
    String destination = request.getWorkflowParams().getWorkflowVariables().get("destinationPlaceId");

    String seatCategory = request.getWorkflowParams().getWorkflowVariables().get("seat_category");
    String travelDate = request.getWorkflowParams().getWorkflowVariables().get("travel_date");

    SkyscannerResponseV2 skyscannerResponseV2;
    try {
      skyscannerResponseV2 = skyscannerService.getSkyscannerResponseV2(source, destination, seatCategory, travelDate);
    } catch (UnirestException e) {
      MorfeusWebhookResponse messageWrapper = new MorfeusWebhookResponse();
      TextMessage errorTextMessage = new TextMessage();
      errorTextMessage.setContent("Some issue while calling Skyscanner API");
      errorTextMessage.setType("text");
      messageWrapper.setMessages(Arrays.asList(errorTextMessage));
      messageWrapper.setExpectedEntities(Arrays.asList("NONE"));
      return messageWrapper;
    }

    ArrayList<Content> contents = new ArrayList<>();
    for (Quote itinerary : skyscannerResponseV2.getQuotes()) {
      Content content = new Content();
      content.setSubtitle("$" + itinerary.getMinPrice());
      Carrier carrier = skyscannerResponseV2.get(String.valueOf(itinerary.getOutboundLeg().getCarrierIds().get(0)), Carrier.class);
      content.setTitle(carrier.getName());
      Button button1 = new Button();
      button1.setTitle("Done");
      button1.setType("postback");
      button1.setPayload("{\"data\":{\"flight\":\"abc\"},\"intent\":\"book-ticket\"}");
      content.setButtons(Arrays.asList(button1));
      contents.add(content);
    }
    MorfeusWebhookResponse messageWrapper = new MorfeusWebhookResponse();
    CarouselMessage carouselMessage = new CarouselMessage();
    carouselMessage.setType("carousel");
    carouselMessage.setContent(contents);
    TextMessage message2 = new TextMessage();
    message2.setType("text");
    message2.setContent("Here are few options what I found:");
    messageWrapper.setMessages(Arrays.asList(message2, carouselMessage));
    messageWrapper.setExpectedEntities(Arrays.asList("NONE"));
    return messageWrapper;
  }

  @PostMapping(path = "/validatesource", consumes = "application/json", produces = "application/json")
  public MorfeusWebhookResponse validatesource(@RequestBody(required = true) String body,
      @RequestHeader(name = "X-Hub-Signature", required = true) String signature, HttpServletResponse response) throws Exception {
    LOGGER.debug(body);
    if (!WebhookUtil.generateSignature(body, SECRET).equals(signature)) {
      throw new Exception(SIG_MISMATCH);
    }
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    MorfeusWebhookRequest request = objectMapper.readValue(body, MorfeusWebhookRequest.class);
    NlpV1 nlp = (NlpV1) request.getNlp();
    String source;
    if (nlp != null && nlp.getData() != null && nlp.getData().has("entities") && nlp.getData().get("entities").has("book_ticket.source")) {
      source = nlp.getData().get("entities").get("book_ticket.source").elements().next().get("value").asText();
    } else if (request.getWorkflowParams().getRequestVariables().containsKey("source")) {
      source = request.getWorkflowParams().getRequestVariables().get("source");
    } else {
      source = request.getWorkflowParams().getRequestVariables().get("sys.place:from");
    }
    WorkflowValidationResponse validationResponse;
    if (StringUtils.isEmpty(source)) {
      TextMessage message2 = new TextMessage();
      message2.setType("text");
      message2.setContent("Please be more specific, from where you wants to take the flight?");
      validationResponse = new WorkflowValidationResponse.Builder(Status.FAILED).setMessages(Arrays.asList(message2)).build();
    } else {
      String placeId = skyscannerService.getPlaceId(source);
      if (placeId != null) {
        HashMap<String, String> hashMap = new HashMap<>(1);
        hashMap.put("sourcePlaceId", placeId);
        validationResponse = new WorkflowValidationResponse.Builder(Status.SUCCESS).setWorkflowVariables(hashMap).build();
      } else {
        TextMessage message2 = new TextMessage();
        message2.setType("text");
        message2.setContent(
            "Not able to locate any airports with " + source + ". Please be more specific, from where you wants to take the flight?");
        validationResponse = new WorkflowValidationResponse.Builder(Status.FAILED).setMessages(Arrays.asList(message2)).build();
      }
    }
    return validationResponse;
  }

  @PostMapping(path = "/validatedestination", consumes = "application/json", produces = "application/json")
  public MorfeusWebhookResponse validatedestination(@RequestBody(required = true) String body,
      @RequestHeader(name = "X-Hub-Signature", required = true) String signature, HttpServletResponse response) throws Exception {
    LOGGER.debug(body);
    if (!WebhookUtil.generateSignature(body, SECRET).equals(signature)) {
      throw new Exception(SIG_MISMATCH);
    }
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    MorfeusWebhookRequest request = objectMapper.readValue(body, MorfeusWebhookRequest.class);
    NlpV1 nlp = (NlpV1) request.getNlp();
    String destination;
    if (nlp != null && nlp.getData() != null && nlp.getData().has("entities")
        && nlp.getData().get("entities").has("book_ticket.destination")) {
      destination = nlp.getData().get("entities").get("book_ticket.destination").elements().next().get("value").asText();
    } else if (request.getWorkflowParams().getRequestVariables().containsKey("destination")) {
      destination = request.getWorkflowParams().getRequestVariables().get("destination");
    } else {
      destination = request.getWorkflowParams().getRequestVariables().get("sys.place:to");
    }
    WorkflowValidationResponse validationResponse;
    if (StringUtils.isEmpty(destination)) {
      TextMessage message2 = new TextMessage();
      message2.setType("text");
      message2.setContent("Please be more specific, what's your destination?");
      validationResponse = new WorkflowValidationResponse.Builder(Status.FAILED).setMessages(Arrays.asList(message2)).build();
    } else {
      String placeId = skyscannerService.getPlaceId(destination);
      if (placeId != null) {
        if (placeId.equals(request.getWorkflowParams().getWorkflowVariables().get("sourcePlaceId"))) {
          TextMessage message2 = new TextMessage();
          message2.setType("text");
          message2.setContent("Source and destination could not be same! Please update what's your destination?");
          validationResponse = new WorkflowValidationResponse.Builder(Status.FAILED).setMessages(Arrays.asList(message2)).build();
        } else {
          HashMap<String, String> hashMap = new HashMap<>(1);
          hashMap.put("destinationPlaceId", placeId);
          Builder workflowValidationResponseBuilder = new WorkflowValidationResponse.Builder(Status.SUCCESS).setWorkflowVariables(hashMap);
          if (!request.getWorkflowParams().getWorkflowVariables().containsKey("destinationPlaceId")) {
            TextMessage message2 = new TextMessage();
            message2.setType("text");
            message2.setContent("That's a wonderful place. Let me know later if you like to know weather details.");
            workflowValidationResponseBuilder.setMessages(Arrays.asList(message2));
          }
          validationResponse = workflowValidationResponseBuilder.build();
        }
      } else {
        TextMessage message2 = new TextMessage();
        message2.setType("text");
        message2.setContent("Not able to locate any airports with " + destination + ". Please be more specific, what's your destination?");
        validationResponse = new WorkflowValidationResponse.Builder(Status.FAILED).setMessages(Arrays.asList(message2)).build();
      }
    }
    return validationResponse;
  }

  @PostMapping(path = "/destinationPrompt", consumes = "application/json", produces = "application/json")
  public MorfeusWebhookResponse destinationPrompt(@RequestBody(required = true) String body,
      @RequestHeader(name = "X-Hub-Signature", required = true) String signature, HttpServletResponse response) throws Exception {
    LOGGER.debug(body);
    if (!WebhookUtil.generateSignature(body, SECRET).equals(signature)) {
      throw new Exception(SIG_MISMATCH);
    }
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    MorfeusWebhookRequest request = objectMapper.readValue(body, MorfeusWebhookRequest.class);

    String source = request.getWorkflowParams().getWorkflowVariables().get("sourcePlaceId");

    if (source != null && source.equals("HYD-sky")) {
      WorkflowPipelineResponse messageWrapper = new WorkflowPipelineResponse.Builder(Status.SUCCESS).build();
      TextMessage errorTextMessage = new TextMessage();
      errorTextMessage.setContent("There is only one flight from Hyderabad, which is to Bangalore.");
      errorTextMessage.setType("text");
      HashMap<String, Object> extraData = new HashMap<>();
      // extraData.put("goto", "FromDate");
      // extraData.put("gotoType", "node");
      extraData.put("gotoLinktype", "SKIP");
      HashMap<String, String> entities = new HashMap<>();
      entities.put("sys.place:to", "Bangalore");
      extraData.put("ENTITIES", entities);
      messageWrapper.setExtraData(extraData);
      // HashMap<String, String> hashMap = new HashMap<>(1);
      // hashMap.put("destinationPlaceId", "BNG-sky");
      // messageWrapper.setWorkflowVariables(hashMap);
      messageWrapper.setMessages(Arrays.asList(errorTextMessage));
      messageWrapper.setExpectedEntities(Arrays.asList("NONE"));
      return messageWrapper;
    }

    MorfeusWebhookResponse messageWrapper = new MorfeusWebhookResponse();
    messageWrapper.setStatus(Status.SUCCESS);
    TextMessage message2 = new TextMessage();
    message2.setType("text");
    message2.setContent("Where are you travelling to?");
    messageWrapper.setMessages(Arrays.asList(message2));
    messageWrapper.setExpectedEntities(Arrays.asList("NONE"));
    return messageWrapper;
  }

}
