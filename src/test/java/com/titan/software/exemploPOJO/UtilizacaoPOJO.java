package com.titan.software.exemploPOJO;

import com.google.gson.Gson;

public class UtilizacaoPOJO {
    public static void main(String [] args){

        String userPass = "{\"client_id\" : \"5e7fd0c879c2f934ae3c02afa1f83f0f\", " +
                "\"client_secret\" : \"827ccb0eea8a706c4c34a16891f84e7b\"}";

        User user = new User();
        //Deserelização
        Gson gson = new Gson();
        user = gson.fromJson(userPass, User.class);

        System.out.println("Seu nome de usuário: " + user.getClient_id());
        System.out.println("Sua senha é: " + user.getClient_secret());

        //Serelização

        user.setClient_id("Adriano");
        user.setClient_secret("DripVieira");

        String json = gson.toJson(user);

        System.out.println("Json pronto: " + json);

    }


}
