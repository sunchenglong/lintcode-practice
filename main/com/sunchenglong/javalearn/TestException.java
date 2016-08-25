package com.sunchenglong.javalearn;

import java.io.IOException;

/**
 * Created by Chenglong Sun on 2016/8/25.
 */
public class TestException {
}
class Test extends Inning implements IStorm {

    public void event() {}

    public Test() throws BaseballException {
    }

    public void rainHard() throws RainedOutChild {

    }

    public void asBat() throws Strike{

    }
}

class BaseballException extends Exception {
}

class Foul extends BaseballException {
}

class Strike extends BaseballException {
}

class StormException extends Exception {
}

class RainedOut extends StormException {
}
class RainedOutChild extends RainedOut{}
class PopFoul extends Foul {
}

interface IStorm {
    public void event() throws RainedOut;
    public void rainHard() throws RainedOut;
}

abstract class Inning {
    public Inning() throws BaseballException{}

    public void event() throws BaseballException {

    }

    public abstract void asBat()throws Strike, Foul, BaseballException;
}