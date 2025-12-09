//package org.sd.functions;
//
//import com.azure.storage.queue.QueueClient;
//import com.azure.storage.queue.QueueClientBuilder;
//import com.azure.storage.queue.models.SendMessageResult;
//import org.sd.dto.OrderMessage;
//
//import java.nio.charset.StandardCharsets;
//import java.util.Base64;
//
//public class QueueSender {
//    public static void main(String[] args) {

//        String queueName = "orders";
//        QueueClient queueClient = new QueueClientBuilder()
//                .connectionString(connectionString)
//                .queueName(queueName)
//                .buildClient();
//
////        // Create the queue if it doesn't exist
////        queueClient.createIfNotExists();
//        OrderMessage orderMessage = OrderMessage.builder().id(123456789L).status("Pending").build();
//        String message = Base64.getEncoder().encodeToString("Java code test7".getBytes(StandardCharsets.UTF_8));
//
//        SendMessageResult s= queueClient.sendMessage(message);
//
//        System.out.println("Sent message: " + message);
//    }
//}