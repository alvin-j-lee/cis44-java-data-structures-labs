class Rectangle extends Quadrilateral {
    protected double length;
    protected double width;

    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    @Override
    public double area(){
        return length * width;
    }

    public double perimeter(){
        return ((2*length)+(2*width));
    }

}
