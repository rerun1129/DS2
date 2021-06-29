package 자료구조2_2;

public class OrthoLine {
    public MyPoint2 u;
    public MyPoint2 v;

    public OrthoLine(MyPoint2 p, MyPoint2 q) { //선분 작성1
        u = p;
        v = q;
        if (p.x > q.x || p.x == q.x && p.y > q.y) { //수직 수평 꼭지점을 스왑해서 u,v만 쓰기위함.
            swap();
        }
    }

    public void swap() {
        MyPoint2 tmp = u;
        u = v;
        v = tmp;
    }

    public boolean isVertical() {
        return u.x == v.x;
    }

    public boolean intersects(OrthoLine other) { //교차점(선을 그었을때 교차하는지 안하는지)
        if (isVertical() && !other.isVertical())
            return (other.u.x < u.x && other.v.x > u.x && other.u.y > u.y && other.u.y < v.y);
        else if (!isVertical() && other.isVertical())
            return (other.u.y < u.y && other.v.y > u.y && other.u.x > u.x && other.u.x < v.x);

        else
            return false;
    }
}
    /*public OrthoLine(int x1, int y1, int x2, int y2) { //선분 작성2
        u = new MyPoint2(x1, y1);
        v = new MyPoint2(x2, y2);
    }

    public boolean isVertical() {
        return u.x == v.x;
    }

    public boolean intersects(OrthoLine other) { //교차점(선을 그었을때 교차하는지 안하는지)
        if (isVertical() && !other.isVertical())
            return (other.u.x < u.x && other.v.x > u.x && other.u.y > u.y && other.u.y <v.y);
        else if (!isVertical() && other.isVertical())
            return (other.u.y < u.y && other.v.y > u.y && other.u.x > u.x && other.u.x <v.x);

         else
            return false;
        }*/