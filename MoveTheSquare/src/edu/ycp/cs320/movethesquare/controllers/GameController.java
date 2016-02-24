package edu.ycp.cs320.movethesquare.controllers;

import edu.ycp.cs320.movethesquare.model.Game;
import edu.ycp.cs320.movethesquare.model.Square;

public class GameController {
	public void computeSquareMoveDirection(Game game, Square square, double mouseX, double mouseY) {
		if (mouseX >= 0 && mouseX < game.getWidth() && mouseY >= 0 && mouseY < game.getHeight()) {

			double dx = mouseX - (square.getX() + square.getWidth()/2);
			double dy = mouseY - (square.getY() + square.getHeight()/2);

			double xbound = game.getWidth();
			double ybound = game.getHeight();

			double moveX = 0, moveY = 0;


			if (dx > 2 && square.getX() + square.getWidth() < xbound) {
				moveX = Game.MOVE_DIST;
			} else if(dx < -2 && square.getX() > 0){
				moveX = -Game.MOVE_DIST;
			}

			if (dy > 2 && square.getY() + square.getHeight() < ybound) {
				moveY = Game.MOVE_DIST;
			} else if(dy < -2 && square.getY() > 0){
				moveY = -Game.MOVE_DIST;
			}

			game.setSquareDx(moveX);
			game.setSquareDy(moveY);
		}
	}

	public void moveSquare(Game model, Square square) {
		square.setX(square.getX() + model.getSquareDx());
		square.setY(square.getY() + model.getSquareDy());
	}
}
