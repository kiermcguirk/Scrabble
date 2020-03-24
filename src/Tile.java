public class Tile {

    //Using Enum for now...
    protected enum letter {a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,blank,empty}

    public letter getTileFromLetter(char s)
    {
        switch (s)
        {
            case 'A':
                return  letter.a;

            case 'B':
                return  letter.b;

            case 'C':
                return  letter.c;

            case 'D':
                return  letter.d;

            case 'E':
                return  letter.e;

            case 'F':
                return  letter.f;

            case 'G':
                return  letter.g;

            case 'H':
                return  letter.h;

            case 'I':
                return  letter.i;

            case 'J':
                return  letter.j;

            case 'K':
                return  letter.k;

            case 'L':
                return  letter.l;

            case 'M':
                return  letter.m;

            case 'N':
                return  letter.n;

            case 'O':
                return  letter.o;

            case 'P':
                return  letter.p;

            case 'Q':
                return  letter.q;

            case 'R':
                return  letter.r;

            case 'S':
                return  letter.s;

            case 'T':
                return  letter.t;

            case 'U':
                return  letter.u;

            case 'V':
                return  letter.v;

            case 'W':
                return  letter.w;

            case 'X':
                return  letter.x;

            case 'Y':
                return  letter.y;

            case 'Z':
                return  letter.z;

            default:
                return letter.empty;

        }
    }

}
