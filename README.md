# SimpleCanvas
This is a simple program that can draw lines and rectangles on a canvas.

### Usage
```
C w h to create a new canvas of width w and height h.
L x1 y1 x2 y2 to create a new line from (x1, y1) to (x2, y2). Currently only horizontal or vertical lines are supported.
R x1 y1 x2 y2 to create a new rectangle whose upper left corner is (x1, y1) and lower right corner is (x2, y2).
Q to quit the program.
```

### Building it from source
```
git clone https://github.com/tonyzhu918/SimpleCanvas.git
cd SimpleCanvas
mvn clean package
```

### To run the program
```
cd target
java -jar SimpleCanvas-1.0-SNAPSHOT.jar
```