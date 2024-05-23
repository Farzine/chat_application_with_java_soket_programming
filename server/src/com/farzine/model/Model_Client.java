//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.farzine.model;

import com.corundumstudio.socketio.SocketIOClient;

public class Model_Client {
    private SocketIOClient client;
    private Model_User_Account user;

    public SocketIOClient getClient() {
        return this.client;
    }

    public void setClient(SocketIOClient client) {
        this.client = client;
    }

    public Model_User_Account getUser() {
        return this.user;
    }

    public void setUser(Model_User_Account user) {
        this.user = user;
    }

    public Model_Client(SocketIOClient client, Model_User_Account user) {
        this.client = client;
        this.user = user;
    }

    public Model_Client() {
    }
}
