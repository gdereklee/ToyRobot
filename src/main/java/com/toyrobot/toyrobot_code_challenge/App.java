package com.toyrobot.toyrobot_code_challenge;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Toy Robot Challenge!" );
        System.out.println("Please input your command");
        command();
        System.out.println("");
        try {
        	@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
            Robot robot = new Robot();
            robot.setTable(5,5);
            
        	while(true) {        		
        		String line = scanner.nextLine().toUpperCase();
        		if(line.toUpperCase().indexOf("PLACE ") == 0) {
        			String command = line.toUpperCase().replaceFirst("PLACE ", "");
        			String[] placeCommand = command.split(",");
        			if(placeCommand.length  == 3) {
        				robot.place(Integer.parseInt(placeCommand[0]),Integer.parseInt(placeCommand[1]),
        						placeCommand[2].toUpperCase());
        			} else {
        				System.out.println("Something wrong with your command.");
        				command();
        			}
        		} else if(line.toUpperCase().equals("MOVE")) {
                	robot.move();
                } else if(line.toUpperCase().equals("LEFT")) {
                	robot.left();
                } else if(line.toUpperCase().equals("RIGHT")) {
                	robot.right();
                } else if(line.toUpperCase().equals("REPORT")) {
                	robot.report();
                } else if(line.toUpperCase().equals("EXIST")) {
                	break;
                } else {
                	command();              	
                }
        	}
        } catch (Exception e) {
        	System.out.println("System.in was closed; exiting");
        }
    }
    
    private static void command() {
    	System.out.println("EXIST - quit the program");
    	System.out.println("PLACE X,Y,Z - place your robot location X and Y, face Z. Z has to be NORTH, EAST, SOUTH, WEST");
    	System.out.println("MOVE - move your robot");
    	System.out.println("REPORT - print your robot location");     	
    }
}
