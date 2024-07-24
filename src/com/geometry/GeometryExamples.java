package com.geometry;

public class GeometryExamples {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[]
                {
                        new Square(5),
                        new Circle(3),
                        new Square(7),
                        new Circle(7),
                        new Triangle(14, 26, 26),
                        new Rectangle(4, 7)
                };
//        double sum = getAreaSum(shapes);
//        System.out.println(sum);
//        System.out.println(getShapeWithMaxPerimeter(shapes));
//        System.out.println(shapeWithMinArea(shapes));
        System.out.println(considerFiguresWithPerimeterMoreThanN(shapes, 25));
        Rectangle rectangle = new Rectangle(3, 2);
        Triangle triangle = new Triangle(3, 4, 5);
        System.out.println(rectangle.equals(triangle));

        while (true) {
            try {
                triangle.setSideA(triangle.getSideA() + 0.001);
            } catch (RuntimeException e) {
                break;
            }
        }
        System.out.println("Limit: " + triangle);

    }

    private static double getAreaSum(Shape[] shapes) {
        double sum = 0;
        for (int i = 0; i < shapes.length; i++) {
            sum = shapes[i].getArea() + sum;
        }
        return sum;
    }

    private static Shape getShapeWithMaxPerimeter(Shape[] shapes) {
        double temp = 0;
        Shape figure = null;
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i].getPerimeter() > temp) {
                temp = shapes[i].getPerimeter();
                figure = shapes[i];
            }
        }
        return figure;
    }

    // найти фигуру с наименьшей площадью из массива
    public static Shape shapeWithMinArea(Shape[] shapes) {
        double temp = Double.MAX_VALUE;
        Shape figure = null;
        for (int i = 0; i < shapes.length; i++) {
            if (shapes[i].getArea() < temp) {
                temp = shapes[i].getArea();
                figure = shapes[i];
            }
        }
        return figure;
    }

    // посчитать, сколько фигур из массива имеют периметр больше числа N
    public static int considerFiguresWithPerimeterMoreThanN(Shape[] shapes, int n) {
        int count = 0;
        for(int i = 0; i < shapes.length; i++) {
            if(shapes[i].getPerimeter() > n) {
                count++;
            }
        }
        return count;
    }
}

    // есть массив геометрических фигур, найти фигуру с наибольшим периметром

    /*
        1 добавить в эту иерархию фигур треугольники и прямоугольники
     */