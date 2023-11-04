package _06_frogger;

import processing.core.PApplet;

public class Frogger extends PApplet {
	static final int WIDTH = 800;
	static final int HEIGHT = 600;
	public static int frogX = 25;
	public static int frogY = 575;

	Car car1;
	Car car2;
	Car car3;
	Car car4;
	Car car5;
	Car car6;

	@Override
	public void settings() {
		size(WIDTH, HEIGHT);

	}

	@Override
	public void setup() {
		car1 = new Car(0, 500, 30, 11);
		car2 = new Car(0, 400, 20, 10);
		car3 = new Car(0, 300, 30, 9);
		car4 = new Car(0, 200, 30, 8);
		car5 = new Car(0, 0, 20, 7);
		car6 = new Car(0, 100, 30, 6);

	}

	@Override
	public void draw() {
		background(100, 200, 200);

		fill(0, 255, 0);
		ellipse(frogX, frogY, 25, 25);

		car1.display();
		car2.display();
		car3.display();
		car4.display();
		car5.display();
		car6.display();

		car1.moveLeft();
		car2.moveLeft();
		car3.moveRight();
		car4.moveLeft();
		car5.moveRight();
		car6.moveRight();
		
		if (car1.intersects(car1) || car2.intersects(car2) || car3.intersects(car3) || car4.intersects(car4) || car5.intersects(car5) || car6.intersects(car6)) {
			frogY = 575;
		}
	}

	public void keyPressed() {
		if (key == CODED) {
			if (keyCode == UP) {
				// Frog Y position goes up
				frogY -= 30;
				offCanvas();
			} else if (keyCode == DOWN) {
				// Frog Y position goes down
				frogY += 30;
				offCanvas();
			} else if (keyCode == RIGHT) {
				// Frog X position goes right
				frogX += 30;
				offCanvas();
			} else if (keyCode == LEFT) {
				// Frog X position goes left
				frogX -= 30;
				offCanvas();
			}

		}
	}

	public void offCanvas() {

		if (frogX <= -5) {
			frogX += 800;
		} else if (frogX >= 805) {
			frogX -= 800;
		}

		if (frogY >= 600) {
			frogY -= 30;
		} else if (frogY <= 0) {
			frogY += 30;
		}

	}

	static public void main(String[] args) {
		PApplet.main(Frogger.class.getName());
	}

	public class Car {

		public int x;
		public int y;
		public int size;
		public int speed;

		public Car(int x, int y, int size, int speed) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.speed = speed;

		}

		public void display() {
			fill(255, 0, 0);
			rect(x, y, size * 3, 40);
		}

		public void moveRight() {
			x += speed * 2;

			if (x >= WIDTH) {
				x = -5;
			}
		}

		public void moveLeft() {
			x -= speed * 2;

			if (x <= 0) {
				x = WIDTH;
			}
		}

		boolean intersects(Car car) {
			if ((frogY > car.getY() && frogY < car.getY() + 50) && (frogX > car.getX() && frogX < car.getX() + car.getSize())) {
				return true;
			} else {
				return false;
			}
		}

		private int getSize() {
			return size;
		}

		private int getX() {
			return x;
		}

		private int getY() {
			return y;
		}
	}
}
