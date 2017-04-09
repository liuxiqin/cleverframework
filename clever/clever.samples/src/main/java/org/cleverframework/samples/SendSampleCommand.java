package org.cleverframework.samples;

import org.cleverframework.Infrastructure.serializes.BinarySerializer;
import org.cleverframework.Infrastructure.serializes.BinarySerializerImpl;
import org.cleverframework.commands.Command;

import java.util.Date;
import java.util.UUID;


/**
 * Created by Administrator on 2017-04-03 .
 */
public class SendSampleCommand extends Command {


    private String sendSampleId;

    private Date now;

    public SendSampleCommand(String uuid) {
        super(uuid);
        now = new Date();
        sendSampleId="中文测试";
    }

    @Override
    public String toString() {
        return "SendSampleCommand{" +
                "sendSampleId='" + sendSampleId + '\'' +
                ", now=" + now +
                '}';
    }

    public static void main(String[] args) throws Exception{

        Command sampleCommand = new SendSampleCommand(UUID.randomUUID().toString());

        BinarySerializer binarySerializer = new BinarySerializerImpl();

        byte[] serBytes = binarySerializer.serialize(sampleCommand);

        Command seredCommand = binarySerializer.deSerialize(serBytes);

        System.out.println(seredCommand);

    }
}
