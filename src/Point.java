/**
 * Created by lukestowe on 28/01/2015.
 */
public class Point {
    private int y;
    private int x;
    private float slope;
    private float perpSlope;
    private Point upper;
    private Point outUpper;
    private Point lower;
    private Point outLower;

    Point(int x1, int x2)
    {
        y=x1;
        x=x2;
    }
    Point returnUpper()
    {
        return upper;
    }
    Point returnLower()
    {
        return lower;
    }
    void setLimit(Point upper, Point lower, Point outUpper, Point outLower)
    {
        this.upper=upper;
        this.lower=lower;
        this.outLower=outLower;
        this.outUpper=outUpper;
    }
    int getX()
    {
        return x;
    }
    int getY()
    {
        return y;
    }
    float returnSlope()
    {
        return slope;
    }
    float returnPerpendicular(){
        float f = 1;
        perpSlope = 0-(f/slope);
        perpSlope = Math.round(perpSlope*100.0f)/100.0f;
        return perpSlope;
    }
    float getSlope(int y1, int x1){
        double x = x1 - this.x;
        double y = y1 - this.y;

        if( x == 0)
        {
            slope = 500f;
            slope= Math.round(slope*100.0f)/100.0f;
            return slope;
        }

        else
        {
            slope=(float)(y/x)+0f;
            slope = Math.round(slope*100.0f)/100.0f;
            return slope;
        }

    }
    Point midpoint(Point p1)
    {
        int x = (this.x+p1.x)/2;
        int y = (this.y+p1.y)/2;
        return new Point(y,x);
    }
    @Override
    public boolean equals(Object p1){
        Point p = (Point)p1;
        return this.slope == p.slope;
    }
    public boolean equalsCoordinate(Point p)
    {
        return (this.x==p.x && this.y==p.y);
    }
    public boolean equationLine(Point p, float slope)
    {
        double x = this.x-p.x;
        double y = this.y-p.y;
        float m =(float)(y/x)+0f;

        //System.out.println(m+" "+this.slope);
        if(m<=this.slope+0.02f && m >= this.slope-0.02f)
            return true;
        else
            return false;

    }

    public int getPerpY(int y1){
        double y = y1-this.y;
        return (int)(this.x+(y/this.perpSlope));
    }

    public int distance(Point p){
        return (int)Math.sqrt(((this.x-p.x)*(this.x-p.x))+((this.y-p.y)*(this.y-p.y)));
    }

}
