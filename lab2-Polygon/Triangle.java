class Triangle implements Polygon{

    protected double side1;
    protected double side2;
    protected double side3;

    public Triangle(double side1, double side2, double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double area(){
        return 0;
    }

    @Override
    public double perimeter(){
        return 0;
    }

}
