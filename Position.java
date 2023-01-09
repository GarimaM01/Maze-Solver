/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Position;

/**
 *
 * @author Meteor
 */
public class Position {
    private int x;
	private int y;
	
	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	@Override
	public boolean equals(Object obj) {
		Position other = (Position) obj;
		return x == other.getX() && y == other.getY();
	}
	
	@Override
	public String toString() {
		return "Postion(" + x + ", " + y + ")";
	}
	
	public static void main(String[] args) {
		Position current = new Position(0, 1);
		Position next = new Position(0, 1);
		
		System.out.println(current.equals(next));
	}
}
