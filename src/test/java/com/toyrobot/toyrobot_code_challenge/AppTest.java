package com.toyrobot.toyrobot_code_challenge;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
	Robot robot;
	
	@Before
	public void setup() {
		robot = new Robot();
    	robot.setTable(5,5);
	}
	
    @Test
    public void testPlaceRobot()
    {
    	System.out.println("==> Test place robot");
        assertTrue( robot.place(0, 0, "NORTH") );
    }   
    
    @Test
    public void testPlaceRobotLocationIncorrectly()
    {
    	System.out.println("==> Test place robot location incorrectly");
        assertTrue( !robot.place(-1, 0, "NORTH") );
    }    
    
    @Test
    public void testPlaceRobotFacingIncorrectly()
    {
    	System.out.println("==> Test place robot facing incorrectly");
        assertTrue( !robot.place(0, 0, "dummy") );
    }
    
    @Test
    public void testRobotMove() {
    	System.out.println("==> Test robot move");
    	assertTrue( robot.place(0, 0, "NORTH") );
    	assertTrue(robot.move());
    	robot.report();
    	assertTrue(robot.move());
    	robot.report();
    	assertTrue(robot.move());
    	robot.report();
    	assertTrue(robot.move());
    	robot.report();
    	assertTrue(!robot.move());
    	robot.report();
    }
    
    @Test
    public void testRobotTurnLeft() {
    	System.out.println("==> Test robot turn left");
    	assertTrue( robot.place(0, 0, "NORTH") );
    	assertTrue(robot.left());
    	robot.report();
    	assertTrue(robot.left());
    	robot.report();
    	assertTrue(robot.left());
    	robot.report();
    	assertTrue(robot.left());
    	robot.report();
    }
    
    @Test
    public void testRobotTurnRight() {
    	System.out.println("==> Test robot turn Right");
    	assertTrue( robot.place(0, 0, "NORTH") );
    	assertTrue(robot.right());
    	robot.report();
    	assertTrue(robot.right());
    	robot.report();
    	assertTrue(robot.right());
    	robot.report();
    	assertTrue(robot.right());
    	robot.report();
    }
}
