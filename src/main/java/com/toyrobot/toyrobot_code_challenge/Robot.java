package com.toyrobot.toyrobot_code_challenge;

public class Robot {

	String _facing;
	int _currentX;
	int _currentY;
	int _row;
	int _column;
	boolean _placed;
	
	public Robot() {
	}
	
	/*
	 * Set the table sie unit
	 */
	public boolean setTable(int row, int column) {
		boolean valid = false;
		if(row > 0 && column > 0) {
			_row = row;
			_column = column;
			valid=true;
		} else {
			_row = 0;
			_column = 0;
			System.out.println("Table size incorrect!");
			System.out.println("Row and Column size > 0");
		}
		return valid;
	}
	
	/*
	 * Place the robot
	 */
	public boolean place(int x, int y, String facing) {
		boolean valid = false;
		if(x >= 0 && y >= 0 && x < _column && y < _row && validateFacing(facing)) {
			_currentX = x;
			_currentY = y;
			_facing = facing.toUpperCase();
			valid = true;
			_placed = true;
		} else {
			System.out.println("You are placing robot to an unknown location!");
			System.out.println("The table size is " + _row + "x"+_column);
			System.out.println("Your robot has to face NORTH, EAST, SOUTH, WEST");
		}
		return valid;
	}
	
	/*
	 * Validate the robot facing
	 */
	private boolean validateFacing(String facing) {
		return facing.toUpperCase().equals("NORTH") ||
				facing.toUpperCase().equals("EAST") ||
				facing.toUpperCase().equals("SOUTH") ||
				facing.toUpperCase().equals("WEST");
	}
	
	/*
	 * Move the robot
	 */
	public boolean move() {
		boolean valid = false;
		if(_placed) {
			switch(_facing) {
				case "NORTH":			
					if(_row > _currentY + 1) {
						_currentY++;
						valid=true;
					}
					break;
				case "EAST":
					if(_column > _currentX + 1) {
						_currentX++;
						valid=true;
					}
					break;
				case "SOUTH":
					if(_currentY - 1 > 0) {
						_currentY--;
						valid=true;
					}
					break;
				case "WEST":
					if(_currentX - 1 > 0) {
						_currentX--;
						valid=true;
					}
					break;
			}
			if(!valid) {
				System.out.println("Stop! Will fall from the table!");
			}
		} else {
			System.out.println("Please place your robot first!");
		}
		return valid;
	}
	
	/*
	 * Report the robot current location and facing
	 */
	public void report() {
		if(_placed) {
			System.out.println("Output: " + _currentX +","+_currentY+","+_facing);
		} else {		
			System.out.println("Location unknown! Please place your robot first!");
		}
	}
	
	/*
	 * Turn left
	 */
	public boolean left() {
		boolean valid = false;
		if(!_placed) {
			System.out.println("Please place your robot first!");
		} else {
			valid=true;
			switch(_facing) {
				case "NORTH":
					_facing = "WEST";
					break;
				case "SOUTH":
					_facing = "EAST";
					break;
				case "EAST":
					_facing = "NORTH";
					break;
				case "WEST":
					_facing = "SOUTH";
					break;
				default:
					valid=false;
					break;
			}
		}
		return valid;
	}
	
	/*
	 * Turn right
	 */
	public boolean right() {
		boolean valid = false;
		if(!_placed) {
			System.out.println("Please place your robot first!");
		} else {
			valid=true;
			switch(_facing) {
				case "NORTH":
					_facing = "EAST";
					break;
				case "SOUTH":
					_facing = "WEST";
					break;
				case "EAST":
					_facing = "SOUTH";
					break;
				case "WEST":
					_facing = "NORTH";
					break;
				default:
					valid=false;
					break;
			}
		}
		return valid;
	}
	
}