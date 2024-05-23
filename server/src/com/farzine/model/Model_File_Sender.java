//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.model;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Model_File_Sender {
    private Model_File data;
    private File file;
    private RandomAccessFile accFile;
    private long fileSize;

    public Model_File getData() {
        return this.data;
    }

    public void setData(Model_File data) {
        this.data = data;
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

    public long getFileSize() {
        return this.fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public Model_File_Sender(Model_File data, File file) throws IOException {
        this.data = data;
        this.file = file;
        this.accFile = new RandomAccessFile(file, "r");
        this.fileSize = this.accFile.length();
    }

    public Model_File_Sender() {
    }

    public byte[] read(long currentLength) throws IOException {
        this.accFile.seek(currentLength);
        if (currentLength != this.fileSize) {
            int max = 2000;
            long length = currentLength + (long)max >= this.fileSize ? this.fileSize - currentLength : (long)max;
            byte[] b = new byte[(int)length];
            this.accFile.read(b);
            return b;
        } else {
            return null;
        }
    }
}
