import java.security.InvalidAlgorithmParameterException;

public class task3 {
    
    public static void main(String[] args){
        solution(1, 0, -1);
        System.out.println(findZip("all zip files are zipped"));
        System.out.println(checkPerfect(496));
        flipEndChars("Cat, dog, and mouse.");
        System.out.println("");
        System.out.println(inValidHexCode("#CD5C&C"));
        int n1=5;
        int n2=5;
        int[] mas1 = new int[n1];
        int[] mas2 = new int[n2];
        masGenerate(mas1);
        masGenerate(mas2);
        MassCout(mas1);
        System.out.println(" ");
        MassCout(mas2);
        System.out.println(" ");
        masMinimized(mas1);
        masMinimized(mas2);
        System.out.println(same(mas1, mas2));
        System.out.println(isKaprekar(297));
        longestZero("0001000001");
        System.out.println(nextPrime(24));
        rightTriangle(100, 105, 145);
    }
    public static void MassCout(int[] mas){
        for (int i=0;i<mas.length;i++){
            System.out.print(mas[i]+" , ");
        }
    }
    public static void solution(double a, double b, double c){
        double D;
        D=Math.pow(b,2)-4*a*c;
        if(D<0){
            System.out.println("0 has no solutions");
        }
        else if (D==0){
            System.out.println("x=" + (-b)/(2*a) + "has  one solution");
        }
        else if (D>0){
            System.out.println("x1=" + (-b+Math.sqrt(D))/(2*a) + "\n" + "x2=" + (-b-Math.sqrt(D))/(2*a) + "\n" + "has two solutions");
        }
    }
    public static double findZip(String word){
        char[]  fword = word.toCharArray();
        double pos = 0;
        double lastindex=0;
        for(int i=0;i<fword.length-2;i++){
            if(fword[i]=='z' && fword[i+1]=='i' && fword[i+2]=='p'){
                pos+=1;
                lastindex=i;
                i=i+2;
                
            }
        }
        if (pos<=1){
            return  -1;
        }
        else{
        return lastindex;
        }
    }
    public static boolean checkPerfect(int numb){
        int a,b,f;
        a=1;
        b=numb;
        f=1;
        while (b%2==0){
            a=a*2;
            b=b/2;
            f+=a+b;
        }
        return f==numb;
    }
    public static void flipEndChars(String word){
        char temp;
        char[] swaperword = word.toCharArray();
        if(swaperword.length<2){
            System.out.println("incompaitble");
        }
        else if(swaperword[0]==swaperword[swaperword.length-1]){
            System.out.println("Two is a pair");
        }
        else{
        temp=swaperword[swaperword.length-1];
        swaperword[swaperword.length-1]=swaperword[0];
        swaperword[0]=temp;
        for(int i=0;i<swaperword.length;i++){
            System.out.print(swaperword[i]);
        }
    }
    }
    public static boolean inValidHexCode(String Hword){
        char[] FHword = Hword.toCharArray();
        if(FHword.length!=7){
            return false;
        }
        if(FHword[0] != '#'){
            return false;
        }
        for (int i=1;i<FHword.length;i++){
            if((FHword[i]<='0' || FHword[i]>='9') && (FHword[i]<='A' || FHword[i]>='F')){
                return false;
            }
        }

        return true;
    }
    public static void masGenerate(int[] mas){
        for(int i=0;i<mas.length;i++){
            mas[i]=(int)Math.round((Math.random()*10)-0);
        }
    }
    public static void elDelete(int[] mas,int index){
       
        for (int i=index;i<mas.length-1;i++){
            mas[i]=mas[i+1];
        }
        mas[mas.length-1]=-1;

    }
    public static void masMinimized(int[] mas){
        for (int i=0;i<mas.length;i++){
            if(mas[i]!=-1){
                for(int j=i+1;j<mas.length;j++){
                    if (mas[i]==mas[j]){
                        elDelete(mas, j);
                    }
                }
            }
        }
        
    }
    public static boolean same(int[] mas1, int[] mas2){
        int numb1 = 0;
        int numb2 = 0;
        for (int i=0;i<mas1.length;i++){
            if(mas1[i] != -1){
                numb1+=1;
            }
        }
        for (int i=0;i<mas2.length;i++){
            if(mas2[i] != -1){
                numb2+=1;
            }
        }


        return numb1==numb2;
    }
    public static int findNumbRange(int numb){
        int range=0;
        int temp=1;
        while(numb >= temp){
            temp*=10;
            range++;
        }
        return range;
    }
    public static boolean isKaprekar(int numb){
        int pnumb = numb * numb;
        int left, right;
        int l,r;
        int range=findNumbRange(pnumb);
        if(range%2!=0){
            range++;
            l=(int)Math.pow(10,(range/2));
            r=(int)Math.pow(10,(range/2));
            left=pnumb/l;
            right=pnumb%r;
        }
        else{
            left=pnumb/ (int)Math.pow(10,(range/2));
            right=pnumb%(int)Math.pow(10,(range/2));
        } 
       

        return left+right==numb;
    }
    public static void longestZero(String word){
        char[] binword = word.toCharArray();
        int Hrange=0;
        int Lrange=0;
        for(int i=0;i<binword.length;i++){
            if(binword[i] == '0'){
                Lrange++;
            }
            else{
                if(Lrange>Hrange){
                    Hrange=Lrange;
                }
                Lrange=0;
            }
        }
        
        if(Hrange==0){
            System.out.println("");
        }
        else{
            for(int i=0;i<Hrange;i++){
                System.out.print("0");
            }
        }
        System.out.println("");
    }
    public static int nextPrime(int numb){
        for(int i =2;i<numb;i++){
            if(numb%i == 0){
                numb++;

            }

        }

        return numb;
    }
    public static void rightTriangle(int a, int b, int c){
        if(c*c==a*a+b*b){
            System.out.println("This is a right triangle");
        }
        else{
            System.out.println("This isn't a right triangle");
        }
    }
}
