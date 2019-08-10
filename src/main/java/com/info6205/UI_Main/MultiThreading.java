package com.info6205.UI_Main;

import javax.swing.*;
import java.io.IOException;

class MultiThreading implements Runnable {
    public void run(){
        try {
            NewJFrame x = new NewJFrame();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}