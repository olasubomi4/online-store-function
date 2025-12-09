package org.sd.functions;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;
import org.sd.ConfigManager;
import org.sd.data.Database;
import org.sd.dto.OrderMessage;

import javax.xml.crypto.Data;

/**
 * Azure Functions with Azure Storage Queue trigger.
 */
public class QueueTriggerJava {
    /**
     * This function will be invoked when a new message is received at the specified path. The message contents are provided as input to this function.
     */
    private static final ObjectMapper objectMapper = new ObjectMapper();

    @FunctionName("online-store")
    public void run(
        @QueueTrigger(name = "message", queueName = "orders", connection = "AZURE_STORAGE") String message,
        final ExecutionContext context
    ) {

        context.getLogger().info("Java Queue trigger function processed a message: " + message);
        try {

            OrderMessage order = objectMapper.readValue(message, OrderMessage.class);

            if (order.getId() == null) {
                context.getLogger().warning("Order ID is null – cannot update database");
                return;
            }

            Database database= new Database(new ConfigManager());
            database.updateOrderStatus(order.getId(), context);

        } catch (Exception e) {
            context.getLogger().severe("Error processing message: " + e.getMessage());
        }
    }
}
