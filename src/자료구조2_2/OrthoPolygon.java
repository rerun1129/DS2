package 자료구조2_2;

public class OrthoPolygon {
    public  int n; //다각형 꼭지점의 개수
    public MyPoint2 [] vertices; //꼭지점들의 배열

    public OrthoPolygon(int k){
        n = 0;
        vertices = new MyPoint2 [k];
    }
    public void addVertex(int x, int y){
        vertices[n++] = new MyPoint2(x, y);
    }
    public int maxX(){
        int max = vertices[0].x;
        for(int i = 0; i<n; i++){
            if(vertices[i].x > max)
                max = vertices[i].x;
        }
        return max;
    }


    public boolean contains(MyPoint2 p){
        OrthoLine arrow = new OrthoLine(p,new MyPoint2(maxX()+1,p.y));
        int count = 0;
        for(int i = 0; i<n; i++){
            OrthoLine edge = new OrthoLine(vertices[i], vertices[(i+1) % n]);
            if(arrow.intersects(edge))
                count++;
        }
        return (count % 2 == 1);
    }
}
