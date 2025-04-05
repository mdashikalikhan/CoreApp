package com.interview.message;

import java.util.*;

public class MessageProcessor {

    public static void main(String[] args) {
        List<Message> messages1 = Arrays.asList(
                new Message(2, "BOARD"),
                new Message(5, "ABC"),
                new Message(3, "DEF"),
                new Message(4, "HI")
        );

        System.out.println(processMessage(messages1));

        List<Message> messages2 = Arrays.asList(
                new Message(1, "BOARD"),
                new Message(4, "ABC"),
                new Message(2, "HI"),
                new Message(5, "BD")
        );
        System.out.println(processMessage(messages2));


    }

    public static String processMessage(List<Message> messages){
        if(messages==null || messages.isEmpty()){
            return "";
        }
        List<Integer> sequences = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();

        for(Message msg : messages){
            sequences.add(msg.getSeq());
            map.put(msg.getSeq(), msg.getText());
        }

        Collections.sort(sequences);

        int minSeq = sequences.get(0);

        int maxSeq = sequences.get(sequences.size()-1);

        for(int i=minSeq; i<=maxSeq; i++){
            if(!map.containsKey(i)){
                return "MISSING sequence " + i;
            }
        }

        StringBuilder result = new StringBuilder();

        for(int i=minSeq; i<=maxSeq; i++){
            result.append(map.get(i));
        }

        return result.toString();

     }
}

class Message{
    private Integer seq;
    private String text;

    public Message(Integer seq, String text){
        this.seq = seq;
        this.text = text;
    }

    public Integer getSeq() {
        return seq;
    }

    public String getText() {
        return text;
    }
}
