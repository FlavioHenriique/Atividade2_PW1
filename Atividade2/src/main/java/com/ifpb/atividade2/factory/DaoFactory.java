package com.ifpb.atividade2.factory;

public class DaoFactory {

    public static DaoFactoryIF createFactory() {
        return new DaoFactoryBD();
    }
}
