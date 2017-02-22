package org.skangayam;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

/**
 * Solution Tester.
 *
 * @author <Authors name>
 * @since <pre>02/21/2017</pre>
 * @version 1.0
 */
public class SolutionTest extends TestCase {
    public SolutionTest(String name) {
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
        super.tearDown();
    }

    public void testSurround(){
        Solution obj = new Solution();
        char[][] arr = new char[4][4];
        for(int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                arr[i][j]='A';
            }
        }
        arr[1][1] = 'Z';
        arr[1][2] = 'Z';
        arr[2][2] = 'Z';
        arr[3][1] = 'Z';
        obj.surround(arr);

        assert arr[1][1] == 'A';
        assert arr[1][2] == 'A';
        assert arr[2][2] == 'A';
        assert arr[3][1] == 'Z';
    }

    public void testSurround2(){
        Solution obj = new Solution();
        char[][] arr = new char[4][4];
        for(int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++){
                arr[i][j]='A';
            }
        }
        arr[1][1] = 'Z';
        arr[1][2] = 'Z';
        arr[2][2] = 'Z';
        arr[2][3] = 'Z';
        arr[3][1] = 'Z';
        obj.surround(arr);

        assert arr[1][1] == 'Z';
        assert arr[1][2] == 'Z';
        assert arr[2][2] == 'Z';
        assert arr[2][3] == 'Z';
        assert arr[3][1] == 'Z';
    }

    public static Test suite() {
        return new TestSuite(SolutionTest.class);
    }
}
