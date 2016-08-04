package com.learn;


import com.pubnub.api.*;

import org.json.*;

public class Client {

	public static void main(String[] args) {
		Pubnub pubnub = new Pubnub("pub-c-8b43c1f6-9f41-4c34-8033-a32f9c16ac36", "sub-c-f55ce1aa-4fcb-11e6-82fe-0619f8945a4f");
		
		try {
			  pubnub.subscribe("my_channel", new Callback() {
			      @Override
			      public void connectCallback(String channel, Object message) {
//			          pubnub.publish("my_channel", (String)message, new Callback() {});
//			    	  System.out.println("I received " + message);
			      }
			 
			      @Override
			      public void disconnectCallback(String channel, Object message) {
			          System.out.println("SUBSCRIBE : DISCONNECT on channel:" + channel
			                     + " : " + message.getClass() + " : "
			                     + message.toString());
			      }
			 
			      public void reconnectCallback(String channel, Object message) {
			          System.out.println("SUBSCRIBE : RECONNECT on channel:" + channel
			                     + " : " + message.getClass() + " : "
			                     + message.toString());
			      }
			 
			      @Override
			      public void successCallback(String channel, Object message) {
//			          System.out.println("SUBSCRIBE : " + channel + " : "
//			                     + message.getClass() + " : " + message.toString());
			          
			          System.out.println("I received " + message.toString() + " of Type: " + message.getClass() + " on channel: "+ channel);
			      }
			 
			      @Override
			      public void errorCallback(String channel, PubnubError error) {
			          System.out.println("SUBSCRIBE : ERROR on channel " + channel
			                     + " : " + error.toString());
			      }
			    }
			  );
			} catch (PubnubException e) {
			  System.out.println(e.toString());
			}
		
		
	}

}
