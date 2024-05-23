//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.model;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Model_File_Receiver {
    private Model_Send_Message message;
    private File file;
    private RandomAccessFile accFile;

    public Model_Send_Message getMessage() {
        return this.message;
    }

    public void setMessage(Model_Send_Message message) {
        this.message = message;
    }

    public File getFile() {
        return this.file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public RandomAccessFile getAccFile() {
        return this.accFile;
    }

    public void setAccFile(RandomAccessFile accFile) {
        this.accFile = accFile;
    }

    public Model_File_Receiver(Model_Send_Message message, File file) throws IOException {
        this.message = message;
        this.file = file;
        this.accFile = new RandomAccessFile(file, "rw");
    }

    public Model_File_Receiver() {
    }

    public synchronized long writeFile(byte[] data) throws IOException {
        this.accFile.seek(this.accFile.length());
        this.accFile.write(data);
        return this.accFile.length();
    }

    public void close() throws IOException {
        this.accFile.close();
    }
}
