package org.kafkasparkeselastic;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;

public  class Producer {

    public static void main(String[] args) {

        String bootstrapServer = "localhost:9092";

        //using the properties to config kafka
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());



        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
        ProducerRecord<String,String> record= new ProducerRecord<String, String>("hello","world");
        producer.send(record);



        producer.flush();
        producer.close();

        /*
        The flush() call gives a convenient way to ensure all previously sent messages have actually completed
         */

    }
}
