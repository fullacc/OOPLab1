import java.util.Scanner;
import java.lang.*;

public class GAME
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int turn = (int)(Math.random()*2);
		TicTacToe game = new TicTacToe();
		game.clearTable();	
		if(turn==0){
			System.out.println("By Decision of random - machine moves first");		
			game.moveMach();
			game.showTable();	
		}
		else {
			System.out.println("By Decision of random - you move first");	
		}
		int x,y;
		while(game.checkFor()){
			do{
			System.out.println("Your turn");
			x = in.nextInt();
			y = in.nextInt();
			}
			while(game.moveHum(x-1,y-1)==false);
			game.showTable();
			if(game.checkFor()==false){
				break;
			}
			System.out.println("Machine's turn");
			game.moveMach();
			game.showTable();
		}
	}
}

class TicTacToe{
	private char table[][] = new char[4][4];
	TicTacToe(){
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				table[i][j]=' ';
	}

	public void clearTable(){
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				table[i][j]=' ';
	}
	public void moveMach(){
		int tr = (int)(Math.random()*9);
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(table[i][j]==' '){
					if(tr>0)
						tr--;
					else {
						table[i][j]='x';
						return;
					}
				}
				if(i==j&&i==2)i=-1;
			}
		}
	}
	public boolean moveHum(int x,int y){
		if(table[x][y]==' '){
			table[x][y]='o';
			return true;
		}
		else{
			System.out.println("Wrong move! Try again");
			showTable();
			return false;	
		}
	}
	public void showTable(){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++)
				System.out.print(table[i][j]+" ");
			System.out.print('\n');
		}	
	}
	public boolean checkAvail(){
		for(int i=0;i<3;i++)
			for(int j=0;j<3;j++)
				if(table[i][j]==' ')return true;
		return false;
	}
	public boolean checkFor(){
		int rsult=this.checkForwin();
		if(rsult==0){
			if(this.checkAvail()==false){
				System.out.println("TIE!");
				return false;
			}
			else return true;
		}
		else {
			if(rsult==1){
				System.out.println("Machine won!");
				return false;
			}
			if(rsult==2){
				System.out.println("You won!");	
				return false;
			}
		}
		return false;
	}
	public int checkForwin(){
		int k=0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(table[i][j]==' '){
					k=0;
					break;
				}
				if(table[i][j]=='x'){
					if(k==0)k=1;
					if(k==2){k=0;break;}
				}
				if(table[i][j]=='o'){
					if(k==0)k=2;
					if(k==1){k=0;break;}
				}
			}
			if(k!=0)	return k;
		}
		k=0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(table[j][i]==' '){
					k=0;
					break;
				}
				if(table[j][i]=='x'){
					if(k==0)k=1;
					if(k==2){k=0;break;}
				}
				if(table[j][i]=='o'){
					if(k==0)k=2;
					if(k==1){k=0;break;}
				}
			}
			if(k!=0)	return k;	
		}
		k=0;
		for(int i=0;i<3;i++){
			if(table[i][i]==' '){
				k=0;
				break;
			}
			if(table[i][i]=='x'){
				if(k==0)k=1;
				if(k==2){k=0;break;}
			}
			if(table[i][i]=='o'){
				if(k==0)k=2;
				if(k==1){k=0;break;}
			}
		}
		if(k!=0)return k;
		k=0;
		for(int i=2;i>=0;i--){
			if(table[i][i]==' '){
				k=0;
				break;
			}
			if(table[i][i]=='x'){
				if(k==0)k=1;
				if(k==2){k=0;break;}
			}
			if(table[i][i]=='o'){
				if(k==0)k=2;
				if(k==1){k=0;break;}
			}
		}
		return k;
	}
}
