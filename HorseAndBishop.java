class HorseBishop{
    
	public int given[][] = new int[8][8];
	public int copy[][]=new int[8][8];
	public String ans="";
    void bishopMove(int cr1, int cc1) 
    {
        if(this.ans!="") return;
        int rows=this.given.length, col=this.given[0].length;
        if(cr1 < 0 || cc1 < 0 || cr1 >= rows || cc1 >= col || this.given[cr1][cc1] == -1 || this.copy[cr1][cc1] == 2)
                return;
            this.copy[cr1][cc1] += 2;
            if(this.copy[cr1][cc1] == 3)
            {
                String str1 = Integer.toString(cr1);
                str1=str1.concat(",");
                String str2 = Integer.toString(cc1);
                this.ans = str1.concat(str2);
                return;
            }
            this.bishopMove(cr1 + 1, cc1 + 1);
            this.bishopMove(cr1 + 1, cc1 - 1);
            this.bishopMove(cr1 - 1, cc1 + 1);
            this.bishopMove(cr1 - 1, cc1 - 1);

            this.copy[cr1][cc1] -= 2;
    }
    void horseMove(int cr1, int cc1, int cr2, int cc2)
    {
        if(this.ans!="") return;
        int rows=this.given.length, cols=this.given[0].length;
        if(cr2 < 0 || cc2 < 0 || cr2 >= rows || cc2 >= cols || this.copy[cr2][cc2] == 1 || this.given[cr2][
                cc2] == -1)
                return;
        this.copy[cr2][cc2]+=1;
        this.bishopMove(cr1, cc1);

        this.horseMove(cr1, cc1, cr2 - 2, cc2 - 1);
        this.horseMove(cr1, cc1, cr2 - 2, cc2 + 1);

        this.horseMove(cr1, cc1, cr2 + 2, cc2 - 1);
        this.horseMove(cr1, cc1, cr2 + 2, cc2 + 1);

        this.horseMove(cr1, cc1, cr2 - 1, cc2 - 2);
        this.horseMove(cr1, cc1, cr2 - 1, cc2 + 2);

        this.horseMove(cr1, cc1, cr2 + 1, cc2 - 2);
        this.horseMove(cr1, cc1, cr2 + 1, cc2 + 2);

        this.copy[cr2][cc2]-=1;
    }
    String solve(int cr1, int cc1, int cr2, int cc2) 
    {
        int rows=this.given.length, col=this.given[0].length;
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<col;j++)
            copy[i][j]=given[i][j];
        }
        this.horseMove(cr1,cc1,cr2,cc2);
        return this.ans;
    }
	public static void main (String[] args) {
	    
	    HorseBishop object=new HorseBishop();
	    int rows=8,columns=8;
	    for(int i=0;i<rows;i++)
	    {
	        for(int j=0;j<columns;j++)
	        object.given[i][j]=0;
	    }
	    object.given[3][0] = -1;
        object.given[0][2] = -1;
        object.given[7][0] = -1;
        object.given[6][2] = -1;
        object.given[3][4] = -1;
        object.given[7][6] = -1;
        object.given[1][7] = -1;
        object.ans="";
        System.out.println(object.solve(3,2,6,6));
    }
}
