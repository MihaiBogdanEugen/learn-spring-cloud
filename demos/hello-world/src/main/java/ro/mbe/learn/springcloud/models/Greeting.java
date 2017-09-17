package ro.mbe.learn.springcloud.models;

public class Greeting {

    private long id;
    private String content;

    public Greeting() {

    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }


    public void sedId(long id) {
        this.id = id;
    }

    public void setContent() {
        this.content = content;
    }
}
