package com.learn;

import java.util.Scanner;

import com.pubnub.api.Callback;
import com.pubnub.api.Pubnub;
import com.pubnub.api.PubnubError;

public class Sender {
	private static Pubnub pubnub = new Pubnub("pub-c-8b43c1f6-9f41-4c34-8033-a32f9c16ac36", "sub-c-f55ce1aa-4fcb-11e6-82fe-0619f8945a4f");

	public static void main(String[] args) {
		Callback callback = new Callback() {
			public void successCallback(String channel, Object response) {
//				System.out.println(response.toString());
				System.out.println("Message sent!");
			}
			public void errorCallback(String channel, PubnubError error) {
				System.out.println(error.toString());
			}
		};

		Scanner consoleReader = new Scanner(System.in);
		do{
			System.out.println("Please enter a message");
			String message = consoleReader.next();
//			System.out.println("Here is your message " + message);
			publish(message, callback);
		}while(consoleReader.hasNext());

	}

	static void publish(String msg, Callback callback)
	{
		pubnub.publish("my_channel", msg , callback);
	}

}
