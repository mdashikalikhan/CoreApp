package com.interview.test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.Serializable;
import java.net.NetworkInterface;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

public class Test {

    public static void main(String[] args) throws UnirestException {
        var list = Arrays.asList("", "abc", "def");

        String mobile="01777401985";
        System.out.println(mapping(list));
        String url = "https://corpsms.banglalink.net/bl/api/v1/smsapigw/";
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("username", "RBL_IB_APP");
        jsonBody.put("password", "Rup@li#321");
        jsonBody.put("apicode", "5");
        jsonBody.put("msisdn", new String[]{"01777401985"});
        jsonBody.put("countrycode", "880");
        jsonBody.put("cli", "8801971033333");
        jsonBody.put("messagetype", "1");
        jsonBody.put("message", "TEST RBL message");
        jsonBody.put("clienttransid", "rbibx"+UUIDSequenceGenerator.getInstance().nextId());
        jsonBody.put("bill_msisdn", "8801971033333");
        jsonBody.put("tran_type", "T");
        jsonBody.put("request_type", "S");
        jsonBody.put("rn_code", "91");

        try {
            // Send POST request
            HttpResponse<String> response = Unirest.post(url)
                    .header("Content-Type", "application/json")
                    .body(jsonBody.toString())
                    .asString();

            // Print response
            System.out.println("Status: " + response.getStatus());
            System.out.println("Response Body: " + response.getBody());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static List<String> mapping(List<String> list){
        return list.stream().map(s->s.toUpperCase()).toList();
    }
}

class UUIDSequenceGenerator implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final int UNUSED_BITS = 1; // Sign bit, Unused (always set to 0)
    private static final int EPOCH_BITS = 41;
    private static final int NODE_ID_BITS = 10;
    private static final int SEQUENCE_BITS = 12;

    private static final int maxNodeId = (int)(Math.pow(2, NODE_ID_BITS) - 1);
    private static final int maxSequence = (int)(Math.pow(2, SEQUENCE_BITS) - 1);

    // Custom Epoch (January 1, 2015 Midnight UTC = 2015-01-01T00:00:00Z)
    private static final long CUSTOM_EPOCH = 1420070400000L;

    private final int nodeId;

    private volatile long lastTimestamp = -1L;
    private volatile long sequence = 0L;

    private static UUIDSequenceGenerator instance = null;

    private UUIDSequenceGenerator() {
        this.nodeId = createNodeId();
    }

    public static UUIDSequenceGenerator getInstance() {
        if(instance==null) {
            instance = new UUIDSequenceGenerator();
        }
        return instance;
    }

    public synchronized long nextId() {
        long currentTimestamp = timestamp();

        if(currentTimestamp < lastTimestamp) {
            throw new IllegalStateException("Invalid System Clock!");
        }

        if (currentTimestamp == lastTimestamp) {
            sequence = (sequence + 1) & maxSequence;
            if(sequence == 0) {
                // Sequence Exhausted, wait till next millisecond.
                currentTimestamp = waitNextMillis(currentTimestamp);
            }
        } else {
            // reset sequence to start with zero for the next millisecond
            sequence = 0;
        }

        lastTimestamp = currentTimestamp;

        long id = currentTimestamp << (NODE_ID_BITS + SEQUENCE_BITS);
        id |= (nodeId << SEQUENCE_BITS);
        id |= sequence;

        return id;
    }


    // Get current timestamp in milliseconds, adjust for the custom epoch.
    private static long timestamp() {
        return Instant.now().toEpochMilli() - CUSTOM_EPOCH;
    }

    // Block and wait till next millisecond
    private long waitNextMillis(long currentTimestamp) {
        while (currentTimestamp == lastTimestamp) {
            currentTimestamp = timestamp();
        }
        return currentTimestamp;
    }



    private int createNodeId() {
        int nodeId;
        try {
            StringBuilder sb = new StringBuilder();
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                byte[] mac = networkInterface.getHardwareAddress();
                if (mac != null) {
                    for(int i = 0; i < mac.length; i++) {
                        sb.append(String.format("%02X", mac[i]));
                    }
                }
            }
            nodeId = sb.toString().hashCode();
        } catch (Exception ex) {
            nodeId = (new SecureRandom().nextInt());
        }
        nodeId = nodeId & maxNodeId;
        return nodeId;
    }

}
