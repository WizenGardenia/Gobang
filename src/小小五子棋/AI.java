package СС������;

import java.util.Arrays;

public abstract class AI {
	MainFrame frame;// ���������
	private GobangModel gobangModel1;// ����ģ����
	private GobangPanel gobangPanel1;// ���������
	private int boundary ;// ���̱߽�ֵ���������ڲ�׽����ʱ���߽�
	
	public void oprationHandler(Object messageObj) {}
	
	public void chess() {}

	private int[] forEach() {
		int x = -1, y = -1;
		return new int[] { x, y };
	}

	private int[] catchChessModle(int x, int y, byte[][] chessmanArray) {
		int position[] = new int[3];
		return position;
	}

	public int[] judgeModle(int model[]) {
		int piont[] = new int[2];
		return piont;
	}

	private Object[][] getModelLibrary() {
		Object[][] library = new Object[28][3];
		return library;
	}
	
	
}
