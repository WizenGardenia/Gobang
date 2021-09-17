package 小小五子棋;

import java.io.Serializable;
import java.util.Arrays;

public class GobangModel implements Serializable {
	private static final long serialVersionUID = 1L;
	static private GobangModel model;//定义自身对象，单例模式保证所有GobangModel都是同一个值
	static private byte[][] chessmanArray=new byte[15][15];//棋子数组
	public final static byte WHITE_CHESSMAN=1;//白棋的值
	public final static byte BLACK_CHESSMAN=-1;//黑棋的值
	
	public static GobangModel getInstance() {
		//获取本类的对象，model为null时创建新的对象
		if(model==null) {
			model=new GobangModel();
		}
		return model;
	}
	
	private GobangModel() {
		//构造方法
		model=this;
	}
	
	public byte[][] getChessmanArray(){
		//获取起哦暗中的棋子数组
		return chessmanArray;
	}
	
	@SuppressWarnings("static-access")
	public void setChessmanArray(byte[][] chessmanArray) {
		//载入棋子数组，将参数传来的数据作为本类的棋盘数据
		this.chessmanArray=chessmanArray;
	}
	
	byte[][] getChessmanArrayCopy(){
		//复制一份独立的与当前棋子数组的数值相同的数组，并返回
		byte[][] newArray=new byte[15][15];
		for(int i=0;i<newArray.length;i++) {
			newArray[i]=Arrays.copyOf(chessmanArray[i], newArray[i].length);
		}
		return newArray;
	}

}
