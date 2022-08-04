/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class MessagePrinterClient {

  public static void main(String[] args) {
    // TODO: create two instances of your thread subclass and start them up

    // Run a thread without a reference
    new MessagePrinter("taking a cat nap", 250).start();

    // With a reference
    Thread heavySleeper = new MessagePrinter("sleeping soundly", 1000);
    heavySleeper.start();

  }
}