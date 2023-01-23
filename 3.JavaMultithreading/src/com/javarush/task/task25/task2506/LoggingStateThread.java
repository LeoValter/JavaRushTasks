package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {

    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        State currentState = thread.getState();
        System.out.println(currentState);

        do {
            State newState = thread.getState();
            if (!currentState.equals(newState)) {
                currentState = newState;
                System.out.println(currentState);
            }

        } while (!currentState.equals(State.TERMINATED));
    }
}
