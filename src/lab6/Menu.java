package lab6;

import java.util.Scanner;

public class Menu {
	public void start(){
		double x1, y1, x2, y2, x3, y3, x4, y4, x5, y5, size;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Создание треугольника...");
		System.out.println("Введите координаты (x1;y1)");
		x1 = in.nextDouble();
		y1 = in.nextDouble();
		System.out.println("Введите координаты (x2;y2)");
		x2 = in.nextDouble();
		y2 = in.nextDouble();
		System.out.println("Введите координаты (x3;y3)");
		x3 = in.nextDouble();
		y3 = in.nextDouble();
		Triangle triangle = new Triangle(x1, y1, x2, y2, x3, y3);
		
		System.out.println("Создание квадрата...");
		System.out.println("Введите центра (x1;y1)");
		x1 = in.nextDouble();
		y1 = in.nextDouble();
		System.out.println("Введите размер стороны");
		size = in.nextDouble();
		Square square = new Square(x1, y1, size);
		
		System.out.println("Создание пятиугольника...");
		System.out.println("Введите координаты (x1;y1)");
		x1 = in.nextDouble();
		y1 = in.nextDouble();
		System.out.println("Введите координаты (x2;y2)");
		x2 = in.nextDouble();
		y2 = in.nextDouble();
		System.out.println("Введите координаты (x3;y3)");
		x3 = in.nextDouble();
		y3 = in.nextDouble();
		System.out.println("Введите координаты (x4;y4)");
		x4 = in.nextDouble();
		y4 = in.nextDouble();
		System.out.println("Введите координаты (x5;y5)");
		x5 = in.nextDouble();
		y5 = in.nextDouble();
		Pentagon pentagon = new Pentagon(x1, y1, x2, y2, x3, y3, x4, y4, x5, y5);
		
		int chooseFig = -1;
		while (chooseFig != 0) {
			System.out.println("______________________________________________________");
			System.out.println("Для работы с треугольником введите 1");
			System.out.println("Для работы с квадратом введите 2");
			System.out.println("Для работы с пятиугольником введите 3");
			System.out.println("Для проверки на пересечение всех фигур нажмите 4");
			System.out.println("Для завершения работы нажмите 0");
			
			chooseFig = in.nextInt();		
			switch (chooseFig) {
			
			case 1: chooseFig = 1;
					int choose_meth1 = -1;
					while (choose_meth1 != 0) {
						fig_menu();
						
						choose_meth1 = in.nextInt();
							switch (choose_meth1) {
							case 1: choose_meth1 = 1;
								System.out.println("Координаты треугольника: ");
								triangle.show();
								break;
							case 2: choose_meth1 = 2;
								System.out.println("Перемещение фигуры (увеличение (x;y) на Ваше значение)");
								double deltaX,deltaY;
								deltaX = in.nextDouble();
								deltaY = in.nextDouble();
								triangle.move(deltaX, deltaY);
								break;
							case 3: choose_meth1 = 3;
								System.out.println("Периметр фигуры: ");
								System.out.println(triangle.getPerimetr());
								break;
							case 4: choose_meth1 = 4;
								System.out.println("Площадь фигуры: ");
								System.out.println(triangle.getArea());
								break;
							}
					}
				break;

			case 2: chooseFig = 2;
			 choose_meth1 = -1;
			while (choose_meth1 != 0) {
				fig_menu();
				
				choose_meth1 = in.nextInt();
				switch (choose_meth1) {
				case 1: choose_meth1 = 1;
					System.out.println("Координаты квадрата: ");
					square.show();
					break;
				case 2: choose_meth1 = 2;
					System.out.println("Перемещение фигуры (увеличение (x;y) на Ваше значение)");
					double deltaX,deltaY;
					deltaX = in.nextDouble();
					deltaY = in.nextDouble();
					square.move(deltaX, deltaY);
					break;
				case 3: choose_meth1 = 3;
					System.out.println("Периметр фигуры: ");
					System.out.println(square.getPerimetr());
					break;
				case 4: choose_meth1 = 4;
					System.out.println("Площадь фигуры: ");
					System.out.println(square.getArea());
					break;
				}
			}
				break;
				
			case 3: chooseFig = 3;
			 choose_meth1 = -1;
			while (choose_meth1 != 0) {
				fig_menu();
				
				choose_meth1 = in.nextInt();
				switch (choose_meth1) {
				case 1: choose_meth1 = 1;
					System.out.println("Координаты пятиугольника: ");
					pentagon.show();
					break;
				case 2: choose_meth1 = 2;
					System.out.println("Перемещение фигуры (увеличение (x;y) на Ваше значение)");
					double deltaX,deltaY;
					deltaX = in.nextDouble();
					deltaY = in.nextDouble();
					pentagon.move(deltaX, deltaY);
					break;
				case 3: choose_meth1 = 3;
					System.out.println("Периметр фигуры: ");
					System.out.println(pentagon.getPerimetr());
					break;
				case 4: choose_meth1 = 4;
					System.out.println("Площадь фигуры: ");
					System.out.println("Выведу периметр, так как на площадь сложные формулы :) ");
					System.out.println(square.getPerimetr());
					break;
				}
			}
				
				break;
				
			case 4: chooseFig = 4;
			 choose_meth1 = -1;
			while (choose_meth1 != 0) {
				System.out.println("Для завершения работы введите 0, для продолжения другое число");
				
				choose_meth1 = in.nextInt();
				System.out.println("Пересечение треугольника и квадрата:");
				System.out.println(triangle.testIntersection(square));
				System.out.println("Пересечение треугольника и пятиугольника:");
				System.out.println(triangle.testIntersection(pentagon));
				System.out.println("Пересечение квадрата и пятиугольника:");
				System.out.println(square.testIntersection(pentagon));
			}
				break;
			}
		}
	}
	
	public void fig_menu(){
			System.out.println("______________________________________________________");
			System.out.println("Введите 1 чтобы показать координаты фигуры");
			System.out.println("Введите 2 чтобы сдвинуть на желаемые координаты");
			System.out.println("Введите 3 чтобы показать периметр фигуры");
			System.out.println("Введите 4 чтобы показать площадь фигуры");
			System.out.println("Введите 0 для завершения работы с фигурой");
		}
	}
