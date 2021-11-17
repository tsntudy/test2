package simpleCalc;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class simpleCalcTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final StandardInputSnatcher in = new StandardInputSnatcher();

    /*
     * 各メソッドを実行する前に実行される
     *
     * 標準入出力を割り当てる
     */
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        System.setIn(in);
    }

    /*
     * 各メソッドを実行した後に実行される
     *
     * 標準入出力を割り当てしなおす
     */
    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
        System.setErr(System.err);
        System.setIn(System.in);
    }

    @Test
    public void test掛け算() throws IOException{
    	String[] args = {}; /*文字列を入力*/
    	in.inputln("5.0 * 2.0");
    	simpleCalc.main(args); /*mainメソッドを実行*/

    	/*期待値を入力*/
    	String actual = "計算式を入力して下さい:入力された式は 5.0 * 2.0 です\n" +
    			"計算結果は 10.0 です\n";

    	/*期待値と実行した標準出力の値が等しいか確認*/
    	assertThat(actual, is(outContent.toString()));
    }

    @Test
    public void test引き算() throws IOException{
    	String[] args = {};
    	in.inputln("10 - 11");
    	simpleCalc.main(args);
    	String actual = "計算式を入力して下さい:入力された式は 10.0 - 11.0 です\n" +
    			"計算結果は -1.0 です\n";
    	assertThat(actual, is(outContent.toString()));
    }

    @Test
    public void test足し算() throws IOException{
    	String[] args = {};
    	in.inputln("99999 + 1");
    	simpleCalc.main(args);
    	String actual = "計算式を入力して下さい:入力された式は 99999.0 + 1.0 です\n" +
    			"計算結果は 100000.0 です\n";
    	assertThat(actual, is(outContent.toString()));
    }

    @Test
    public void test割り算() throws IOException{
    	String[] args = {};
    	in.inputln("1 / 3");
    	simpleCalc.main(args);
    	String actual = "計算式を入力して下さい:入力された式は 1.0 / 3.0 です\n" +
    			"計算結果は 0.3333333333333333 です\n";
    	assertThat(actual, is(outContent.toString()));
    }

    @Test
    public void test剰余算() throws IOException{
    	String[] args = {};
    	in.inputln("5 % 2");
    	simpleCalc.main(args);
    	String actual = "計算式を入力して下さい:入力された式は 5.0 % 2.0 です\n" +
    			"計算結果は 1.0 です\n";
    	assertThat(actual, is(outContent.toString()));
    }

}
