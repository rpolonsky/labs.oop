# Your task:

1. Create a new class Point3d to represent, you guessed it, points in three dimensional Euclidean space. It should be possible to:

-   create a new Point3d described by any three floating-point (type double) values,

-   create a new Point3d at (0.0, 0.0, 0.0) by default,

-   access and mutate all three values individually, and

-   compare two Point3ds for value-equality using an appropriate equals method.

    It should not be possible to directly access the internal data members of any Point3d object.

2. Furthermore, add a new method distanceTo which takes another Point3d as an argument, and computes a double-precision floating-point approximation of the straight-line distance between the two points, and returns that value.

3. Create a second class called Lab1 that exists primarily to house the static method main. Remember that main must be public, have a void return type, and accept an array of Strings as an argument. Inside this class, add some functionality:

-   Input three ordered triples from the user, each representing the coordinates of one point in 3-space. Generate three Point3d objects from this data. (For now, you can assume that the user will not enter invalid data.)

    If you don't know how to get input from the user, you can use the function in this file. Put it as a static method in your Lab1 class. Note that this method uses classes in the java.io package, which is not visible to your code by default. To make it visible, add this to the very top of your file:

    `import java.io.*;`

    This makes all classes in the java.io package visible to your Lab1 code. (You don't have to do this with the classes in the java.lang package, since those are made available to your classes by default.)

-   Write a second static method computeArea which takes three Point3d's and computes the area within the triangle bounded by them. (You may wish to use Heron's formula.) Return this area as a double.

-   Use the data and code you gathered and wrote above to determine the area and print that out for the user's consumption.

    _Before_ you call computeArea, however, test for value equality between all of the three Point3d's. If any pair of points is "equal", report this to the user and do not compute an area.

4. Compile both of your source files together:

    `javac Point3d.java Lab1.java`

    and then run your Lab1 program, testing it with several sample triangles.

5. When you are finished with lab 1, you can submit your files on the csman website.

### Russian translation

1. Создайте новый класс Point3d для представления точек в трехмерном Евклидовом пространстве. Необходимо реализовать:

-   создание нового объекта Point3d с тремя значениями с плавающей точкой (double);
-   создание нового объекта Point3d со значениями (0.0, 0.0, 0.0) по умолчанию,
-   возможность получения и изменения всех трех значений по отдельности;
-   метод для сравнения значений двух объектов Point3d.
    Нельзя предоставлять непосредственный доступ к внутренним элементам объекта класса Point3d .

2. Добавьте новый метод distanceTo, который в качестве параметра принимает другой объект Point3d, вычисляет расстояние между двумя точками с точность двух знаков после запятой и возвращает полученное значение.
3. Создайте другой класс под названием Lab1, который будет содержать статический метод main. Помните, что метод main должен быть общедоступным (public) с возвращаемым значением void, а в качестве аргумента должен принимать строку (String). Этот класс должен иметь следующую функциональность:

-   Ввод координат трех точек, находящихся в трехмерном пространстве. Создание трех объектов типа Point3d на основании полученных данных. (Предполагается, что пользователь вводит корректные данные.)
-   Создайте второй статический метод computeArea, который принимает три объекта типа Point3d и вычисляет площадь треугольника, образованного этими точками. (Вы можете использовать формулу Герона.) Верните получившееся значение площади в формате типа double.
-   На основе полученных данных и с использованием реализованного алгоритма посчитайте площадь и выведите полученное значение пользователю.
    Перед вызовом метода computeArea проверьте на равенство значений всех трех объектов Point3d. Если одна из точек равна другой, то выведите соответствующее сообщение пользователю и не вычисляйте площадь.

4. Скомпилируйте оба исходных файла вместе:
   javac Point3d.java Lab1.java
   и затем запустите программу Lab1, тестируя ее с несколькими образцами
   треугольников.
