package com.demo.helloticket.controller;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import ai.active.fulfillment.webhook.WebhookUtil;
import ai.active.fulfillment.webhook.data.request.MorfeusWebhookRequest;
import ai.active.fulfillment.webhook.data.response.CarouselMessage;
import ai.active.fulfillment.webhook.data.response.Content;
import ai.active.fulfillment.webhook.data.response.MorfeusWebhookResponse;
import ai.active.fulfillment.webhook.data.response.Status;
import ai.active.fulfillment.webhook.data.response.TextMessage;

@RestController
public class BlockCardController {

  private static final Logger LOGGER = LoggerFactory.getLogger(BlockCardController.class);

  @PostMapping(path = "/blockcard/confirmation", consumes = "application/json", produces = "application/json")
  public MorfeusWebhookResponse confirmationCall(@RequestBody(required = true) String body,
      @RequestHeader(name = "X-Hub-Signature", required = true) String signature, HttpServletResponse response) throws Exception {
    LOGGER.debug(body);
    if (!WebhookUtil.generateSignature(body, "secret").equals(signature)) {
      throw new Exception("Signature mismatch");
    }

    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    MorfeusWebhookRequest request = objectMapper.readValue(body, MorfeusWebhookRequest.class);

    String selectedCard = request.getWorkflowParams().getWorkflowVariables().get("banking_product_card_number_Card_Selection");
    String blockType = request.getWorkflowParams().getWorkflowVariables().get("banking_block_type_Block_Type_Selection");

    // String customerId = request.getUser().getId();

    CarouselMessage carouselMessage = new CarouselMessage();
    Content content = new Content();
    String actualTitle = "Your request to " + selectedCard + " Block card has been blocked successfully.";
    TextMessage textMessage = new TextMessage();
    textMessage.setType("text");
    if (blockType.equals("permanent")) {
      actualTitle = "Your request to permanently block card ending with " + selectedCard + " is successful.";
      textMessage.setContent("Let me know if you want to reissue a new card.");
    } else {
      String unblockDate = request.getWorkflowParams().getWorkflowVariables().getOrDefault("unblock_date", "30-01-2020");
      actualTitle = "Your request to temporarily block card ending with " + selectedCard + " is successful.";
      textMessage.setContent("Your card would be unblocked on " + unblockDate + ".");
    }
    String image = "";
    if (selectedCard.contains("5678")) {
      image = "https://image3.mouthshut.com/images/imagesp/925006383s.png";
    } else {
      image = "https://cards.jetprivilege.com/cards/HDFC-Jet-Privilege-World-DI-Card_final-24-10-17-011519069130907.jpg";
    }

    content.setTitle(actualTitle);
    content.setImage(image);
    List<Content> contents = new ArrayList<>();
    contents.add(content);
    carouselMessage.setContent(contents);
    carouselMessage.setType("carousel");
    MorfeusWebhookResponse messageWrapper = new MorfeusWebhookResponse();
    messageWrapper.setMessages(Arrays.asList(carouselMessage, textMessage));
    messageWrapper.setStatus(Status.SUCCESS);
    return messageWrapper;
  }

}
