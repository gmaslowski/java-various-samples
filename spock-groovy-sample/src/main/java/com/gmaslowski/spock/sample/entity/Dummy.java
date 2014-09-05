package com.gmaslowski.spock.sample.entity;

public class Dummy {

    private int id;
    private String name;
    private boolean active;

    private Dummy() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isActive() {
        return active;
    }

    public void deactivate() {
        active = false;
    }

    public static class DummyBuilder {
        private Dummy dummy;

        private DummyBuilder() {
            dummy = new Dummy();
        }

        public static DummyBuilder aDummy() {
            return new DummyBuilder();
        }

        public DummyBuilder id(int id) {
            dummy.id = id;
            return this;
        }

        public DummyBuilder name(String name) {
            dummy.name = name;
            return this;
        }

        public DummyBuilder active(boolean active) {
            dummy.active = active;
            return this;
        }

        public Dummy build() {
            return dummy;
        }
    }
}
