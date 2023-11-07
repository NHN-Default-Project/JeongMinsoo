package org.thread.chapter7.quiz01;


/**
 * 시간간격은 실행시 인수를 받는다.
 * <p>
 * 기본은 milliseconds 단위로 받고
 * <p>
 * 인수 마지막에 n이 붙은 경우 nanoseconds로 처리한다.
 * <p>
 * tick 사이의 시간 간격은 오차가 발생할 수 있다.
 * <p>
 * tick 오차가 발생하더라도 전체적인 시간의 흐름은 변경되어서는 안된다.
 * <p>
 * 예를 들어, 100ms ticker의 경우, 0, 101, 99, 100, 100, 99, 100, 101,…​
 */
public class Quiz01 {
    public static void main(String[] args) {
        Tick tick = new Tick();
        Ticker ticker = new Ticker(tick);
        ticker.start("1000");
    }
}
