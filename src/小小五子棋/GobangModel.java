package СС������;

import java.io.Serializable;
import java.util.Arrays;

public class GobangModel implements Serializable {
	private static final long serialVersionUID = 1L;
	static private GobangModel model;//����������󣬵���ģʽ��֤����GobangModel����ͬһ��ֵ
	static private byte[][] chessmanArray=new byte[15][15];//��������
	public final static byte WHITE_CHESSMAN=1;//�����ֵ
	public final static byte BLACK_CHESSMAN=-1;//�����ֵ
	
	public static GobangModel getInstance() {
		//��ȡ����Ķ���modelΪnullʱ�����µĶ���
		if(model==null) {
			model=new GobangModel();
		}
		return model;
	}
	
	private GobangModel() {
		//���췽��
		model=this;
	}
	
	public byte[][] getChessmanArray(){
		//��ȡ��Ŷ���е���������
		return chessmanArray;
	}
	
	@SuppressWarnings("static-access")
	public void setChessmanArray(byte[][] chessmanArray) {
		//�����������飬������������������Ϊ�������������
		this.chessmanArray=chessmanArray;
	}
	
	byte[][] getChessmanArrayCopy(){
		//����һ�ݶ������뵱ǰ�����������ֵ��ͬ�����飬������
		byte[][] newArray=new byte[15][15];
		for(int i=0;i<newArray.length;i++) {
			newArray[i]=Arrays.copyOf(chessmanArray[i], newArray[i].length);
		}
		return newArray;
	}

}
