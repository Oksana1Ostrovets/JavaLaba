package lab2;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntitySerializer jsonSerializer = new JsonEntitySerializer();
        EntitySerializer xmlSerializer = new XmlEntitySerializer();
        EntitySerializer txtSerializer = new TxtEntitySerializer();

        try {
            jsonSerializer.serialize(List.of(new Bank.Builder().setName("Bank1").setLocation("Location1").build()), "bank.json");
            xmlSerializer.serialize(List.of(new Bank.Builder().setName("Bank2").setLocation("Location2").build()), "bank.xml");
            txtSerializer.serialize(List.of(new Bank.Builder().setName("Bank3").setLocation("Location3").build()), "bank.txt");
            List<Object> banksFromJson = jsonSerializer.deserialize("bank.json");
            List<Object> banksFromXml = xmlSerializer.deserialize("bank.xml");
            List<Object> banksFromTxt = txtSerializer.deserialize("bank.txt");

            for (Object bank : banksFromJson) {
                System.out.println(bank);
            }

            for (Object bank : banksFromXml) {
                System.out.println(bank);
            }

            for (Object bank : banksFromTxt) {
                System.out.println(bank);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
