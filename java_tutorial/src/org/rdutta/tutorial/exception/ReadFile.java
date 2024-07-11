package org.rdutta.tutorial.exception;

import java.io.FileNotFoundException;

public class ReadFile {
    public void readFromSystem() throws FileNotFoundException {

        throw new FileNotFoundException("Your file not found in the system.");
    }


    public static void main(String[] args) throws FileNotFoundException {
        ReadFile readFile = new ReadFile();
        try{
            readFile.readFromSystem();
        }catch(FileNotFoundException e){
            System.out.println(e.getMessage());;
        }
    }
}
