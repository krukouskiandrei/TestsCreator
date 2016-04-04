package by.krukouski.testscreator.logic;

import by.krukouski.testscreator.subject.Test;

/**
 * Created by Krukouski Andrei on 02.01.2016.
 */
public class CreateLogic {

    public static Test createNewTest(String topic, String subject, Integer time){
        return new Test(subject, topic, Math.abs(time));
    }

}
