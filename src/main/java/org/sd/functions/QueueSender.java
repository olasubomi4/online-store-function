//package org.sd.functions;
//
//import com.azure.storage.queue.QueueClient;
//import com.azure.storage.queue.QueueClientBuilder;
//import com.azure.storage.queue.models.SendMessageResult;
//
//public class QueueSender {
//    public static void main(String[] args) {
//        String queueName = "orders";
//
//        QueueClient queueClient = new QueueClientBuilder()
//                .connectionString(connectionString)
//                .queueName(queueName)
//                .buildClient();
//
////        // Create the queue if it doesn't exist
////        queueClient.createIfNotExists();
//
//        String message = "Hello from Java!";
//
//        SendMessageResult s= queueClient.sendMessage(message);
//
//        System.out.println("Sent message: " + message);
//    }
//}