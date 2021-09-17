package 小小五子棋;

import java.util.Arrays;

public abstract class AI {
	MainFrame frame;// 主窗体对象
	private GobangModel gobangModel1;// 棋盘模型类
	private GobangPanel gobangPanel1;// 棋盘面板类
	private int boundary ;// 棋盘边界值常量，用于捕捉棋型时填充边界
	
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
