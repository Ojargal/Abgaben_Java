public class Minimum {

    int a, b, c, d;

    public int min2(int a, int b){
        if (a>b){return b;}
        else {return a;}
    }
    public int min3(int a, int b, int c){
        if (a<b && b<c){return a;}
             else {if (b<a && a<c){return b;}
                    else {return c;}}
    }
    public int min4(int a, int b, int c, int d){
      if(this.min2(a, b)>this.min2(c, d)){
          return min2(c, d);
      }
      else {return min2(a, b);}
    }


}
